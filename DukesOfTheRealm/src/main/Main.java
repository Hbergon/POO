/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

//import java.util.Random;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;


public class Main extends Application {
    //private Random rnd = new Random();
    final static int WIDTH= 800;
    final static int HEIGHT= 600;
    final static int NB_CASTLE=5;
    
          
          
  final static Image BACKGROUND = new Image(Main.class.getResource("background.jpg").toString());
  
  final static  Image CASTLE = new Image(Main.class.getResource("castle.png").toString());
   
    @Override
    public void start(Stage primaryStage) {
        final ImageView background = new ImageView(BACKGROUND);
        final ImageView castle[]= Showcastles();
        final Group castle_r = new Group(castle);
        
            castle_r.setEffect(new DropShadow());
            
            background.setEffect(new BoxBlur());         
            background.setOpacity(0.5);
            
            
            
            
        final Group root= new Group(background,castle_r);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
   
        primaryStage.setTitle("Dukes of the Realm!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    ImageView[] Showcastles(){
        ImageView[] castle= new ImageView[5];
       for (int i= 0; i<5; i=i+1) {
             castle[i]= new ImageView(CASTLE);
             castle[i].setTranslateX(140*i);
             castle[i].setTranslateY(200);
        }
        
        return castle;
        
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
