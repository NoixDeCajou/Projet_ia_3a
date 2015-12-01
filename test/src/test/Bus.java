package test;

import java.util.ArrayList;

public class Bus {

	boolean disponible;

	int kilometrageTrajet;
	int kilometrageTotal;
	int heureArrive;

	public int getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(int heureArrive) {
		this.heureArrive = heureArrive;
	}

	String position;

	ArrayList<Trajet> TrajetParcouru;


	public ArrayList<Trajet> getTrajetParcouru() {
		return TrajetParcouru;
	}

	public void setTrajetParcouru(ArrayList<Trajet> TrajetParcouru) {
		this.TrajetParcouru = TrajetParcouru;
	}

	public Bus(boolean disponible) {
		super();
		this.disponible = disponible;
		this.kilometrageTotal=0;
		this.kilometrageTrajet=0;
		TrajetParcouru = new ArrayList<Trajet>();
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
		return "Bus [disponible=" + disponible + ", kilometrageTrajet="
				+ kilometrageTrajet + ", kilometrageTotal=" + kilometrageTotal
				+ ", position=" + position + ", TrajetParcouru="
				+ TrajetParcouru + "]";
	}



}
