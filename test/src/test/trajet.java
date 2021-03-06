package test;

public class Trajet {

	String depart;
	String arrive;
	int hDepart;
	int hArrive;
	Bus bus;
	int ligne;
	char sens;
	int distance;
	int numeroArret;

	private boolean firstSet;


	public int getNumeroArret() {
		return numeroArret;
	}

	public void setNumeroArret(int numeroArret) {
		this.numeroArret = numeroArret;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	//Constructeur
	public Trajet(String depart, String arrive, int hDepart, int hArrive,
			 int ligne, char sens, boolean firstSet , int dist, int numeroArret) {
		super();
		this.depart = depart;
		this.arrive = arrive;
		this.hDepart = hDepart;
		this.hArrive = hArrive;
		//this.bus = bus;
		this.ligne = ligne;
		this.sens = sens;
		this.distance = dist;
		this.numeroArret = numeroArret;

		this.firstSet = firstSet;

	}

	public Trajet(String depart, String arrive, int hDepart, int hArrive,
			 int ligne, char sens , int dist, int numeroArret) {
		this(depart, arrive, hDepart, hArrive,
				 ligne, sens, true , dist, numeroArret);
	}

	@Override
	public String toString() {
		return
				"Trajet [depart="
				+ depart
				+ ", arrive="
				+ arrive
				+ ", hDepart="
				+ hDepart
				+ ", hArrive="
				+ hArrive
				+ ", bus="
				+ bus
				+ ", sens="
				+ sens
				+ ", ligne="
				+ ligne
				+ ", dist="
				+ distance
				+ ", numeroArret="
				+ numeroArret
				+ "]";
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
	public int getSens() {
		return sens;
	}
	public void sethArrive(int hArrive) {
		this.hArrive = hArrive;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public int getLigne() {
		return ligne;
	}
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	public void setSens(char sens) {
		this.sens = sens;
	}


	public boolean getFirstSet() {
		return firstSet;
	}

	public void setFirstSet(boolean firstSet) {
		this.firstSet = firstSet;
	}


}
