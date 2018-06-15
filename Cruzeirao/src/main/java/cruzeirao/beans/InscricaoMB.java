package cruzeirao.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cruzeirao.DAO.UserDAO;
import cruzeirao.modelos.Campeonato;
import cruzeirao.modelos.Categoria;
import cruzeirao.modelos.Convite;
import cruzeirao.modelos.Equipe;
import cruzeirao.modelos.Inscricao;
import cruzeirao.modelos.Tipo;
import cruzeirao.modelos.User;
import cruzeirao.service.CampService;
import cruzeirao.service.ConviteService;
import cruzeirao.service.EquipeService;
import cruzeirao.service.InscricaoService;
import cruzeirao.service.UserService;

@ManagedBean(name = "InscricaoMB")
@SessionScoped
public class InscricaoMB {
	private List<Equipe> equipes;
	private Equipe equipeAtual = new Equipe();
	private Campeonato campAtual = new Campeonato();
	private Categoria catAtual = new Categoria();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private CampService campService = new CampService();
	private User userAtual = new User();
	private UserDAO user = new UserDAO();
	private EquipeService equipeService = new EquipeService();
	private Inscricao inscricao = new Inscricao();
	private InscricaoService service = new InscricaoService();
	private UserService userService = new UserService();
	private ArrayList<User> usuariosList = new ArrayList<User>();
	private Convite convite = new Convite();
	private ConviteService convService = new ConviteService();
	private List<Convite> convites = new ArrayList<Convite>();
	private Calendar data_cal = Calendar.getInstance();
	
	
	public String salvar()
	{
		inscricao.setEquipe(equipeAtual);
		inscricao.setCategoria(catAtual);
		inscricao.getCategoria().setCampeonato(campAtual);
		
		service.salvar(inscricao);
		
		equipeAtual.addInscricao(inscricao);
		equipeService.salvarEditado(equipeAtual);
		
		for(User u : usuariosList) {
			convite.setInscricao(inscricao);
			convite.setUsuario(u);
			convite.setData(data_cal);
			u.addConvite(convite);
			convService.salvar(convite);
			userService.salvarEditado(u);
			convite = new Convite();
		}
		
		return "inicio";
	}

	public ArrayList<User> getUsuariosList() {
		return usuariosList;
	}

	public List<Inscricao> getInscricoes() {
		return service.getInscricoes();
	}

	public void setUsuariosList(ArrayList<User> usuariosList) {
		this.usuariosList = usuariosList;
	}

	public Equipe getEquipeAtual() {
		return equipeAtual;
	}
	public void setEquipeAtual(Equipe Equipe) {
		this.equipeAtual = Equipe;
	}
	public Campeonato getCampAtual() {
		return campAtual;
	}

	public void setCampAtual(Campeonato campAtual) {
		this.campAtual = campAtual;
	}

	public CampService getCampService() {
		return campService;
	}

	public void setCampService(CampService campService) {
		this.campService = campService;
	}
	public Categoria getCatAtual() {
		return catAtual;
	}

	public void setCatAtual(Categoria catAtual) {
		this.catAtual = catAtual;
	}

	public List<Campeonato> getCampeonatos() {
		return campService.getCampeonatos();
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public User getUsuarioAtual() {
		return userAtual;
	}

	public void setUsuarioAtual(User usuarioAtual) {
		this.userAtual = usuarioAtual;
	}
	
	public List<Equipe> getEquipesUsuarioAtual() {
		userAtual = user.pesquisarPorUsername(userAtual.getUserAtual());
		equipes = equipeService.getEquipes();

		for(Equipe t : equipes) {
			if(t.getDiretor().getUsername() != userAtual.getUsername()) {
				equipes.remove(t);
			}
		}
		
		return equipes;
	}
	
	public List<Convite> getConvitesUsuarioAtual() {
		userAtual = user.pesquisarPorUsername(userAtual.getUserAtual());
		return userAtual.getConvites();
	}
	
	public List<Inscricao> getAllInscricoes() {
		HashSet<Inscricao> inscNotValidated = new HashSet<Inscricao>();
		List<Inscricao> inscricoes = service.getInscricoes();
		List<Inscricao> listaInscricoes = new ArrayList<Inscricao>();
		
		for(Inscricao i : inscricoes)
		{
			if (!i.isValidadas() && !i.getPagamento()) {
				inscNotValidated.add(i);
			}
		}
		
		Iterator<Inscricao> i = inscNotValidated.iterator();

		while (i.hasNext()) {
			listaInscricoes.add(i.next());
		}
		
		return listaInscricoes;
	}
	
	public List<Inscricao> getInscricoesValidadas() {
		List<Inscricao> inscricoes = new ArrayList<Inscricao>();

		for (Inscricao i : service.getInscricoes()) {
			if (i.isValidadas() && i.getPagamento()) {
				inscricoes.add(i);
			}
		}

		return inscricoes;
	}
	
	public void updateCategorias() {
		categorias = campAtual.getCategorias();
	}

	public List<User> getUsuarios() {
		return userService.getUsuarios();
	}
	
	public void remove(Inscricao inscricao) {
		
		Equipe t = null;
		
		for (Inscricao i : service.getInscricoes()) {
			if(i.getEquipe() == inscricao.getEquipe())
			{
				t = i.getEquipe();
			}
		}
		
		t.removeInscricao(inscricao);
		equipeService.salvarEditado(t);
		service.remove(inscricao);
	}
	
	public void autorizar(Inscricao inscricao) {

		inscricao.setPagamento(true);
		inscricao.setValidadas(true);

		service.salvarEditado(inscricao);
	}
	
	public void removeConvite(Convite convite) {
		User user = convite.getUsuario();

		for (Convite c : convite.getUsuario().getConvites()) {
			if (c == convite) {
				user.removeConvite(c);
				break;
			}
		}
		
		userService.salvarEditado(user);
		convService.remove(convite);
	}
	
	public void autorizarConvite(Convite c) {
		Inscricao inscricao = c.getInscricao();
		User user = c.getUsuario();

		user.setTipo(Tipo.JOGADOR);
		inscricao.addJogador(user);
		user.removeConvite(c);

		service.salvarEditado(inscricao);
		userService.salvarEditado(user);
		convService.remove(c);
	}
	
	public List<User> getTodosMenosDiretor() {
		List<User> users = userService.getUsuarios();
		userAtual = user.pesquisarPorUsername(userAtual.getUsername());
		User aux = null;

		for (User u : users) {
			if (u.getUsername() == userAtual.getUsername())
				aux = u;
		}

		users.remove(aux);
		return users;
	}
	
	public List<Convite> getConvites() {
		return convites;
	}

	public void setConvites(List<Convite> convites) {
		this.convites = convites;
	}
}
