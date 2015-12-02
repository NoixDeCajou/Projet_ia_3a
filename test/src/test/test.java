package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;




public class test {

	//Trajet 1 a 44 de la ligne 1
	 static Trajet l1_1;
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
	 static Trajet l1_85;

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
			//aller
			l1_1 = new Trajet("T1","T2",371,408,1,'a',10,0);
			l1_2 = new Trajet("T1","T2",394,431,1,'a',10,0);
			l1_3 = new Trajet("T1","T2",416,453,1,'a',10,0);
			l1_4 = new Trajet("T1","T2",436,473,1,'a',10,0);
			l1_5 = new Trajet("T1","T2",456,493,1,'a',10,0);
			l1_6 = new Trajet("T1","T2",476,513,1,'a',10,0);
			l1_7 = new Trajet("T1","T2",496,533,1,'a',10,0);
			l1_8 = new Trajet("T1","T2",516,553,1,'a',10,0);
			l1_9 = new Trajet("T1","T2",536,573,1,'a',10,0);
			l1_10 = new Trajet("T1","T2",556,593,1,'a',10,0);
			l1_11 = new Trajet("T1","T2",576,613,1,'a',10,0);
			l1_12 = new Trajet("T1","T2",596,633,1,'a',10,0);
			l1_13 = new Trajet("T1","T2",616,653,1,'a',10,0);
			l1_14 = new Trajet("T1","T2",636,673,1,'a',10,0);
			l1_15 = new Trajet("T1","T2",656,693,1,'a',10,0);
			l1_16 = new Trajet("T1","T2",676,713,1,'a',10,0);
			l1_17 = new Trajet("T1","T2",696,733,1,'a',10,0);
			l1_18 = new Trajet("T1","T2",716,753,1,'a',10,0);
			l1_19 = new Trajet("T1","T2",736,773,1,'a',10,0);
			l1_20 = new Trajet("T1","T2",756,793,1,'a',10,0);
			l1_21 = new Trajet("T1","T2",776,813,1,'a',10,0);
			l1_22 = new Trajet("T1","T2",796,833,1,'a',10,0);
			l1_23 = new Trajet("T1","T2",816,853,1,'a',10,0);
			l1_24 = new Trajet("T1","T2",836,873,1,'a',10,0);
			l1_25 = new Trajet("T1","T2",856,893,1,'a',10,0);
			l1_26 = new Trajet("T1","T2",876,913,1,'a',10,0);
			l1_27 = new Trajet("T1","T2",896,933,1,'a',10,0);
			l1_28 = new Trajet("T1","T2",916,953,1,'a',10,0);
			l1_29 = new Trajet("T1","T2",936,973,1,'a',10,0);
			l1_30 = new Trajet("T1","T2",956,993,1,'a',10,0);
			l1_31 = new Trajet("T1","T2",976,1013,1,'a',10,0);
			l1_32 = new Trajet("T1","T2",996,1033,1,'a',10,0);
			l1_33 = new Trajet("T1","T2",1016,1053,1,'a',10,0);
			l1_34 = new Trajet("T1","T2",1036,1073,1,'a',10,0);
			l1_35 = new Trajet("T1","T2",1056,1093,1,'a',10,0);
			l1_36 = new Trajet("T1","T2",1076,1113,1,'a',10,0);
			l1_37 = new Trajet("T1","T2",1096,1133,1,'a',10,0);
			l1_38 = new Trajet("T1","T2",1116,1153,1,'a',10,0);
			l1_39 = new Trajet("T1","T2",1136,1173,1,'a',10,0);
			l1_40 = new Trajet("T1","T2",1156,1193,1,'a',10,0);
			l1_41 = new Trajet("T1","T2",1176,1213,1,'a',10,0);
			l1_42 = new Trajet("T1","T2",1196,1233,1,'a',10,0);
			l1_43 = new Trajet("T1","T3",1207,1210,1,'a',2,0);
			l1_44 = new Trajet("T1","T3",1245,1248,1,'a',2,0);

