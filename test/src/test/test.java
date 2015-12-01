package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;




public class test {

	//Voyage 1 a 44 de la ligne 1
	 static Voyage l1_1;
	 static Voyage l1_2;
	 static Voyage l1_3;
	 static Voyage l1_4;
	 static Voyage l1_5;
	 static Voyage l1_6;
	 static Voyage l1_7;
	 static Voyage l1_8;
	 static Voyage l1_9;
	 static Voyage l1_10;
	 static Voyage l1_11;
	 static Voyage l1_12;
	 static Voyage l1_13;
	 static Voyage l1_14;
	 static Voyage l1_15;
	 static Voyage l1_16;
	 static Voyage l1_17;
	 static Voyage l1_18;
	 static Voyage l1_19;
	 static Voyage l1_20;
	 static Voyage l1_21;
	 static Voyage l1_22;
	 static Voyage l1_23;
	 static Voyage l1_24;
	 static Voyage l1_25;
	 static Voyage l1_26;
	 static Voyage l1_27;
	 static Voyage l1_28;
	 static Voyage l1_29;
	 static Voyage l1_30;
	 static Voyage l1_31;
	 static Voyage l1_32;
	 static Voyage l1_33;
	 static Voyage l1_34;
	 static Voyage l1_35;
	 static Voyage l1_36;
	 static Voyage l1_37;
	 static Voyage l1_38;
	 static Voyage l1_39;
	 static Voyage l1_40;
	 static Voyage l1_41;
	 static Voyage l1_42;
	 static Voyage l1_43;
	 static Voyage l1_44;

	 static Voyage l1_45;
	 static Voyage l1_46;
	 static Voyage l1_47;
	 static Voyage l1_48;
	 static Voyage l1_49;
	 static Voyage l1_50;
	 static Voyage l1_51;
	 static Voyage l1_52;
	 static Voyage l1_53;
	 static Voyage l1_54;
	 static Voyage l1_55;
	 static Voyage l1_56;
	 static Voyage l1_57;
	 static Voyage l1_58;
	 static Voyage l1_59;
	 static Voyage l1_60;
	 static Voyage l1_61;
	 static Voyage l1_62;
	 static Voyage l1_63;
	 static Voyage l1_64;
	 static Voyage l1_65;
	 static Voyage l1_66;
	 static Voyage l1_67;
	 static Voyage l1_68;
	 static Voyage l1_69;
	 static Voyage l1_70;
	 static Voyage l1_71;
	 static Voyage l1_72;
	 static Voyage l1_73;
	 static Voyage l1_74;
	 static Voyage l1_75;
	 static Voyage l1_76;
	 static Voyage l1_77;
	 static Voyage l1_78;
	 static Voyage l1_79;
	 static Voyage l1_80;
	 static Voyage l1_81;
	 static Voyage l1_82;
	 static Voyage l1_83;
	 static Voyage l1_84;
	 static Voyage l1_85;

	static  ArrayList<Voyage> Voyages;
	static  ArrayList<Bus> lesBus;

	static int[][] distance_terminus;
	static int[][] temps_terminus;


	 static int indiceTerminus(String terminus){
		return Integer.valueOf(terminus.substring(1));
	 }

