/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import struct.Chateau;
import struct.Player;
import troupes.*;
import troupes.Troupes;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;


public class Main extends Application {
    private final Random rnd = new Random();
    final static int WIDTH= 800;
    final static int HEIGHT= 600;
    final static int NB_CASTLE=2;
    final static int castleHeight = 50;/*mettre ici les tailles des images/hitbox des chateaux*/
    final static int castleWidth = 50;
    
          
          
  final static Image BACKGROUND = new Image(Main.class.getResource("background.jpg").toString());
  
  final static  Image CASTLE = new Image(Main.class.getResource("castle.png").toString());
  
  final static  Image TROUPE = new Image(Main.class.getResource("troupe.png").toString());
  
  AnimationTimer gameLoop;
  

  ArrayList<Chateau> castles = new ArrayList<>();/*tout les chateau*/
  ArrayList<Troupes> outdoorTroupes = new ArrayList<>();

 
  
  
  /*initialsation pour test*/
  
  int cptTour = 0;
  
 Player p1 = new Player("p1");
 Player p2 = new Player("p2");
 
 Chateau chateau_1 = new Chateau(p1, 700, 500);
 Chateau chateau_2 = new Chateau(p2, 200, 100);
 /**/
 
 
 

final Group troupes= new Group();

ArrayList<ImageView> ImgTroupe = new ArrayList<>();
int l=0;



    @Override
    public void start(Stage primaryStage) {
        
    	/*suite initialisation pour test*/
    	castles.add(chateau_1);
    	castles.add(chateau_2);
    	/**/
    	
        final ImageView background = new ImageView(BACKGROUND);
        final ImageView castle[]= Showcastles();
        final Group castle_r = new Group(castle);
        
            castle_r.setEffect(new DropShadow());
            
            background.setEffect(new BoxBlur());         
            background.setOpacity(0.5);
            
            
            //Pas ok encore
            castle_r.setOnMouseClicked((MouseEvent e) -> {
                Label secondLabel = new Label("Do you want to attack this castle?");
                
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
                
                Scene secondScene = new Scene(secondaryLayout, 230, 100);
                
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Attack");
                newWindow.setScene(secondScene);
                
                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 100);
                
                newWindow.show();
            });
                
            
            
            
        final Group root= new Group(background,castle_r, troupes);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
   
