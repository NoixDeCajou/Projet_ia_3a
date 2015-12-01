package test;

public class Voyage {

	private String terminusDepart;
	private String terminusArrive;

	private int hDepart;
	private int hArrive;

	//private String hDepart;
	//private String hArrive;

	private Bus bus;

	private int ligne;

	//private String ligne;


	private boolean firstSet;

	//Constructeur
	public Voyage(String terminusDepart, String terminusArrive, int hDepart, int hArrive,
			Bus bus, int ligne, boolean firstSet) {
		super();
		this.terminusDepart = terminusDepart;
		this.terminusArrive = terminusArrive;
		this.hDepart = hDepart;
		this.hArrive = hArrive;
		this.bus = bus;
		this.ligne = ligne;


		this.setFirstSet(firstSet);
	}

	public Voyage(String terminusDepart, String terminusArrive, int hDepart, int hArrive,
			Bus bus, int ligne) {

		this(terminusDepart, terminusArrive, hDepart, hArrive,
				bus, ligne, true);

	}

	@Override
	public String toString() {
		return "voyage [depart=" + terminusDepart + ", arrive=" + terminusArrive + ", hDepart="
				+ hDepart + ", hArrive=" + hArrive + ", bus=" + bus
				+ ", ligne=" + ligne + "]";
	}

	//Getters et Setter
	public String getDepart() {
		return terminusDepart;
	}
	public void setDepart(String terminusDepart) {
		this.terminusDepart = terminusDepart;
	}
	public String getArrive() {
		return terminusArrive;
	}
	public void setArrive(String terminusArrive) {
		this.terminusArrive = terminusArrive;
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


	public boolean getFirstSet() {
		return firstSet;
	}

	public void setFirstSet(boolean firstSet) {
		this.firstSet = firstSet;
	}



}
