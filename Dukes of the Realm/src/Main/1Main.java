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
				if(cpt == 300) {
					gameLoop.stop();
				}
				if(cpt == 130) {
					testC.upCastle();			
				}
				System.out.println("tour :" + cpt);
				System.out.println("tresor :" + testC.getTresor());
				System.out.println("lvl :" +testC.getLvl());
				System.out.println(testC.getTroupe());
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