        primaryStage.setTitle("Dukes of the Realm!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
 
                              
		gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				
				
				cptTour ++; /*numéro du tour*/
				System.out.println("tour : " + cptTour); /*pour voir quel tour on est */

                                                                      
				updateCastles();
				updateTroupes();
				
				/*scénario de test*/
				
				
				System.out.println(" proprio : " + chateau_2.getPlayer());
				
				if(chateau_1.getTresor() > 100) {
					System.out.println("==========================");
					chateau_1.addProd(new Piquier());
				}
				
				if(chateau_2.getList().size() < 2 && cptTour  < 50) {
					chateau_2.addProd(new Piquier());
				}
				
				
				
				
				if(chateau_1.troupe.size() >= 1 && cptTour < 100 && cptTour > 50) {
					System.out.println(" ////////// " + chateau_1.troupe.get(0));
					order(chateau_1, chateau_2);
					
				}
				
				/**/
			
                                                           
			}

		};
               
                gameLoop.start();
    }
    
    
    ImageView[] Showcastles(){
        ImageView[] castle= new ImageView[NB_CASTLE];
        int x;
        int y;
        Chateau tmp;
       for (int i= 0; i<NB_CASTLE; i=i+1) {
             castle[i]= new ImageView(CASTLE);
             tmp = castles.get(i);
             x = tmp.getPosition_x();
             y = tmp.getPosition_y();
             
             castle[i].setTranslateX(x);
             castle[i].setTranslateY(y);
        }
        return castle;
        
    }
    
    
    /*mettre version javafx*/
    /*sert a savoir la pos ou sort la troupe en prenant en compte l'orientation*/
    
    private void leaveCastle(Troupes t, Chateau c) {
    	switch(c.getOrientation()) {
    	case 0:
    		t.setPosition_x(c.getPosition_x());
        	t.setPosition_y(c.getPosition_y() - (castleHeight)/2);
    		break;
    	case 1:
    		t.setPosition_x(c.getPosition_x() + (castleWidth)/2);
        	t.setPosition_y(c.getPosition_y());
    		break;
    	case 2:
    		t.setPosition_x(c.getPosition_x());
        	t.setPosition_y(c.getPosition_y() + (castleHeight)/2);
    		break;
    	case 3:
    		t.setPosition_x(c.getPosition_x() - (castleWidth)/2);
        	t.setPosition_y(c.getPosition_y());
    		break;
    	}
    }
    
    
    
    /*mettre version java fx*/
    /*fait sortir les troupes et leurs donnent une cible*/
    private void order(Chateau origine, Chateau destination){
    	
    	int x = destination.getPosition_x();
    	int y = destination.getPosition_y();
    	Troupes tmp;
    	
    	while(origine.getTroupe().size() != 0) {

    		tmp = origine.getSomeTroupe(0);
    		
    		tmp.setCible(destination);
        	leaveCastle(tmp, origine);
        	origine.removeTroupeFirst();
        	outdoorTroupes.add(tmp);
        	show_troupes();
    	}
    	
    }
    
    
    
    
     void show_troupes(){
        int size = outdoorTroupes.size();
        ImageView[] troupe= new ImageView[size];
        for(int i=0; i<size; i=i+1){
            troupe[i]= new ImageView(TROUPE);
            
              troupe[i].setTranslateX(outdoorTroupes.get(i).getPosition_x());;
                troupe[i].setTranslateY(outdoorTroupes.get(i).getPosition_y());
            troupes.getChildren().add(troupe[i]);

        }
    }
     
    

    /*calcul les prochaine spos d une troupe*/
    private Boolean newPos(Troupes t, int ind) {
    	/*version simple*/
    	int x = t.getPosition_x();
    	int y = t.getPosition_y();
    	int targetX = t.getAimX();/*voir fonction au dessus*/
    	int targetY = t.getAimY();
    	int spd = t.getSpeed();
    	Boolean lastX = t.getLastX();
    	
    	if(lastX || targetX == x) {
    		if(y > targetY) {
    			y = y - spd;
    			if(y < targetY) {
    				y = targetY;
    			}
    		}else {
    			y = y+spd;
    			if(y > targetY) {
    				y = targetY;
    			}
    		}
    		if(targetX != x) {
    			t.setLastX(false);
    		}
    	}else {
    		if(x > targetX) {
    			x = x - spd;
    			if(x < targetX) {
    				x = targetX;
    			}
    		}else {
    			x = x+spd;
    			if(x > targetX) {
    				x = targetX;
    			}
    		}
    		if(targetY != y) {
    			t.setLastX(true);
    		}
    	}
    	
    	if(x == t.getAimX() && t.getAimY() == y) {
    		t.getCible().TroupeInteraction(t);
    		outdoorTroupes.remove(ind);
    		show_troupes();
    		/*ici suppr l'affichage de cette troupes*/
    		
    		
    		
    		
    		
    		return true;
    	}
    	
    	t.setPosition_x(x);
    	t.setPosition_y(y);
    	troupes.getChildren().get(ind).setTranslateX(outdoorTroupes.get(ind).getPosition_x());
        troupes.getChildren().get(ind).setTranslateY(outdoorTroupes.get(ind).getPosition_y());
    	return false;
    	
    }
    
    private void updateTroupes() {
    	int size = outdoorTroupes.size();
    	if(size == 0) {
    		return;
    	}
    	int i = 0;
    	while(i < size) {
    		if(newPos(outdoorTroupes.get(i), i)) {
    			size = size - 1;
    		}else {
    			i++;
    		}
    	}
    	
    }
    
    /*met a  jour les chateaux en argent et production de troupes*/
    private void updateCastles() {
    	int size = castles.size();
    	if(size == 0) {
    		return;
    	}

    	for(int i = 0; i < size; i++) {
    		castles.get(i).updateProd();
    	}
    }
    



    public static void main(String[] args) {
        launch(args);
    }
    
}
