package Main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Troupes.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

import Struct.*;


public class DukeOfRealm extends Canvas {
     
    public static final int WIDTH=270; //Default Width
    public static final int HEIGHT=WIDTH/14*10; //Default Height
    public static final int SCALE=4;
    public static final String TITLE="Duke of Realm"; //Name of the Window
   
    public DukeOfRealm(){
        Dimension size = new Dimension(WIDTH*SCALE,HEIGHT*SCALE); 
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
  
    }


    
    
    
    
    
    
    
    public static void main(String[] args) throws IOException {
        DukeOfRealm game= new DukeOfRealm();
        JFrame frame= new JFrame(TITLE);
        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./background.jpg"))))); 

        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
