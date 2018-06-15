package cruzeirao.modelos;

public enum TipoFase {
	MATAMATA, PONTOSCORRIDOS;

	public String toString() {
		switch (this) {
		case MATAMATA:
			return "MATAMATA";
		case PONTOSCORRIDOS:
			return "PONTOSCORRIDOS";

		}
		return null;
	}
}
