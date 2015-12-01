package test;

import java.util.ArrayList;

public class Bus {
	
	boolean disponible;
	
	int kilometrageTrajet;
	int kilometrageTotal;
	
	String position;
	
	ArrayList<Trajet> trajetParcouru;
	

	public ArrayList<Trajet> getTrajetParcouru() {
		return trajetParcouru;
	}

	public void setTrajetParcouru(ArrayList<Trajet> trajetParcouru) {
		this.trajetParcouru = trajetParcouru;
	}

	public Bus(boolean disponible) {
		super();
		this.disponible = disponible;
		this.kilometrageTotal=0;
		this.kilometrageTrajet=0;
		trajetParcouru = new ArrayList<Trajet>();
	}

	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public int getKilometrageTrajet() {
		return kilometrageTrajet;
	}

	public void setKilometrageTrajet(int kilometrageTrajet) {
		this.kilometrageTrajet = kilometrageTrajet;
	}

	public int getKilometrageTotal() {
		return kilometrageTotal;
	}

	public void setKilometrageTotal(int kilometrageTotal) {
		this.kilometrageTotal = kilometrageTotal;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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