			//retour

			l1_45 = new Trajet("T2","T1",402,430,1,'r',8,0);
			l1_46 = new Trajet("T2","T1",422,450,1,'r',8,0);
			l1_47 = new Trajet("T2","T1",442,470,1,'r',8,0);
			l1_48 = new Trajet("T2","T1",462,490,1,'r',8,0);
			l1_49 = new Trajet("T2","T1",482,510,1,'r',8,0);
			l1_50 = new Trajet("T2","T1",502,530,1,'r',8,0);
			l1_51 = new Trajet("T2","T1",522,550,1,'r',8,0);
			l1_52 = new Trajet("T2","T1",542,570,1,'r',8,0);
			l1_53 = new Trajet("T2","T1",562,590,1,'r',8,0);
			l1_54 = new Trajet("T2","T1",582,610,1,'r',8,0);
			l1_55 = new Trajet("T2","T1",602,630,1,'r',8,0);
			l1_56 = new Trajet("T2","T1",622,650,1,'r',8,0);
			l1_57 = new Trajet("T2","T1",642,670,1,'r',8,0);
			l1_58 = new Trajet("T2","T1",662,690,1,'r',8,0);
			l1_59 = new Trajet("T2","T1",682,710,1,'r',8,0);
			l1_60 = new Trajet("T2","T1",702,730,1,'r',8,0);
			l1_61 = new Trajet("T2","T1",722,750,1,'r',8,0);
			l1_62 = new Trajet("T2","T1",742,770,1,'r',8,0);
			l1_63 = new Trajet("T2","T1",762,790,1,'r',8,0);
			l1_64 = new Trajet("T2","T1",782,810,1,'r',8,0);
			l1_65 = new Trajet("T2","T1",802,830,1,'r',8,0);
			l1_66 = new Trajet("T2","T1",822,850,1,'r',8,0);
			l1_67 = new Trajet("T2","T1",842,870,1,'r',8,0);
			l1_68 = new Trajet("T2","T1",862,890,1,'r',8,0);
			l1_69 = new Trajet("T2","T1",882,910,1,'r',8,0);
			l1_70 = new Trajet("T2","T1",902,930,1,'r',8,0);
			l1_71 = new Trajet("T2","T1",922,950,1,'r',8,0);
			l1_72 = new Trajet("T2","T1",942,970,1,'r',8,0);
			l1_73 = new Trajet("T2","T1",962,990,1,'r',8,0);
			l1_74 = new Trajet("T2","T1",982,1010,1,'r',8,0);
			l1_75 = new Trajet("T2","T1",1002,1030,1,'r',8,0);
			l1_76 = new Trajet("T2","T1",1022,1050,1,'r',8,0);
			l1_77 = new Trajet("T2","T1",1042,1070,1,'r',8,0);
			l1_78 = new Trajet("T2","T1",1062,1090,1,'r',8,0);
			l1_79 = new Trajet("T2","T1",1082,1110,1,'r',8,0);
			l1_80 = new Trajet("T2","T1",1102,1130,1,'r',8,0);
			l1_81 = new Trajet("T2","T1",1122,1150,1,'r',8,0);
			l1_82 = new Trajet("T2","T1",1142,1170,1,'r',8,0);
			l1_83 = new Trajet("T2","T1",1162,1190,1,'r',8,0);
			l1_84 = new Trajet("T2","T1",1182,1207,1,'r',8,0);
			l1_85 = new Trajet("T2","T1",1220,1245,1,'r',8,0);

