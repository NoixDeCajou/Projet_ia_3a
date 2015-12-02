package imerir.iaproj.gen;

import java.util.ArrayList;
import java.util.Random;

public class Individu
{

	ArrayList <Integer> numerosBus;
	Random randomGenerator = new Random();
	int fitness = Integer.MAX_VALUE;

	public int getFitness(){

		return fitness;

	}

	public void calculateFitness() {
		// TODO Auto-generated method stub

	}

	public int fitness()
	{
		if( this.checkValidite() )
		{
			return countBus();
		}
		else
		{
			return Integer.MAX_VALUE;
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


}
