package imerir.iaproj.gen;

import java.util.ArrayList;

public class Population {

	ArrayList <Individu> individus;
	int taillePopulation = 100;
	double chanceDeMuter=0.01;

	public Population() { // gen�re une population aleatoire

		individus = new ArrayList <Individu>();

		for(int i = 0; i < taillePopulation; i++){

			individus.add( new Individu() );

		}

	}

	void evolve(){ // fait evoluer la population de la generation actuelle � la generation suivante


	}

	void selection(){ // selectionne les individus survivants et tue les autres


	}

	void repopulation() { // regen�re la population jusqu'� la taille definie, en effectuant des croisements entre les individus


	}
}
