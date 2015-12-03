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
		ArrayList <ArrayList <int[]>> horraires = new ArrayList <ArrayList <int[]>>();
		int cpt=0;
		
		//Initialisation du tableau des horraires indisponnibles pour chaque bus
		while(cpt<numerosBus.size())
		{
			horraires.add(new ArrayList<int[]>());
			cpt++;
		}
		
		cpt=0;
		while(cpt<numerosBus.size())
		{
			//Création d'une fourchette d'indisponnibilité pour un bus
			int[] departArrive=new int[2];
			departArrive[0]=BaseDeTrajets.getTrajets().get(cpt).gethDepart();
			departArrive[1]=BaseDeTrajets.getTrajets().get(cpt).gethArrive()+5;
			
			if(disponnibiliteBus(numerosBus.get(cpt), departArrive, horraires))
			{
				return false;
			}
			
			//Ajout de cette indisponnibilité à celles du bus selectionné
			horraires.get(numerosBus.get(cpt)).add(departArrive);
			
			cpt++;
		}
		
		return true;
	}

	private boolean disponnibiliteBus(Integer numeroBus, int[] departArrive, ArrayList<ArrayList<int[]>> horraires)
	{
		for(int[] indisponibilite : horraires.get(numeroBus.intValue()))
		{
			if(departArrive[0]<=indisponibilite[1] && departArrive[0]>=indisponibilite[0])
			{
				return false;
			}
			
			if(departArrive[1]<=indisponibilite[1] && departArrive[1]>=indisponibilite[0])
			{
				return false;
			}
			
			if(indisponibilite[0]>=departArrive[0] && indisponibilite[0]<=departArrive[1])
			{
				return false;
			}
		}
				
		return true;
	}

	public void mutation() // fait muter un individu
	{
		numerosBus.set(randomGenerator.nextInt(numerosBus.size()),randomGenerator.nextInt(numerosBus.size()));
	}

	public ArrayList<Integer> getNumerosBus() {
		return numerosBus;
	}

}
