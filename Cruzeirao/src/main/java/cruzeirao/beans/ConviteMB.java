package cruzeirao.beans;

import java.util.ArrayList;
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
import cruzeirao.modelos.User;
import cruzeirao.service.CampService;
import cruzeirao.service.ConviteService;
import cruzeirao.service.EquipeService;
import cruzeirao.service.InscricaoService;
import cruzeirao.service.UserService;

@ManagedBean(name="ConviteMB")
@SessionScoped
public class ConviteMB {
	
	private List<Equipe> equipes = new ArrayList<Equipe>();
	private Equipe equipeAtual = new Equipe();
	private Campeonato campAtual = new Campeonato();
	private Categoria catAtual = new Categoria();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private CampService campService = new CampService();
	private User usuarioAtual = new User();
	private UserDAO user = new UserDAO();
	private EquipeService equipeService = new EquipeService();
	private Inscricao inscricao = new Inscricao();
	private InscricaoService inscService = new InscricaoService();
	private UserService userService = new UserService();
	private ArrayList<User> usuariosList = new ArrayList<User>();
	private Convite convite = new Convite();
	private ConviteService convService = new ConviteService();
	private List<Convite> convites = new ArrayList<Convite>();
	
	public String salvar() {
		inscricao.setEquipe(equipeAtual);
		inscricao.setCategoria(catAtual);
		inscricao.getCategoria().setCampeonato(campAtual);
		
		inscService.salvar(inscricao);
		
		equipeAtual.addInscricao(inscricao);
		equipeService.salvarEditado(equipeAtual);
		
		for(User u: usuariosList) {
			
			convite.setInscricao(inscricao);
			convite.setUsuario(u);
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
	
	public List<Inscricao> getInscricoes(){
		return inscService.getInscricoes();
	}
	public void setUsuariosList(ArrayList<User> usuariosList) {
		this.usuariosList = usuariosList;
	}
	public Equipe getTimeAtual() {
		return equipeAtual;
	}
	public void setEquipeAtual(Equipe time) {
		this.equipeAtual = time;
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
		return usuarioAtual;
	}
	public void setUsuarioAtual(User usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}
	
	public List<Equipe> getTimesUsuarioAtual() {
		usuarioAtual = user.pesquisarPorUsername(usuarioAtual.getUserAtual());
		
		equipes = equipeService.getEquipes();
		
		for(Equipe t : equipes)
		{
			if(t.getDiretor().getNome() != usuarioAtual.getNome())
			{
				equipes.remove(t);
			}
		}
		
		return equipes;
	}
	
	public List<Convite> getConvitesUsuarioAtual() {
		usuarioAtual = user.pesquisarPorUsername(usuarioAtual.getUserAtual());
		
		return usuarioAtual.getConvites();
	}
	
	public List<Equipe> getAllTimes()
	{
		List<Equipe> equipes = equipeService.getEquipes();
		HashSet<Equipe> timesNaoInscritos = new HashSet<Equipe>();
		List<Equipe> listaTimes = new ArrayList<Equipe>();
		
		for(Equipe t : equipes)
		{
			for(Inscricao i : t.getInscricoes())
			{
				if(!i.isValidadas() && !i.getPagamento())
				{
					timesNaoInscritos.add(i.getEquipe());
				}
			}
		}
		
		Iterator<Equipe> i = timesNaoInscritos.iterator();
		
		while(i.hasNext())
		{
			listaTimes.add(i.next());
		}
		return listaTimes;
	}
	
	public List<Inscricao> getInscricoesValidadas(){
		List<Inscricao> inscricoes = new ArrayList<Inscricao>();
		
		for(Inscricao i : inscService.getInscricoes())
		{
			if(i.isValidadas() && i.getPagamento())
			{
				inscricoes.add(i);
			}
		}
		
		return inscricoes;
	}
	
	public void updateCategories()
	{
		categorias = campAtual.getCategorias();
	}
	
	public List<User> getUsuarios(){
		return userService.getUsuarios();
	}
	
	
	public void autorizar(Equipe time) {
		Inscricao insc = null;
		
		for(Inscricao i : time.getInscricoes())
		{
			if(i.getEquipe() == time)
			{
				insc = i;
			}
		}
		insc.setPagamento(true);
		insc.setValidadas(true);
		
		inscService.salvarEditado(insc);
	}
	
	public void remove(Equipe time) {
		Inscricao insc = null;
		
		for(Inscricao i : time.getInscricoes())
		{
			if(i.getEquipe() == time)
			{
				insc = i;
			}
		}
		time.getInscricoes().remove(insc);
		equipeService.salvarEditado(time);
		inscService.salvarEditado(insc);
	}
	
	public void removeConvite(Convite convite) {		
		
		for(Convite c : convite.getUsuario().getConvites())
		{
			if(c == convite)
			{
				usuarioAtual.getConvites().remove(c);
			}
		}
	}
	
	public void autorizarConvite(Convite c) {
		Inscricao inscricao = c.getInscricao();
		User user = c.getUsuario();
		
		inscricao.addJogador(user);
		user.removeConvite(c);
		
		inscService.salvarEditado(inscricao);
		userService.salvarEditado(user);
		convService.remove(c);
	}
	
	
	public List<Convite> getConvites() {
		return convites;
	}
	public void setConvites(List<Convite> convites) {
		this.convites = convites;
	}
}
