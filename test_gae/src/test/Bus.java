package test;

public class Bus {
	
	boolean disponible;

	public Bus(boolean disponible) {
		super();
		this.disponible = disponible;
	}

	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Bus [disponible=" + disponible + "]";
	}

}
