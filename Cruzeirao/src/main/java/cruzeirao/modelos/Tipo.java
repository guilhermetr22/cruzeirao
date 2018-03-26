package cruzeirao.modelos;

public enum Tipo {
	ADMIN, DIRETOR, COMUM, TECNICO, JUIZ, JOGADOR;

	public String toString() {
		switch (this) {
		case ADMIN:
			return "ADMIN";
		case DIRETOR:
			return "DIRETOR";
		case COMUM:
			return "COMUM";
		case TECNICO:
			return "TECNICO";
		case JUIZ:
			return "JUIZ";
		case JOGADOR:
			return "JOGADOR";
		}
		return null;
	}
}
