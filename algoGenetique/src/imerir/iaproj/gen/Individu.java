package imerir.iaproj.gen;

import java.util.ArrayList;
import java.util.Random;

public class Individu
{
	private ArrayList <Integer> numerosBus;
	private Random randomGenerator = new Random();
	private int fitness = Integer.MAX_VALUE;

	public Individu() // individu genéré aleatoirement
	{
		numerosBus = new ArrayList<Integer>();

		int cpt=0;

		while(cpt<BaseDeTrajets.getTrajets().size())
		{
			int i = randomGenerator.nextInt(BaseDeTrajets.getTrajets().size());

			numerosBus.add( new Integer(i) );

			cpt++;
		}
	}



	public Individu(Individu father, Individu mother, boolean method){


		numerosBus = new ArrayList<Integer>();


		//if( method == false ){ // 1 point crossover
		//}
		//else if(method == true){ // n point crossover
		//}


		// 1 point crossover pour tout le monde pour l'instant


		int nbGenes = BaseDeTrajets.getTrajets().size();

		int numberOfGenesFromFather = randomGenerator.nextInt( nbGenes );

		for(int i = 0; i < numberOfGenesFromFather; i++){ // le nombre de genes tirés du père sont pris

			numerosBus.add( father.getNumerosBus().get(i) );

		}

		for(int i = numberOfGenesFromFather; i < nbGenes; i++){ // le reste des genes sont pris de la mère

			numerosBus.add( mother.getNumerosBus().get(i) );
		}


	}

	public int getFitness(){
		return fitness;
	}

	public void calculateFitness() {

		if( this.checkValidite() )
		{
			fitness = countBus();
		}
		else
		{
			fitness = Integer.MAX_VALUE;
		}
	}

	private int countBus()
	{
		ArrayList <Integer> numerosBusCount = new ArrayList <Integer>();
		int cpt=0;

		for(Integer i : numerosBus)
		{
			if(!numerosBusCount.contains(i))
			{
				numerosBusCount.add(i);
				cpt++;
			}
		}

		return cpt;
	}

	private boolean checkValidite()
	{


		return false;
	}

	public void mutation() // fait muter un individu
	{
		numerosBus.set(randomGenerator.nextInt(numerosBus.size()),randomGenerator.nextInt(numerosBus.size()));
	}

	public ArrayList<Integer> getNumerosBus() {
		return numerosBus;
	}

}
