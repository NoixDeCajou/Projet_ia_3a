package imerir.iaproj.gen;

import java.util.ArrayList;

import imerir.iaproj.common.ParseInput;
import imerir.iaproj.common.Trajet;

public class BaseDeTrajets
{
	ArrayList <Trajet> trajets;
	
	public BaseDeTrajets()
	{
		this.trajets = ParseInput.parseFile("C:\\Users\\imerir\\Documents\\Projet_ia_3a\\trunk\\data\\horaires.csv");
	}
}
