package cruzeirao.modelos;

public enum TipoCartao {
	VERMELHO, AMARELO;

	public String toString() {
		switch (this) {
		case VERMELHO:
			return "VERMELHO";
		case AMARELO:
			return "AMARELO";

		}
		return null;
	}
}
