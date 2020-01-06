/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import struct.Chateau;
import struct.Player;
import troupes.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

/**Classe o� se d�roule les actions du jeu*/
public class Base extends Application {
	/**G�n�rateur � chiffres "al�atoires"
	 * @see Main#initNeutralCastles(Player)
	 * @see Main#castleInit()*/
    private final Random rnd = new Random();
    /**Largeur de la fen�tre*/
    final static int WIDTH= 800;
    /**Hauteur de la fen�tre*/
    final static int HEIGHT= 800;
    /**Nbombre de chateaux
     * @see Chateau*/
    static int NB_CASTLE;
    /**longueur d'un Chateau
     * @see Chateau*/
    static int castleHeight;
    /**largeur d'un Chateau
     * @see Chateau*/
    static int castleWidth;
    /**Nombre maximal de chateaux neutres
     * @see Playeur#color
     * @see Chateau
     * @see Main#initNeutralCastles(Player)*/
    final static int MAX_NEUTRAL_CASTLE = 5;
    
          
          /**Fond du jeu*/
  final static Image BACKGROUND = new Image(Main.class.getResource("background.jpg").toString());
  
  /**Image du chateau bleu
   * @see Player#color 
   * @see Chateau*/
  final static  Image CASTLEB = new Image(Main.class.getResource("castleB.png").toString());
  
  /**Image du chateau rouge
   * @see Player#color 
   * @see Chateau*/
  final static  Image CASTLER = new Image(Main.class.getResource("castleR.png").toString());
  
  /**Image du chateau vert
   * @see Player#color 
   * @see Chateau*/
  final static  Image CASTLEG = new Image(Main.class.getResource("castleG.png").toString());
  
  /**Image des troupes bleues
   * @see Player#color 
   * @see Troupes*/
  final static  Image TROUPEB = new Image(Main.class.getResource("troupeB.png").toString());
  
  /**Image des troupes rouges
   * @see Player#color 
   * @see Troupes*/
  final static  Image TROUPER = new Image(Main.class.getResource("troupeR.png").toString());
  
  AnimationTimer gameLoop;
  
/**ArrayList de tout les chateaux existants
 * @see Chateau
 * @see ArrayList*/
  ArrayList<Chateau> castles = new ArrayList<>();
  
