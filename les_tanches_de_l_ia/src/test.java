

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import java.util.Collections;


public class test {


	static  ArrayList<Trajet> trajets;
	static  ArrayList<Bus> lesBus;

	static int[][] distance_terminus;
	static int[][] temps_terminus;

	static int dureeTotal = 0;

	 static int indiceTerminus(String terminus){
		return Integer.valueOf(terminus.substring(1));
	 }

	 static void initialisation()
	{
		
			
		 ParseInput pi = new ParseInput();
	
		trajets = pi.parseFile("horaires.csv");

		lesBus = new ArrayList<Bus>();

		temps_terminus=new int[24][24];
		distance_terminus=new int[24][24];
		
		//tableau avec les distances entre terminus
		try (CSVReader reader = new CSVReader(new BufferedReader(
		          new FileReader("distance.csv")));) {

		    List<String[]> lines = reader.readAll();
		    int i=0;
		    int j=0;
		    for(String[] s : lines)
		    {
		    	for(String ss : s )
		    	{
		    		distance_terminus[i][j]=Integer.valueOf(ss);
		    		++j;
		    	}
		    	j=0;
		    	++i;
		    }
		    //System.out.println(temps_terminus.get(23)[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//tableau avec les temps entre terminus

		try (CSVReader reader = new CSVReader(new BufferedReader(
		          new FileReader("temps.csv")));) {

		    List<String[]> lines = reader.readAll();
		    int i=0;
		    int j=0;
		    for(String[] s : lines)
		    {
		    	for(String ss : s )
		    	{
		    		temps_terminus[i][j]=Integer.valueOf(ss);
		    		++j;
		    	}
		    	j=0;
		    	++i;
		    }
		    //System.out.println(temps_terminus.get(23)[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		//System.out.println("TEMPS POUR FAIRE T5 -> T9 : "+ temps_terminus[7][18]);

	}
	
	public static void algoGlouton2()
	{
		//on parcour les heures de la journée (à partir de 5h00)
				for(int i=300;i<1440;++i)
				{
					//on parcours les heures de departs des Trajets + les heures d'arrive
					for(Trajet T: trajets)
					{
						//on cherche un bus dispo pour l'heure de depart
						//TODO vérifier que le bus peut faire le Trajet interligne dans les temps
						if(T.gethDepart()==i)
						{
							boolean unBusDispo=false;
							for(Bus B: lesBus)
							{

								//System.out.println(B.getPosition());

								if(B.isDisponible() && !unBusDispo)
								{
									int indice = indiceTerminus(B.getPosition());
									int destination = indiceTerminus(T.getDepart());
									int temps = temps_terminus[indice][destination];
									
									B.tempsAvantTrajet=temps;
									
									if((B.getPosition() != null) && (B.getPosition() != T.getDepart()))
									{
										//voir si le bus peut arriver a temps au point de depart


										if(temps < 5){
											temps = 5;
											B.tempsAvantTrajet=temps;
										}
										
										if(T.gethDepart() >= B.heureArrive+temps )
										{
											B.setDisponible(false);
											unBusDispo=true;
											T.setBus(B);
											B.getTrajetParcouru().add(T);
											int busKm = B.getKilometrageTotal();
											B.setKilometrageTotal(busKm + distance_terminus[indiceTerminus(B.getPosition())][indiceTerminus(T.getDepart())]);
											dureeTotal += temps;
											//System.out.println("Temps de position() à prochain depart : "+temps);
										}
									}else if ((B.getPosition() == T.getDepart()) && ((T.gethDepart() - B.heureArrive) >= 5))
									{
										B.setDisponible(false);
										unBusDispo=true;
										T.setBus(B);
										B.getTrajetParcouru().add(T);
										dureeTotal += 5;
										//System.out.println("Temps de batement : "+5);
									}
										
								}
								
							}
								 
							
							

							//on cree un bus si aucun bus dispo
							if(unBusDispo==false)
							{
								Bus nouveauxBus= new Bus(false);
								lesBus.add(nouveauxBus);
								T.setBus(nouveauxBus);
								nouveauxBus.setPosition(T.getDepart());
								nouveauxBus.getTrajetParcouru().add(T);
								int busKm = nouveauxBus.getKilometrageTotal();
								nouveauxBus.setKilometrageTotal(busKm + distance_terminus[0][indiceTerminus(T.getDepart())]);
								//System.out.println(nouveauxBus.getKilometrageTotal());
								dureeTotal += temps_terminus[0][indiceTerminus(T.getDepart())];
								//System.out.println("Temps de depot à prochain depart : "+temps_terminus[0][indiceTerminus(T.getDepart())]);

							}
							
							//on vas mélanger les bus aléatoirement
							Collections.shuffle(lesBus);

						}


						//on regarde si un Trajet se termine
						if(T.gethArrive()==i/*-5*/)
						{
							T.getBus().setDisponible(true);
							T.getBus().setPosition(T.getArrive());
							int kilometrageTotal = T.getBus().getKilometrageTotal();
							T.getBus().setKilometrageTotal(kilometrageTotal + T.getDistance());
							int kilometrageTrajet = T.getBus().getKilometrageTrajet();
							T.getBus().setKilometrageTrajet(kilometrageTrajet + T.getDistance());
							T.getBus().setHeureArrive(i);

							//maj variable duree total
							dureeTotal += T.gethArrive()-T.gethDepart();
							//System.out.println("Temps de trajet : "+ (T.gethArrive()-T.gethDepart()));

							T.setBus(null);



						}

					}
					//on melange les trajets
					Collections.shuffle(trajets);


				}
	}
	 
	public static void algoGlouton()
	{
		
		//on parcour les heures de la journée (à partir de 5h00)
		for(int i=300;i<1440;++i)
		{
			//on parcours les heures de departs des Trajets + les heures d'arrive
			for(Trajet T: trajets)
			{
				//on cherche un bus dispo pour l'heure de depart
				//TODO vérifier que le bus peut faire le Trajet interligne dans les temps
				if(T.gethDepart()==i)
				{
					boolean unBusDispo=false;
					for(Bus B: lesBus)
					{

						//System.out.println(B.getPosition());

						if(B.isDisponible() && !unBusDispo)
						{
							int indice = indiceTerminus(B.getPosition());
							int destination = indiceTerminus(T.getDepart());
							int temps = temps_terminus[indice][destination];
							
							B.tempsAvantTrajet=temps;
							
							if((B.getPosition() != null) && (B.getPosition() != T.getDepart()))
							{
								//voir si le bus peut arriver a temps au point de depart


								if(temps < 5){
									temps = 5;
									B.tempsAvantTrajet=temps;
								}
								
								if(T.gethDepart() >= B.heureArrive+temps )
								{
									B.setDisponible(false);
									unBusDispo=true;
									T.setBus(B);
									B.getTrajetParcouru().add(T);
									int busKm = B.getKilometrageTotal();
									B.setKilometrageTotal(busKm + distance_terminus[indiceTerminus(B.getPosition())][indiceTerminus(T.getDepart())]);
									dureeTotal += temps;
									//System.out.println("Temps de position() à prochain depart : "+temps);
								}
							}else if ((B.getPosition() == T.getDepart()) && ((T.gethDepart() - B.heureArrive) >= 5))
							{
								B.setDisponible(false);
								unBusDispo=true;
								T.setBus(B);
								B.getTrajetParcouru().add(T);
								dureeTotal += 5;
								//System.out.println("Temps de batement : "+5);
							}
								
						}
						
					}
					
					

					//on cree un bus si aucun bus dispo
					if(unBusDispo==false)
					{
						Bus nouveauxBus= new Bus(false);
						lesBus.add(nouveauxBus);
						T.setBus(nouveauxBus);
						nouveauxBus.setPosition(T.getDepart());
						nouveauxBus.getTrajetParcouru().add(T);
						int busKm = nouveauxBus.getKilometrageTotal();
						nouveauxBus.setKilometrageTotal(busKm + distance_terminus[0][indiceTerminus(T.getDepart())]);
						//System.out.println(nouveauxBus.getKilometrageTotal());
						dureeTotal += temps_terminus[0][indiceTerminus(T.getDepart())];
						//System.out.println("Temps de depot à prochain depart : "+temps_terminus[0][indiceTerminus(T.getDepart())]);

					}
				}


				//on regarde si un Trajet se termine
				if(T.gethArrive()==i/*-5*/)
				{
					T.getBus().setDisponible(true);
					T.getBus().setPosition(T.getArrive());
					int kilometrageTotal = T.getBus().getKilometrageTotal();
					T.getBus().setKilometrageTotal(kilometrageTotal + T.getDistance());
					int kilometrageTrajet = T.getBus().getKilometrageTrajet();
					T.getBus().setKilometrageTrajet(kilometrageTrajet + T.getDistance());
					T.getBus().setHeureArrive(i);

					//maj variable duree total
					dureeTotal += T.gethArrive()-T.gethDepart();
					//System.out.println("Temps de trajet : "+ (T.gethArrive()-T.gethDepart()));

					T.setBus(null);



				}

			}



		}
		
	}
	
	
	static void solutionVoisine()
	{
		
	}
	
	static void RechercheTabout()
	{
		//premiere etape, on genere la plus mauvaise solution : 539bus pour 539voyage
		for(Trajet T: trajets)
		{
			Bus nouveauxBus= new Bus(false);
			lesBus.add(nouveauxBus);
			T.setBus(nouveauxBus);
			nouveauxBus.setPosition(T.getDepart());
			nouveauxBus.getTrajetParcouru().add(T);
			nouveauxBus.setKilometrageTotal(distance_terminus[0][indiceTerminus(T.getDepart())]);
			//System.out.println(nouveauxBus.getKilometrageTotal());
			dureeTotal += temps_terminus[0][indiceTerminus(T.getDepart())];
		}
		
		//la solution est valide, on vas chercher à l'ameliorer
		ArrayList<ArrayList<Integer>> listeTaboue;
		listeTaboue = new ArrayList<ArrayList<Integer>>();
		int nombreDeBus = 34;
		ArrayList<Integer> meilleurSolution = new ArrayList<Integer>();
		
		
		while(nombreDeBus >= 34){
			ArrayList<Integer> meilleurCandidat = new ArrayList<Integer>();
			
		}
		
	}
	 
	static void RechercheRandom()
	{
		
	}

	public static void main(String[] args) {

		
		int soluceMax=539;
		
		for(int m=0;m<1000000;m++)
		{
			
			initialisation();
			
			Fichier fichierSortie = new Fichier();

			//System.out.println(l1_1.toString());

			//test
			//System.out.println(distance_terminus[23][0]);

			algoGlouton2();
			//RechercheTabout();

			System.out.println(lesBus.size());
			if (lesBus.size()<soluceMax)
			{
				soluceMax=lesBus.size();
			}
			int i = 1;
			int totalKm =0;
			int kmTrajet = 0;
			int testDuree=0;


			for(Bus b : lesBus){
				//System.out.print("bus"+i+" : ");
				//System.out.println(b.getKilometrageTotal());
				totalKm += b.getKilometrageTotal();
				kmTrajet += b.getKilometrageTrajet();
				
				//retour depot
				//distance
				Trajet dernierTrajet = b.getTrajetParcouru().get(b.TrajetParcouru.size() - 1);
				int arriverDernierTrajet = indiceTerminus(dernierTrajet.getArrive());
				totalKm += distance_terminus[arriverDernierTrajet][0];
				//temps
				dureeTotal += temps_terminus[arriverDernierTrajet][0];
				//System.out.println("Temps pour lastarrivé -> depot : " +temps_terminus[arriverDernierTrajet][0] );
					
				//premier trajet
				Trajet premierTrajet = b.getTrajetParcouru().get(0);
				int departPremierTrajet = indiceTerminus(premierTrajet.getDepart());
				testDuree += (dernierTrajet.gethArrive() - premierTrajet.gethDepart());
				testDuree += temps_terminus[arriverDernierTrajet][0];
				testDuree += temps_terminus[0][departPremierTrajet];
				
			
				
				
				//System.out.print("	nombreTrajet : ");
				//System.out.println(b.TrajetParcouru.size());
				++i;
			}

			//System.out.println("totalKm = " +totalKm);
			//System.out.println("kmTrajet = " +kmTrajet);
			//System.out.println("dureeTotal = " +testDuree);
			//System.out.println("dureeTotal = " +dureeTotal);

			
			System.out.println("version "+m);
			System.out.println("Best "+soluceMax);
			if(soluceMax==lesBus.size())
			{
				fichierSortie.CreationFichier(lesBus, trajets,testDuree,totalKm,m);
			}
		}

		

	}
}
