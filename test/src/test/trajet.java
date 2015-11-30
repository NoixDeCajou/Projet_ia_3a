package test;

public class trajet {

	String depart;
	String arrive;
	int hDepart;
	int hArrive;
	int bus;
	int ligne;
	
	
	
	//Constructeur
	public trajet(String depart, String arrive, int hDepart, int hArrive,
			int bus, int ligne) {
		super();
		this.depart = depart;
		this.arrive = arrive;
		this.hDepart = hDepart;
		this.hArrive = hArrive;
		this.bus = bus;
		this.ligne = ligne;
	}
	
	@Override
	public String toString() {
		return "trajet [depart=" + depart + ", arrive=" + arrive + ", hDepart="
				+ hDepart + ", hArrive=" + hArrive + ", bus=" + bus
				+ ", ligne=" + ligne + "]";
	}

	//Getters et Setter
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getArrive() {
		return arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public int gethDepart() {
		return hDepart;
	}
	public void sethDepart(int hDepart) {
		this.hDepart = hDepart;
	}
	public int gethArrive() {
		return hArrive;
	}
	public void sethArrive(int hArrive) {
		this.hArrive = hArrive;
	}
	public int getBus() {
		return bus;
	}
	public void setBus(int bus) {
		this.bus = bus;
	}
	public int getLigne() {
		return ligne;
	}
	public void setLigne(int ligne) {
		this.ligne = ligne;
	} 
	
	
	
}
