/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastnetv2;

/**
 *
 * @author kleimann
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

public class Frame extends JFrame {
    
    Level level1 = new Level();
    
    int[][] walk = new int[50][7];
    
    
    public Frame(){
        runDevelopment();
    }
    
    
    public void paint(Graphics g) {
        super.paint(g);
        level1.paintLevel(g);
        
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 7; j++) {
                if (walk[i][j] == 1) {
                    g.setColor(Color.red);
                    g.fillRect(105+i*16, 105+j*20, 7, 11);
                }
            }
        }
    }
    
    
    
    
    public void runDevelopment(){
        
        boolean startup = true;
        float[] startDNA = new float[36];
        Genome workGenome = null;
        
        Set masterSet = null;

        
        Random r = new Random();
        
        if (startup) {
            for (int i = 0; i < 36; i++) {
                if (r.nextInt(2) == 1) {
                     startDNA[i] = r.nextFloat();
                }else{
                     startDNA[i] = -r.nextFloat();                    
                }
            }
            
            workGenome = new Genome("Genome " + 1, startDNA);
        }
        
        
        
        for (int x = 0; x < 1000000; x++) {
            
            this.repaint();

            int highest = 0;
            
            if (startup != true) {
                workGenome = new Genome("Genome " + x *1, masterSet.edges);
                
            }
            
            Set[] sets = workGenome.getSets();            
            
            for (int i = 0; i < 10; i++) {
                runSet(sets[i], level1);
            }
        
            if (masterSet == null) {
                masterSet = workGenome.getFittestSet();
            }else{
                if (masterSet.Fitness < workGenome.getFittestSet().Fitness) {
                    masterSet = workGenome.getFittestSet();
                }
            }
            
            //System.out.println("Fitness " + masterSet.Fitness);
            
            startup = false;
        }
    }
    
    public void runSet(Set workSet, Level workLevel){
        boolean alive = true;
        int fitnessCounter = 0;
        
        int positionY = 3;
        
        boolean action = false;
        int stayCounter = 0;
        
        
        //System.out.println(workSet.name + workSet.parent.name);
        
        while (alive) {            
            float[] output;
            output = workSet.generateOutput(workLevel.walls[fitnessCounter][positionY - 1], workLevel.walls[fitnessCounter+1][positionY], workLevel.walls[fitnessCounter][positionY + 1]);

            if (output[0] > -1 && action == false) {
                fitnessCounter++;
                action = true;
                //System.out.println("Vorwärts");
            }
            
            if (output[1] > 1 && action == false) {
                positionY++;
                //System.out.println("Rechts");
            }else if (output[1] < -1 && action == false) {
                positionY--;
                //System.out.println("Links");
            }
            
            if (fitnessCounter == 49) {
                //System.out.println("Super schlau");
                return;
            }

            if (positionY > 7 || positionY < 0) {
                workSet.Fitness = fitnessCounter;
                //System.out.println("Fitness: " + workSet.Fitness);
                //System.out.println("Tot");
                return;                
            }

           


            if (workLevel.walls[fitnessCounter][positionY] == 1) {
                workSet.Fitness = fitnessCounter;
                //System.out.println("Fitness: " + workSet.Fitness);
                //System.out.println("Tot");
                return;
            }

            walk[fitnessCounter][positionY] = 1; 
            
            if (action == false) {
                stayCounter++;
            }
            if (stayCounter >= 10) {
                workSet.Fitness = fitnessCounter;
                //System.out.println("Fitness: " + workSet.Fitness);
                //System.out.println("Auch tot");
                return;
            }
            action = false;

        }
        
    }
    
    public void paintWalk(Graphics g, int x, int y){
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 20);
    }
    
    
    
}