  /**ArrayList de toutes les troupes � l'ext�rieurs d'un chateau
   * @see Chateau
   * @see Troupes
   * @see ArrayList*/
  ArrayList<Troupes> outdoorTroupes = new ArrayList<>();

 
/**Tableau contenant les positions des chateaux neutres
 * @see Chateau
 * @see Player#color
 * @see Main#initNeutralCastles(Player)*/
  int[] CastleX = new int[MAX_NEUTRAL_CASTLE];
  int[] CastleY = new int[MAX_NEUTRAL_CASTLE];
  

Group troupes= new Group();
Group root;
Scene scene;
Group castle_r;

/**Coeur du jeu
 * @see Main*/
    @Override
    public void start(Stage primaryStage) {
    	
    	castleHeight = (int) CASTLEB.getHeight();
    	castleWidth = (int) CASTLEB.getWidth();
    	
        
    	 Player p1 = new Player("p1", 0);
    	 Player p2 = new Player("p2", 1);
    	 Player Neutre = new Player("NEUTRE", 2);
    	 
    	 NB_CASTLE = 3 + (int) (rnd.nextFloat()*MAX_NEUTRAL_CASTLE-2);
    	 
    	 castleInit();
    	 

    	 validPosInit();

    	 
    	 Chateau chateau_1 = new Chateau(p1, CastleX[0], CastleY[0]);
    	 Chateau chateau_2 = new Chateau(p2, CastleX[1], CastleY[1]);
 
    	castles.add(chateau_1);
    	castles.add(chateau_2);
    	
    	
    	initNeutralCastles(Neutre);
    	
    	
    	
    	castleHeight = (int) CASTLEB.getHeight();
    	castleWidth = (int) CASTLEB.getWidth();

    	
        
        final ImageView background = new ImageView(BACKGROUND);
        final ImageView castle[]= Showcastles();
        castle_r = new Group(castle);

            castle_r.setEffect(new DropShadow());
            
            background.setEffect(new BoxBlur());         
            background.setOpacity(0.5);
            
            
            castle_r.setOnMouseClicked(e -> {
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
                	int[] armee = new int[3];
                	/*a changer*/
                	armee[0] = 3;
                	
                	
                	order(chateau_1, chateau_2, armee);
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
			
			/**Boucle pricipale du jeu, g�rant les tours*/
			@Override
			public void handle(long now) {
	                                           
				updateCastles();
				updateTroupes();
                                                            				
				
                    
			}

		};
               
                gameLoop.start();
    }
    
    /**Affiche les chateaux
     * @return un tableau d'image des chateaux
     * @see ImageView
     * @see Chateau
     * @see Player*/
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
        
    /**Donne la premi�re position � une troupe sortie
     * @param t : troupe sortie
     * @param c : chateau d'o� provient la troupe
     * @see Chateau#file
     * @see Main#order(Chateau, Chateau, int[])*/
    private void leaveCastle(Troupes t, Chateau c) {
    	t.setPosition_x(c.getPosition_x() + (castleWidth)/2);
        t.setPosition_y(c.getPosition_y() + castleHeight);
    }
    
/**Ordre � certaines unit�s d'un chateau de sortir et de se d�plcacer
 * @param origine : chateau d'origine
 * @param destination : chateau d'arriv�e
 * @param tailleArm�e : tableau indiquant la quantit�s et le type de troupe demand�
 * @see Troupes
 * @see Chateau
 * @see Main#outdoorTroupes
 * @see Chateau#TroupeInteraction(Troupes)
 * @see Main#orderAux(Chateau, Chateau, Troupes, int)*/
    private void order(Chateau origine, Chateau destination, int[] tailleArmee){
    	
    	int x = destination.getPosition_x();
    	int y = destination.getPosition_y();
    	Troupes tmp;
    	
    	int cpt=0;
    	
    	while(cpt < origine.getTroupe().size()) {
    		tmp = origine.getTroupe().get(cpt);
 	
    		if(tailleArmee[0] != 0 && tmp.getClass() == Piquier.class ) {
    			tailleArmee[0] = tailleArmee[0]-1;
    			orderAux( origine,  destination,  tmp, cpt)
		     }else {
			     cpt ++;
    		 }
    	}
    }
    
    /**Methode auxiliaire de order
     * @param origine : chateau d'origine
     * @param destination : chateau d'arriv�e
     * @param t : troupe sortante
     * @param ind : indice de cette troupe dans la garnison du chateau
     * @see Chateau#troupe
     * @see Troupe
     * @see Main#outdoorTroupes
     * @see Main#order(Chateau, Chateau, int[])*/
    private void orderAux(Chateau origine, Chateau destination, Troupes t, int ind) {
    	t = origine.getSomeTroupe(ind);
        t.setCible(destination, castleHeight, castleWidth);
        leaveCastle(t, origine);
        origine.removeTroupe(ind);
        outdoorTroupes.add(t);
        show_troupe(outdoorTroupes.size()-1);
        return;
    }
    
    /**Affiche une troupe
     * @param i : indice de la troupe dans outdoorTroupes
     * @see Main#outdoorTroupes
     * @see Troupes
     * @see ImageView*/
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

     /**D�truit l'image de la troupe
      * @param index : indice de la troupe dans outdoorTroupes
      *@see Main#outdoorTroupes
     * @see Troupes
     * @see ImageView*/
     void destroy_troupes(int index){
         int size = outdoorTroupes.size();
         if(size==0){
             return;
         }
         troupes.getChildren().remove(index);
     }
     
     
    /**Calcul la nouvelle position des troupes dehors et lance les interractions avec les chateau une fois arriv�e
     * @param  t : troupe � mouvoir
     * @param : indice de la troupe dans outdoorTroupes
     * @return : si la troupe peux est arriv�e et � int�ragit avec la cible
     * @see Main#outdoorTroupes
     * @see Troupes
     * @see Troupes#cible*/
    private Boolean newPos(Troupes t, int ind) {
    	int x = t.getPosition_x();
    	int y = t.getPosition_y();
    	int targetX = t.getAimX();
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
            destroy_troupes(ind);
            
            int size = castles.size();
            
            for(int i = 0; i < size; i++) {
            	if(castles.get(i) == t.getCible()) {
            		/*ici mettre actualisation sur castle[i]*/
            		break;
            	}
            }
    		
    		return true;
    	}
    	   	
    	t.setPosition_x(x);
    	t.setPosition_y(y);
    	troupes.getChildren().get(ind).setTranslateX(outdoorTroupes.get(ind).getPosition_x());
        troupes.getChildren().get(ind).setTranslateY(outdoorTroupes.get(ind).getPosition_y());
    	return false;
    }
    