	 static void initialisation()
	{
		//aller
			l1_1 = new Voyage("T1","T2",371,408,1,'a');
			l1_2 = new Voyage("T1","T2",394,431,1,'a');
			l1_3 = new Voyage("T1","T2",416,453,1,'a');
			l1_4 = new Voyage("T1","T2",436,473,1,'a');
			l1_5 = new Voyage("T1","T2",456,493,1,'a');
			l1_6 = new Voyage("T1","T2",476,513,1,'a');
			l1_7 = new Voyage("T1","T2",496,533,1,'a');
			l1_8 = new Voyage("T1","T2",516,553,1,'a');
			l1_9 = new Voyage("T1","T2",536,573,1,'a');
			l1_10 = new Voyage("T1","T2",556,593,1,'a');
			l1_11 = new Voyage("T1","T2",576,613,1,'a');
			l1_12 = new Voyage("T1","T2",596,633,1,'a');
			l1_13 = new Voyage("T1","T2",616,653,1,'a');
			l1_14 = new Voyage("T1","T2",636,673,1,'a');
			l1_15 = new Voyage("T1","T2",656,693,1,'a');
			l1_16 = new Voyage("T1","T2",676,713,1,'a');
			l1_17 = new Voyage("T1","T2",696,733,1,'a');
			l1_18 = new Voyage("T1","T2",716,753,1,'a');
			l1_19 = new Voyage("T1","T2",736,773,1,'a');
			l1_20 = new Voyage("T1","T2",756,793,1,'a');
			l1_21 = new Voyage("T1","T2",776,813,1,'a');
			l1_22 = new Voyage("T1","T2",796,833,1,'a');
			l1_23 = new Voyage("T1","T2",816,853,1,'a');
			l1_24 = new Voyage("T1","T2",836,873,1,'a');
			l1_25 = new Voyage("T1","T2",856,893,1,'a');
			l1_26 = new Voyage("T1","T2",876,913,1,'a');
			l1_27 = new Voyage("T1","T2",896,933,1,'a');
			l1_28 = new Voyage("T1","T2",916,953,1,'a');
			l1_29 = new Voyage("T1","T2",936,973,1,'a');
			l1_30 = new Voyage("T1","T2",956,993,1,'a');
			l1_31 = new Voyage("T1","T2",976,1013,1,'a');
			l1_32 = new Voyage("T1","T2",996,1033,1,'a');
			l1_33 = new Voyage("T1","T2",1016,1053,1,'a');
			l1_34 = new Voyage("T1","T2",1036,1073,1,'a');
			l1_35 = new Voyage("T1","T2",1056,1093,1,'a');
			l1_36 = new Voyage("T1","T2",1076,1113,1,'a');
			l1_37 = new Voyage("T1","T2",1096,1133,1,'a');
			l1_38 = new Voyage("T1","T2",1116,1153,1,'a');
			l1_39 = new Voyage("T1","T2",1136,1173,1,'a');
			l1_40 = new Voyage("T1","T2",1156,1193,1,'a');
			l1_41 = new Voyage("T1","T2",1176,1213,1,'a');
			l1_42 = new Voyage("T1","T2",1196,1233,1,'a');
			l1_43 = new Voyage("T1","T3",1207,1210,1,'a');
			l1_44 = new Voyage("T1","T3",1245,1248,1,'a');

			//retour

			l1_45 = new Voyage("T2","T1",402,430,1,'r');
			l1_46 = new Voyage("T2","T1",422,450,1,'r');
			l1_47 = new Voyage("T2","T1",442,470,1,'r');
			l1_48 = new Voyage("T2","T1",462,490,1,'r');
			l1_49 = new Voyage("T2","T1",482,510,1,'r');
			l1_50 = new Voyage("T2","T1",502,530,1,'r');
			l1_51 = new Voyage("T2","T1",522,550,1,'r');
			l1_52 = new Voyage("T2","T1",542,570,1,'r');
			l1_53 = new Voyage("T2","T1",562,590,1,'r');
			l1_54 = new Voyage("T2","T1",582,610,1,'r');
			l1_55 = new Voyage("T2","T1",602,630,1,'r');
			l1_56 = new Voyage("T2","T1",622,650,1,'r');
			l1_57 = new Voyage("T2","T1",642,670,1,'r');
			l1_58 = new Voyage("T2","T1",662,690,1,'r');
			l1_59 = new Voyage("T2","T1",682,710,1,'r');
			l1_60 = new Voyage("T2","T1",702,730,1,'r');
			l1_61 = new Voyage("T2","T1",722,750,1,'r');
			l1_62 = new Voyage("T2","T1",742,770,1,'r');
			l1_63 = new Voyage("T2","T1",762,790,1,'r');
			l1_64 = new Voyage("T2","T1",782,810,1,'r');
			l1_65 = new Voyage("T2","T1",802,830,1,'r');
			l1_66 = new Voyage("T2","T1",822,850,1,'r');
			l1_67 = new Voyage("T2","T1",842,870,1,'r');
			l1_68 = new Voyage("T2","T1",862,890,1,'r');
			l1_69 = new Voyage("T2","T1",882,910,1,'r');
			l1_70 = new Voyage("T2","T1",902,930,1,'r');
			l1_71 = new Voyage("T2","T1",922,950,1,'r');
			l1_72 = new Voyage("T2","T1",942,970,1,'r');
			l1_73 = new Voyage("T2","T1",962,990,1,'r');
			l1_74 = new Voyage("T2","T1",982,1010,1,'r');
			l1_75 = new Voyage("T2","T1",1002,1030,1,'r');
			l1_76 = new Voyage("T2","T1",1022,1050,1,'r');
			l1_77 = new Voyage("T2","T1",1042,1070,1,'r');
			l1_78 = new Voyage("T2","T1",1062,1090,1,'r');
			l1_79 = new Voyage("T2","T1",1082,1110,1,'r');
			l1_80 = new Voyage("T2","T1",1102,1130,1,'r');
			l1_81 = new Voyage("T2","T1",1122,1150,1,'r');
			l1_82 = new Voyage("T2","T1",1142,1170,1,'r');
			l1_83 = new Voyage("T2","T1",1162,1190,1,'r');
			l1_84 = new Voyage("T2","T1",1182,1207,1,'r');
			l1_85 = new Voyage("T2","T1",1220,1245,1,'r');

		//liste des Voyages
		Voyages = new ArrayList<Voyage>();
		Voyages.add(l1_1);
		Voyages.add(l1_2);
		Voyages.add(l1_3);
		Voyages.add(l1_4);
		Voyages.add(l1_5);
		Voyages.add(l1_6);
		Voyages.add(l1_7);
		Voyages.add(l1_8);
		Voyages.add(l1_9);
		Voyages.add(l1_10);
		Voyages.add(l1_11);
		Voyages.add(l1_12);
		Voyages.add(l1_13);
		Voyages.add(l1_14);
		Voyages.add(l1_15);
		Voyages.add(l1_16);
		Voyages.add(l1_17);
		Voyages.add(l1_18);
		Voyages.add(l1_19);
		Voyages.add(l1_20);
		Voyages.add(l1_21);
		Voyages.add(l1_22);
		Voyages.add(l1_23);
		Voyages.add(l1_24);
		Voyages.add(l1_25);
		Voyages.add(l1_26);
		Voyages.add(l1_27);
		Voyages.add(l1_28);
		Voyages.add(l1_29);
		Voyages.add(l1_30);
		Voyages.add(l1_31);
		Voyages.add(l1_32);
		Voyages.add(l1_33);
		Voyages.add(l1_34);
		Voyages.add(l1_35);
		Voyages.add(l1_36);
		Voyages.add(l1_37);
		Voyages.add(l1_38);
		Voyages.add(l1_39);
		Voyages.add(l1_40);
		Voyages.add(l1_41);
		Voyages.add(l1_42);
		Voyages.add(l1_43);
		Voyages.add(l1_44);
		Voyages.add(l1_45);
		Voyages.add(l1_46);
		Voyages.add(l1_47);
		Voyages.add(l1_48);
		Voyages.add(l1_49);
		Voyages.add(l1_50);
		Voyages.add(l1_51);
		Voyages.add(l1_52);
		Voyages.add(l1_53);
		Voyages.add(l1_54);
		Voyages.add(l1_55);
		Voyages.add(l1_56);
		Voyages.add(l1_57);
		Voyages.add(l1_58);
		Voyages.add(l1_59);
		Voyages.add(l1_60);
		Voyages.add(l1_61);
		Voyages.add(l1_62);
		Voyages.add(l1_63);
		Voyages.add(l1_64);
		Voyages.add(l1_65);
		Voyages.add(l1_66);
		Voyages.add(l1_67);
		Voyages.add(l1_68);
		Voyages.add(l1_69);
		Voyages.add(l1_70);
		Voyages.add(l1_71);
		Voyages.add(l1_72);
		Voyages.add(l1_73);
		Voyages.add(l1_74);
		Voyages.add(l1_75);
		Voyages.add(l1_76);
		Voyages.add(l1_77);
		Voyages.add(l1_78);
		Voyages.add(l1_79);
		Voyages.add(l1_80);
		Voyages.add(l1_81);
		Voyages.add(l1_82);
		Voyages.add(l1_83);
		Voyages.add(l1_84);
		Voyages.add(l1_85);

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
		//System.out.println(l1_1.toString());

		//test
		//System.out.println(distance_terminus[23][0]);


		//on parcour les heures de la journée (à partir de 5h00)
		for(int i=300;i<1440;++i)
		{
			//on parcours les heures de departs des Voyages + les heures d'arrive
			for(Voyage T: Voyages)
			{
				//on cherche un bus dispo pour l'heure de depart
				//TODO vérifier que le bus peut faire le Voyage interligne dans les temps
				if(T.gethDepart()==i)
				{
					boolean unBusDispo=false;
					for(Bus B: lesBus)
					{

						if(B.isDisponible() && !unBusDispo)
						{
							if((B.getPosition() != null) && (B.getPosition() != T.getArrive())){
								//voir si le bus peut arriver a temps au point de depart
							}
							B.setDisponible(false);
							unBusDispo=true;
							T.setBus(B);
							B.getTrajetParcouru().add(T);
						}
					}

					//on cree un bus si aucun bus dispo
					if(unBusDispo==false)
					{
						Bus nouveauxBus= new Bus(false);
						lesBus.add(nouveauxBus);
						T.setBus(nouveauxBus);
						nouveauxBus.getVoyageParcouru().add(T);
						nouveauxBus.setKilometrageTotal(distance_terminus[0][indiceTerminus(T.getDepart())]);
						//System.out.println(nouveauxBus.getKilometrageTotal());
					}
				}


				//on regarde si un Voyage se termine
				if(T.gethArrive()==i-5)
				{
					T.getBus().setDisponible(true);
					T.getBus().setPosition(T.getArrive());
					int kilometrageTotal = T.getBus().getKilometrageTotal();
					T.getBus().setKilometrageTotal(kilometrageTotal + distance_terminus[indiceTerminus(T.getDepart())][indiceTerminus(T.getArrive())] );
					T.setBus(null);

				}

			}



		}

		System.out.println(lesBus.size());
		int i = 1;
		int totalKm =0;
		for(Bus b : lesBus){
			System.out.print("bus"+i+" : ");
			System.out.println(b.getKilometrageTotal());
			totalKm += b.getKilometrageTotal();
			System.out.print("	nombreVoyage : ");
			System.out.println(b.VoyageParcouru.size());
			++i;
		}

		System.out.println("totalKm = " +totalKm);

	}
}
