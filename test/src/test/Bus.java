package test;

import java.util.ArrayList;

public class Bus {

	boolean disponible;

	int kilometrageVoyage;
	int kilometrageTotal;

	String position;

	ArrayList<Voyage> VoyageParcouru;


	public ArrayList<Voyage> getVoyageParcouru() {
		return VoyageParcouru;
	}

	public void setVoyageParcouru(ArrayList<Voyage> VoyageParcouru) {
		this.VoyageParcouru = VoyageParcouru;
	}

	public Bus(boolean disponible) {
		super();
		this.disponible = disponible;
		this.kilometrageTotal=0;
		this.kilometrageVoyage=0;
		VoyageParcouru = new ArrayList<Voyage>();
	}

	public Bus() {
		// TODO Auto-generated constructor stub
	}

	public int getKilometrageVoyage() {
		return kilometrageVoyage;
	}

	public void setKilometrageVoyage(int kilometrageVoyage) {
		this.kilometrageVoyage = kilometrageVoyage;
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
