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
		testC.addToFile(test2);
		testC.addToFile(test3);
		testC.addToFile(test);
		
		
		
		
		
	
		gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(cpt > 5) {
					testC.updateProd();
				}
				if(cpt == 200) {
					gameLoop.stop();
				}
				if(cpt == 15) {
					testC.upCastle();			
				}
				cpt ++;
				System.out.println(cpt);
				System.out.println(testC.lvl);
				System.out.println(testC.getTroupe());
				if(testC.file.size()>0) {
					System.out.println(testC.getFirstList());
				}
				
				
			}
		};

		
		
		
		
		gameLoop.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
