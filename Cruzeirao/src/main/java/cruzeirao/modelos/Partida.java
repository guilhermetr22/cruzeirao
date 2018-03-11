package cruzeirao.modelos;

import java.util.List;

public class Partida {
	private List<Gol> golsMandantes;
	private List<Gol> golsVisitantes;
	private List<Gol> golsPenaltiMandantes;
	private List<Gol> golsPenaltiVisitantes;
	private List<Cartao> cartoesMandante;
	private List<Cartao> cartoesVisitante;
	
	public List<Gol> getGolsMandantes() {
		return golsMandantes;
	}
	public void setGolsMandantes(List<Gol> golsMandantes) {
		this.golsMandantes = golsMandantes;
	}
	public List<Gol> getGolsVisitantes() {
		return golsVisitantes;
	}
	public void setGolsVisitantes(List<Gol> golsVisitantes) {
		this.golsVisitantes = golsVisitantes;
	}
	public List<Gol> getGolsPenaltiMandantes() {
		return golsPenaltiMandantes;
	}
	public void setGolsPenaltiMandantes(List<Gol> golsPenaltiMandantes) {
		this.golsPenaltiMandantes = golsPenaltiMandantes;
	}
	public List<Gol> getGolsPenaltiVisitantes() {
		return golsPenaltiVisitantes;
	}
	public void setGolsPenaltiVisitantes(List<Gol> golsPenaltiVisitantes) {
		this.golsPenaltiVisitantes = golsPenaltiVisitantes;
	}
	public List<Cartao> getCartoesMandante() {
		return cartoesMandante;
	}
	public void setCartoesMandante(List<Cartao> cartoesMandante) {
		this.cartoesMandante = cartoesMandante;
	}
	public List<Cartao> getCartoesVisitante() {
		return cartoesVisitante;
	}
	public void setCartoesVisitante(List<Cartao> cartoesVisitante) {
		this.cartoesVisitante = cartoesVisitante;
	}
	
	
}
