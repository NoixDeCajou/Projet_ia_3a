

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;




public class test {

	//Trajet 1 a 44 de la ligne 1
	 /*static Trajet l1_1;
	 static Trajet l1_2;
	 static Trajet l1_3;
	 static Trajet l1_4;
	 static Trajet l1_5;
	 static Trajet l1_6;
	 static Trajet l1_7;
	 static Trajet l1_8;
	 static Trajet l1_9;
	 static Trajet l1_10;
	 static Trajet l1_11;
	 static Trajet l1_12;
	 static Trajet l1_13;
	 static Trajet l1_14;
	 static Trajet l1_15;
	 static Trajet l1_16;
	 static Trajet l1_17;
	 static Trajet l1_18;
	 static Trajet l1_19;
	 static Trajet l1_20;
	 static Trajet l1_21;
	 static Trajet l1_22;
	 static Trajet l1_23;
	 static Trajet l1_24;
	 static Trajet l1_25;
	 static Trajet l1_26;
	 static Trajet l1_27;
	 static Trajet l1_28;
	 static Trajet l1_29;
	 static Trajet l1_30;
	 static Trajet l1_31;
	 static Trajet l1_32;
	 static Trajet l1_33;
	 static Trajet l1_34;
	 static Trajet l1_35;
	 static Trajet l1_36;
	 static Trajet l1_37;
	 static Trajet l1_38;
	 static Trajet l1_39;
	 static Trajet l1_40;
	 static Trajet l1_41;
	 static Trajet l1_42;
	 static Trajet l1_43;
	 static Trajet l1_44;

	 static Trajet l1_45;
	 static Trajet l1_46;
	 static Trajet l1_47;
	 static Trajet l1_48;
	 static Trajet l1_49;
	 static Trajet l1_50;
	 static Trajet l1_51;
	 static Trajet l1_52;
	 static Trajet l1_53;
	 static Trajet l1_54;
	 static Trajet l1_55;
	 static Trajet l1_56;
	 static Trajet l1_57;
	 static Trajet l1_58;
	 static Trajet l1_59;
	 static Trajet l1_60;
	 static Trajet l1_61;
	 static Trajet l1_62;
	 static Trajet l1_63;
	 static Trajet l1_64;
	 static Trajet l1_65;
	 static Trajet l1_66;
	 static Trajet l1_67;
	 static Trajet l1_68;
	 static Trajet l1_69;
	 static Trajet l1_70;
	 static Trajet l1_71;
	 static Trajet l1_72;
	 static Trajet l1_73;
	 static Trajet l1_74;
	 static Trajet l1_75;
	 static Trajet l1_76;
	 static Trajet l1_77;
	 static Trajet l1_78;
	 static Trajet l1_79;
	 static Trajet l1_80;
	 static Trajet l1_81;
	 static Trajet l1_82;
	 static Trajet l1_83;
	 static Trajet l1_84;
	 static Trajet l1_85;*/

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
							
							if((B.getPosition() != null) && (B.getPosition() != T.getDepart()))
							{
								//voir si le bus peut arriver a temps au point de depart


								if(temps < 5){
									temps = 5;
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
	 

	public static void main(String[] args) {

		initialisation();

		Fichier fichierSortie = new Fichier();

		//System.out.println(l1_1.toString());

		//test
		//System.out.println(distance_terminus[23][0]);

		algoGlouton();
		//RechercheTabout();

		//System.out.println(lesBus.size());
		int i = 1;
		int totalKm =0;
		int kmTrajet = 0;
		int testDuree=0;


		for(Bus b : lesBus){
			System.out.print("bus"+i+" : ");
			System.out.println(b.getKilometrageTotal());
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
			
		
			
			
			System.out.print("	nombreTrajet : ");
			System.out.println(b.TrajetParcouru.size());
			++i;
		}

		System.out.println("totalKm = " +totalKm);
		System.out.println("kmTrajet = " +kmTrajet);
		System.out.println("dureeTotal = " +testDuree);
		//System.out.println("dureeTotal = " +dureeTotal);

		fichierSortie.CreationFichier(lesBus, trajets,testDuree,totalKm);

	}
}
