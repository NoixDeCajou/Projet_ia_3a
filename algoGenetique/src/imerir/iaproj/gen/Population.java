package imerir.iaproj.gen;

import java.util.ArrayList;
import java.util.Random;

public class Population {

	// individus hermaphrodites

	private ArrayList <Individu> individus;
	private int taillePopulation = 100;
	private float chanceDeMuter = 0.02f;
	private float proportionDeReproduction = 0.6f;

	Random r = new Random();

	public static void main(String[] args) {

		Population p = new Population();

		for(int i = 0; i<5000; i++){

			p.evolve();

		}

		System.out.println( p.getBestIndividu().getFitness());

	}

	public Population() { // genère une population aleatoire


		BaseDeTrajets.prepareTrajets();

		individus = new ArrayList <Individu>();

		for(int i = 0; i < taillePopulation; i++){

			individus.add( new Individu() ); // new individu random

		}

	}

	private Individu getBestIndividu(){

		Individu best = null;
		int bestFitness = Integer.MAX_VALUE;

		for(Individu i : individus){

			i.calculateFitness();

			if(i.getFitness() < bestFitness){

				bestFitness = i.getFitness();
				best = i;
			}

		}

		return best;

	}

	public void evolve(){ // fait evoluer la population de la generation actuelle à la generation suivante

		this.selection();

		this.repopulation();
	}

	private void selection(){ // selectionne les individus survivants et tue les autres

		int totalFitness = 0;

		// lancer le calcul de la fitness pour tout le monde et calculer le total
		for(Individu i : individus){

			i.calculateFitness();
			int f = i.getFitness();
			totalFitness += f;
			System.out.println("totalFitness: " + totalFitness);


		}

		System.out.println("totalFitness: " + totalFitness);
		System.out.println( "taillepop attendu: " + Math.round(proportionDeReproduction * taillePopulation) );

		for(int i = 0; i < Math.round(proportionDeReproduction * taillePopulation); i++ ){ // a chaque entree dans la boucle on choisi un individu

			int fitnessCible = r.nextInt(totalFitness); // random entre 0 et totalfitness -1

			System.out.println("fitnessCible: " + fitnessCible);

			int total = 0;
			int j = 0;
			while(total < fitnessCible){

				total += individus.get(j).getFitness();
				j++;
			}

			totalFitness -= individus.get(j-1).getFitness();
			individus.remove(j-1);

		}

		System.out.println( "taillepop: " + individus.size() );


	}

	private void repopulation() { // regenère la population jusqu'à taillePopulation, en effectuant des croisements entre les individus

		ArrayList <Individu> nouveauxIndividus = new ArrayList<Individu>();

		while( (individus.size() + nouveauxIndividus.size()) < taillePopulation ){

			// tirer au sort 2 personnes de la population

			Individu f = individus.get(r.nextInt(individus.size()));

			Individu m = individus.get(r.nextInt(individus.size()));

			Individu nouveauNe = new Individu(f, m, false);

			// mutation
			if( r.nextFloat() < chanceDeMuter ){

				nouveauNe.mutation();
			}

			nouveauxIndividus.add(nouveauNe);

		}

		individus.addAll(nouveauxIndividus);

	}
}
