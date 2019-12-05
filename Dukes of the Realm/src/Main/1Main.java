package Main;
import Troupes.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

import Struct.*;

public class Main extends Application{
	private static AnimationTimer gameLoop;
	static int cpt = 0;

	
	public void start(Stage primaryStage) {
		
		
		Piquier test = new Piquier();
		Piquier test2 = new Piquier();
		Piquier test3 = new Piquier();
		ArrayList<Troupes> attaqueur = new ArrayList<Troupes>();
		Player p2 = new Player("fff2", null);
		for(int i =0; i < 6; i++){
			attaqueur.add(new Piquier());
			attaqueur.get(i).setPlayer(p2);
		}
		Player p = new Player("fff", null);
		Chateau testC = new Chateau(p);
		testC.setTresor(5000);
		testC.addProd(test2);
		testC.addProd(test);
		
		
		
		
		
	
		gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				testC.updateProd();
				if(cpt > 5 && cpt < 10) {
					testC.addProd(new Piquier());
				}
				if(cpt == 8) {
					testC.cancelProd(0);
					testC.cancelProd(3);
				}
				if(cpt == 200) {
					gameLoop.stop();
				}
				if(cpt == 130) {
					testC.upCastle();			
				}
				if(cpt >=170) {
					if(attaqueur.size() > 0) {
						testC.TroupeInteraction(attaqueur.get(0));
						attaqueur.remove(0);
						
					}
				}
				System.out.println("\n\ntour :" + cpt);
				System.out.println("tresor :" + testC.getTresor());
				System.out.println("lvl :" +testC.getLvl());
				System.out.println("defenseur " + testC.getTroupe());
				System.out.println("proprio " + testC.getProprio());
				System.out.println("attaquant "+p2);
				System.out.println("attaqueuer "+ attaqueur);
				if(testC.file.size()>0) {
					System.out.println(testC.getFirstList());
				}
				
				
				cpt ++;
			}
		};

		
		
		
		
		gameLoop.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
