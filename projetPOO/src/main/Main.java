/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import struct.Chateau;
import struct.Player;
import troupes.Troupes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;


public class Main extends Application {
    private Random rnd = new Random();
    final static int WIDTH= 800;
    final static int HEIGHT= 600;
    final static int NB_CASTLE=2;
    
          
          
  final static Image BACKGROUND = new Image(Main.class.getResource("background.jpg").toString());
  
  final static  Image CASTLE = new Image(Main.class.getResource("castle.png").toString());
  
  final static  Image TROUPE = new Image(Main.class.getResource("troupe.png").toString());
  
  AnimationTimer gameLoop;
  
 private List<Chateau> castles = new ArrayList<>();
 
 
 
 
 Player p1 = new Player("p1");
 Player p2 = new Player("p2");
 
 Chateau chateau_1 = new Chateau(p1);
 Chateau chateau_2 = new Chateau(p2);
 
 
 
		

 
final Group troupes= new Group();
 ImageView[] troupe= new ImageView[2];
int l=0;



    public void start(Stage primaryStage) {
        final ImageView background = new ImageView(BACKGROUND);
        final ImageView castle[]= Showcastles();
        final Group castle_r = new Group(castle);
        
            castle_r.setEffect(new DropShadow());
            
            background.setEffect(new BoxBlur());         
            background.setOpacity(0.5);
            
            
            
            
        final Group root= new Group(background,castle_r, troupes);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
   
        primaryStage.setTitle("Dukes of the Realm!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        order(chateau_1, chateau_2);
         
		gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
                                                           l=(l+1)%WIDTH;
                                                           final int a=l;
                                                           troupe[0].setX(a);
                                                           
			}

		};
               
                gameLoop.start();
    }
    
    
    ImageView[] Showcastles(){
        ImageView[] castle= new ImageView[NB_CASTLE];
       for (int i= 0; i<NB_CASTLE; i=i+1) {
             castle[i]= new ImageView(CASTLE);
             castle[i].setTranslateX(600*i);
             castle[i].setTranslateY(200);
        }
        return castle;
        
    }
    
    
    
    
    private void order(Chateau origine, Chateau destination){
       
        /*for (Troupes t: origine.getTroupe()){
         * les envois vers chateau destination
    		}*/

    	
        for(int i=0; i<2; i=i+1){
            troupe[i]= new ImageView(TROUPE);
            troupe[i].setTranslateX(600*i);
            troupe[i].setTranslateY(400);
            troupes.getChildren().add(troupe[i]);

        }
        
        
               
    }
    



    public static void main(String[] args) {
        launch(args);
    }
    
}