    /**Met � jour les positions des troupes dehors
     * @see Main#outdoorTroupes
     * @see Troupes*/
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
    
    /**Met � jour les chateaux
     * @see Chateau#updateProd()*/
    private void updateCastles() {
    	int size = castles.size();
    	if(size == 0) {
    		return;
    	}
    	for(int i = 0; i < size; i++) {
    		castles.get(i).updateProd();
    	}
    }
    
    /**Initialise tout les chateaux sauf le premiers cr�e en leurs donnant des position pas trop proches les unes des autres
     * @see Main#castleHeight
     * @see Main#castleWidth
     * @see Main#rnd
     * @see Main#findValidPos(int)*/
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
	   	
    /**Trouve des positions valide (voir validPosInit())
     * @param : indice de la troupe dans outdoorTroupes
     * @see Main#validPosInit()*/
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
	   	}
	    CastleX[ind] = randXSecond;
	    CastleY[ind] = randYSecond;
    }
	
	/**indique si un couple de position est trop proche d'un chateau existant
	 * @param x : composante suivant l'abscisse du couple de coordonn�es
	 * @param y : composante suivant les ordonn�es du couple de coordonn�es
	 * @return : si les coordonn�es sont trop proches
	 * @see Main#findValidPos()*/
	private Boolean isInArea(int x, int y, int ind) {
		int centerX = x + castleHeight/2;
		int centerY = y + castleWidth/2;
		
		int centerXOther;
		int centerYOther;
		
		for(int i =0; i < ind; i++) {
			
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
    
	/**Initialise les chateaux neutres
	 * @param neutre : joueur qui endossera le role de joueur neutre
	 * @see Player#color();
	 * @see Chateau
	 * @see Main#castleInit()*/
	private void initNeutralCastles(Player neutre) {
    	Chateau[] chateauNeutres = new Chateau[NB_CASTLE-2];
    	
    	int randArmySize = (int) (rnd.nextFloat()*5);
    	for(int i = 0; i<NB_CASTLE-2; i++) {
    		chateauNeutres[i] = new Chateau(neutre, CastleX[i+2], CastleY[i+2]);
    		for(int j =0; j < randArmySize; j++) {
    			chateauNeutres[i].addSomeTroupe(new Piquier());
    		}
    		castles.add(chateauNeutres[i]);
    	}
	}

	/**Initialisation des chateaux et les joueurs
	 * @see Chateau
	 * @see Player
	 * @see Main#validPosInit();
	 * @see Main#initNeutralCastles()
	 * */
	private void castleInit() {
		 Player p1 = new Player("p1", 0);
	   	 Player p2 = new Player("p2", 1);
	   	 Player Neutre = new Player("NEUTRE", 2);
	   	    	 
	   	 validPosInit();
	
	   	 Chateau chateau_1 = new Chateau(p1, CastleX[0], CastleY[0]);
	   	 Chateau chateau_2 = new Chateau(p2, CastleX[1], CastleY[1]);
	
	   	 castles.add(chateau_1);
	   	 castles.add(chateau_2);
	   	
	   	 initNeutralCastles(Neutre);
	}

    public static void main(String[] args) {
        launch(args);
    }
    
}
