package imerir.iaproj.gen;

import java.net.URL;
import java.util.ArrayList;

import imerir.iaproj.common.ParseInput;
import imerir.iaproj.common.Trajet;

public class BaseDeTrajets
{
	static ArrayList <Trajet> trajets;

	public static void prepareTrajets(){

		URL u = BaseDeTrajets.class.getClassLoader().getResource("horaires.csv");

		trajets = ParseInput.parseFile( u );

	}

	public static ArrayList <Trajet> getTrajets()
	{
		return trajets;

	}

	public static void main(String[] args) {

		BaseDeTrajets.prepareTrajets();
	}
}
