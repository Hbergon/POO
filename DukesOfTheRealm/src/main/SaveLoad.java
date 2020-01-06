package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import struct.Chateau;
import struct.Player;

public class SaveLoad {

    
   void save( ArrayList<Chateau> castles) throws FileNotFoundException, IOException{

       try (FileWriter pw = new FileWriter("Castles")) {
           for (int i= 0 ; i<castles.size() ; i++){
               Chateau c =castles.get(i);
               pw.write(c.getProprio().getName());
               pw.write(c.getPosition_x());
               pw.write(c.getPosition_y());
               pw.write(c.getLvl());
               pw.write(c.getProd());
               
               
           }
       }
   }
        
    ArrayList<Chateau> load() throws FileNotFoundException, IOException{
        ArrayList<Chateau> castles= new ArrayList<>();
       try (BufferedReader br = new BufferedReader(new FileReader("castles"))) {
           String line;
           int cmpt=0;
           String name="";
           int color=0;
           int position_x=0;
           int position_y=0;
           int level=0;
           int production=0;
           while ((line = br.readLine()) != null) {
               
               switch (cmpt) {
                   case 0:
                       name=line;
                       break;
                   case 1:
                       break;
                   case 2:
                       position_x= Integer.parseInt(line);
                       break;
                   case 3:
                       position_y= Integer.parseInt(line);
                       break;
                   case 4:
                       level=Integer.parseInt(line);
                       break;
                   case 5:
                       production=0;
                       break;
                   default:
                       break;
               }
               cmpt=(cmpt+1)%6;
               Player p=new Player(name,color);
               Chateau c= new Chateau(p, position_x, position_y);
               c.setProd(production);
               c.setLvl(level);
               castles.add(c);
               
               
           }  
       }
       return castles;
    
    }
    }
