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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;


public class Main extends Application {
    private final Random rnd = new Random();
    final static int WIDTH= 800;
    final static int HEIGHT= 800;
    static int NB_CASTLE;
    static int castleHeight;
    static int castleWidth;
    final static int MAX_NEUTRAL_CASTLE = 5;
    
          
          
  final static Image BACKGROUND = new Image(Main.class.getResource("background.jpg").toString());
  
  final static  Image CASTLEB = new Image(Main.class.getResource("castleB.png").toString());
  
  final static  Image CASTLER = new Image(Main.class.getResource("castleR.png").toString());
  
  final static  Image CASTLEG = new Image(Main.class.getResource("castleG.png").toString());
  
  final static  Image TROUPEB = new Image(Main.class.getResource("troupeB.png").toString());
  
  final static  Image TROUPER = new Image(Main.class.getResource("troupeR.png").toString());
  
  AnimationTimer gameLoop;
  

  ArrayList<Chateau> castles = new ArrayList<>();/*tout les chateau*/
  ArrayList<Troupes> outdoorTroupes = new ArrayList<>();

 

  int cptTour = 0;
  int[] CastleX = new int[MAX_NEUTRAL_CASTLE];
  int[] CastleY = new int[MAX_NEUTRAL_CASTLE];
  

Group troupes= new Group();
Group root;
Scene scene;
Group castle_r;

