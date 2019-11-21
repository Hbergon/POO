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
		Player p = new Player("fff", null);
		Chateau testC = new Chateau(p);
		
		
		
		
		
	
		gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(cpt == 5) {
					gameLoop.stop();
				}
				cpt ++;
				testC.addToTroupe(test);
				System.out.println(testC.getTroupe());
				
				
			}
		};

		
		
		
		
		gameLoop.start();
	}

}