		//liste des trajets
		trajets = new ArrayList<Trajet>();
		trajets.add(l1_1);
		trajets.add(l1_2);
		trajets.add(l1_3);
		trajets.add(l1_4);
		trajets.add(l1_5);
		trajets.add(l1_6);
		trajets.add(l1_7);
		trajets.add(l1_8);
		trajets.add(l1_9);
		trajets.add(l1_10);
		trajets.add(l1_11);
		trajets.add(l1_12);
		trajets.add(l1_13);
		trajets.add(l1_14);
		trajets.add(l1_15);
		trajets.add(l1_16);
		trajets.add(l1_17);
		trajets.add(l1_18);
		trajets.add(l1_19);
		trajets.add(l1_20);
		trajets.add(l1_21);
		trajets.add(l1_22);
		trajets.add(l1_23);
		trajets.add(l1_24);
		trajets.add(l1_25);
		trajets.add(l1_26);
		trajets.add(l1_27);
		trajets.add(l1_28);
		trajets.add(l1_29);
		trajets.add(l1_30);
		trajets.add(l1_31);
		trajets.add(l1_32);
		trajets.add(l1_33);
		trajets.add(l1_34);
		trajets.add(l1_35);
		trajets.add(l1_36);
		trajets.add(l1_37);
		trajets.add(l1_38);
		trajets.add(l1_39);
		trajets.add(l1_40);
		trajets.add(l1_41);
		trajets.add(l1_42);
		trajets.add(l1_43);
		trajets.add(l1_44);
		trajets.add(l1_45);
		trajets.add(l1_46);
		trajets.add(l1_47);
		trajets.add(l1_48);
		trajets.add(l1_49);
		trajets.add(l1_50);
		trajets.add(l1_51);
		trajets.add(l1_52);
		trajets.add(l1_53);
		trajets.add(l1_54);
		trajets.add(l1_55);
		trajets.add(l1_56);
		trajets.add(l1_57);
		trajets.add(l1_58);
		trajets.add(l1_59);
		trajets.add(l1_60);
		trajets.add(l1_61);
		trajets.add(l1_62);
		trajets.add(l1_63);
		trajets.add(l1_64);
		trajets.add(l1_65);
		trajets.add(l1_66);
		trajets.add(l1_67);
		trajets.add(l1_68);
		trajets.add(l1_69);
		trajets.add(l1_70);
		trajets.add(l1_71);
		trajets.add(l1_72);
		trajets.add(l1_73);
		trajets.add(l1_74);
		trajets.add(l1_75);
		trajets.add(l1_76);
		trajets.add(l1_77);
		trajets.add(l1_78);
		trajets.add(l1_79);
		trajets.add(l1_80);
		trajets.add(l1_81);
		trajets.add(l1_82);
		trajets.add(l1_83);
		trajets.add(l1_84);
		trajets.add(l1_85);

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

	}

	public static void main(String[] args) {

		initialisation();

		Fichier fichierSortie = new Fichier();

		//System.out.println(l1_1.toString());

		//test
		//System.out.println(distance_terminus[23][0]);


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

						System.out.println(B.getPosition());

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
									dureeTotal += temps;
								}
							}else if ((B.getPosition() == T.getDepart()) && ((T.gethDepart() - B.heureArrive) >= 5))
							{
								B.setDisponible(false);
								unBusDispo=true;
								T.setBus(B);
								B.getTrajetParcouru().add(T);
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
						nouveauxBus.setKilometrageTotal(distance_terminus[0][indiceTerminus(T.getDepart())]);
						//System.out.println(nouveauxBus.getKilometrageTotal());
						dureeTotal += temps_terminus[0][indiceTerminus(T.getDepart())];

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

					T.setBus(null);



				}

			}



		}

		System.out.println(lesBus.size());
		int i = 1;
		int totalKm =0;
		int kmTrajet = 0;


		for(Bus b : lesBus){
			System.out.print("bus"+i+" : ");
			System.out.println(b.getKilometrageTotal());
			totalKm += b.getKilometrageTotal();
			kmTrajet += b.getKilometrageTrajet();
			System.out.print("	nombreTrajet : ");
			System.out.println(b.TrajetParcouru.size());
			++i;
		}

		System.out.println("totalKm = " +totalKm);
		System.out.println("kmTrajet = " +kmTrajet);
		System.out.println("dureeTotal = " +dureeTotal);

		fichierSortie.CreationFichier(lesBus, trajets);

	}
}