    @Override
    public void start(Stage primaryStage) {
    	
    	castleHeight = (int) CASTLEB.getHeight();
    	castleWidth = (int) CASTLEB.getWidth();
    	
        
    	 Player p1 = new Player("p1", 0);
    	 Player p2 = new Player("p2", 1);
    	 Player Neutre = new Player("NEUTRE", 2);
    	 
    	 NB_CASTLE = 3 + (int) (rnd.nextFloat()*MAX_NEUTRAL_CASTLE-2);
    	 

    	 validPosInit();

    	 
    	 Chateau chateau_1 = new Chateau(p1, CastleX[0], CastleY[0]);
    	 Chateau chateau_2 = new Chateau(p2, CastleX[1], CastleY[1]);
 
    	castles.add(chateau_1);
    	castles.add(chateau_2);
    	
    	Chateau[] chateauNeutres = new Chateau[NB_CASTLE-2];
    	
    	for(int i = 0; i<NB_CASTLE-2; i++) {
    		chateauNeutres[i] = new Chateau(Neutre, CastleX[i+2], CastleY[i+2]);
    		castles.add(chateauNeutres[i]);
    	}
    	
    	
    	
    	
    	castleHeight = (int) CASTLEB.getHeight();
    	castleWidth = (int) CASTLEB.getWidth();

    	
        
        final ImageView background = new ImageView(BACKGROUND);
        final ImageView castle[]= Showcastles();
        castle_r = new Group(castle);

            castle_r.setEffect(new DropShadow());
            
            background.setEffect(new BoxBlur());         
            background.setOpacity(0.5);
            
            
            castle_r.getChildren().get(0).setOnMouseClicked(e -> {
                Label secondLabel = new Label("Do you want to attack this castle?");
						
	StackPane secondaryLayout = new StackPane();
	secondaryLayout.getChildren().add(secondLabel);
	Button button1 = new Button ("Yes");
	Button button2 = new Button("No");
	secondaryLayout.getChildren().add(button1);
	secondaryLayout.getChildren().add(button2);
	Scene secondScene = new Scene(secondaryLayout, 230, 100);
	// New window (Stage)
	Stage newWindow = new Stage();
	newWindow.setTitle("Attack");
	newWindow.setScene(secondScene);
						
	// Set position of second window, related to primary window.
	newWindow.setX(primaryStage.getX() + 200);
	newWindow.setY(primaryStage.getY() + 100);
	button2.setTranslateX(30);
						
	button1.setOnAction(new EventHandler<ActionEvent>() {
	
                @Override
                public void handle(ActionEvent event) {
                    newWindow.close();
	}});
		
						
	button2.setOnAction(new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
                        newWindow.close();
	}
						
	});
						
	newWindow.show();
	});
                
            
            
            
         root= new Group(background,castle_r, troupes);
        scene = new Scene(root, WIDTH, HEIGHT);
   
        primaryStage.setTitle("Dukes of the Realm!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
 
                  
		gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				
				
				cptTour ++; /*num�ro du tour*/
//				System.out.println("tour : " + cptTour); /*pour voir quel tour on est */

                                                                      
				updateCastles();
				updateTroupes();
                                                            
				/*sc�nario de test*/
				
				
//				System.out.println(" proprio : " + chateau_2.getPlayer());
				
				if(chateau_1.getTresor() > 100) {
//					System.out.println("==========================");
					chateau_1.addProd(new Piquier());
				}
				
				if(chateau_2.getList().size() < 2 && cptTour  < 50) {
					chateau_2.addProd(new Piquier());
				}
				
				
				
				
				if(chateau_1.troupe.size() >= 1 && cptTour < 100 && cptTour > 50) {
//					System.out.println(" ////////// " + chateau_1.troupe.get(0));
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
             tmp = castles.get(i);
             if(tmp.getPlayer().getColor() == 0) {
      		   castle[i]= new ImageView(CASTLEB);
      	   	 }else {
	      	   	if(tmp.getPlayer().getColor() == 2) {
	       		   castle[i]= new ImageView(CASTLEG);
	       	   	}else {
	       	   		castle[i]= new ImageView(CASTLER);
	       	   	}
      	   	 }
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
    		t.setPosition_x(c.getPosition_x() + (castleWidth)/2);
        	t.setPosition_y(c.getPosition_y());
    		break;
    	case 1:
    		t.setPosition_x(c.getPosition_x() + castleWidth);
        	t.setPosition_y(c.getPosition_y() + (castleHeight)/2);
    		break;
    	case 2:
    		t.setPosition_x(c.getPosition_x() + (castleWidth)/2);
        	t.setPosition_y(c.getPosition_y() + castleHeight);
    		break;
    	case 3:
    		t.setPosition_x(c.getPosition_x());
        	t.setPosition_y(c.getPosition_y()- (castleHeight)/2);
    		break;
    	}
    }
    
    
    
    /*mettre version java fx*/
    /*fait sortir les troupes et leurs donnent une cible*/
    private void order(Chateau origine, Chateau destination){
    	
    	int x = destination.getPosition_x();
    	int y = destination.getPosition_y();
    	Troupes tmp;
    	
    	while(!origine.getTroupe().isEmpty()) {

    		tmp = origine.getSomeTroupe(0);
    		
    		tmp.setCible(destination, castleHeight, castleWidth);
        	leaveCastle(tmp, origine);
        	origine.removeTroupeFirst();
        	outdoorTroupes.add(tmp);
        	show_troupe(outdoorTroupes.size()-1);
    	}
    	
    }
    
    
    
    
     void show_troupe(int i){
    	 
    	 	Troupes tmp = outdoorTroupes.get(i);
    	 	ImageView troupe;
    	 	if(tmp.getPlayer().getColor() == 0) {
    	 		troupe= new ImageView(TROUPEB);
    	 	}else {
    	 		troupe= new ImageView(TROUPER);
    	 	}
            
            troupe.setTranslateX(tmp.getPosition_x());
            troupe.setTranslateY(tmp.getPosition_y());
            troupes.getChildren().add(troupe);
           

    }

     
     void destroy_troupes(int index){
         int size = outdoorTroupes.size();
         if(size==0){
             return;
         }
         troupes.getChildren().remove(index);
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
    	
    	if(x >= (t.getAimX()-(castleWidth)/2) && (t.getAimY()- (castleHeight)/2 )<= y && x <= (t.getAimX() + (castleWidth)/2) && (t.getAimY() +  (castleHeight)/2) >= y) {
    		t.getCible().TroupeInteraction(t);
    		outdoorTroupes.remove(ind);
            destroy_troupes(outdoorTroupes.size());
    		
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
    
    private void validPosInit() {
    	
	    int randXFirst = (int) (rnd.nextFloat()*WIDTH - castleWidth);
	   	int randYFirst = (int) (rnd.nextFloat()*HEIGHT-castleHeight);
	   
	   	 
	   	if(randXFirst < castleWidth) {
	   		 randXFirst = randXFirst + castleWidth;
	   	}
	   	if(randYFirst < castleHeight) {
	   		 randYFirst = randYFirst + castleHeight;
	   	}
	   	
	    CastleX[0] = randXFirst;
	    CastleY[0] = randYFirst;
	   	 
	   	for(int i = 1; i < NB_CASTLE; i++) {
	   		findValidPos(i);
	   		
	   	}
	   	
    }
	   	
	private void findValidPos(int ind) {
		
		int randXSecond = 0;
	   	int randYSecond = 0;
		
		Boolean notValidPos = true;
	   	 
	   	while(notValidPos) {
	   		
	   		randYSecond = (int) (rnd.nextFloat()*HEIGHT-castleHeight);
	   		randXSecond = (int) (rnd.nextFloat()*HEIGHT-castleWidth);
	   		
	   		if(randYSecond < castleHeight) {
	   			randYSecond = randYSecond + castleHeight;
			}
	   		if(randXSecond < castleWidth) {
	   			randXSecond = randXSecond + castleWidth;
			}
	   			
	   		notValidPos = isInArea(randXSecond, randYSecond, ind);
	   		System.out.println("ind : " + ind + "  "+ randXSecond + " ff "+randYSecond );
	   	}
	    CastleX[ind] = randXSecond;
	    CastleY[ind] = randYSecond;
    }
	
	private Boolean isInArea(int x, int y, int ind) {
		int centerX = x + castleHeight/2;
		int centerY = y + castleWidth/2;
		
		int centerXOther;
		int centerYOther;
		
		for(int i =0; i < ind; i++) {
			System.out.println("ind : " +i );
			
			centerXOther = CastleX[i]+ castleHeight/2;
			centerYOther = CastleY[i] + castleWidth/2;
			
			if(centerX > centerXOther  && centerX - centerXOther < castleHeight*2) {
				if(centerY > centerYOther && centerY - centerYOther < castleWidth*2) {
					return true;
				}
				if(centerY < centerYOther && centerYOther - centerY < castleWidth*2) {
					return true;
				}
			}
			if(centerX < centerXOther && centerXOther - centerX < castleHeight*2) {
				if(centerY > centerYOther && centerY - centerYOther < castleWidth*2) {
					return true;
				}
				if(centerY < centerYOther && centerYOther - centerY < castleWidth*2) {
					return true;
				}
			}
		}
		return false;
	}
    



    public static void main(String[] args) {
        launch(args);
    }
    
}
