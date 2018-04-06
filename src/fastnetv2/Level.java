/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastnetv2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author kleimann
 */
public class Level {

int[][] walls = new int[50][7];

Random r = new Random();

public Level(){
    for (int i = 0; i < 50; i++) {
        walls[i][0] = 1;
        walls[i][6] = 1;
        walls[i][1] = 0;
        walls[i][2] = 0;
        walls[i][3] = 0;
        walls[i][4] = 0;
        walls[i][5] = 0;

        
        
        if(i > 5){
            walls[i][r.nextInt(6)] = 1;
        }
        
    }
}

public void paintLevel(Graphics g){
    g.setColor(Color.black);
    
    g.drawLine(100, 100, 900, 100);
    g.drawLine(100, 200, 900, 200);
    g.drawLine(100, 100, 100, 220);
    g.drawLine(900, 100, 900, 220);
    
    g.drawLine(100, 120, 900, 120);
    g.drawLine(100, 140, 900, 140);
    g.drawLine(100, 160, 900, 160);
    g.drawLine(100, 180, 900, 180);
    g.drawLine(100, 200, 900, 200);
    g.drawLine(100, 220, 900, 220);
    
    for (int i = 0; i < 50; i++) {
        g.drawLine(100+i*16, 100, 100+i*16, 220);

        if (walls[i][0] == 1) {
            g.fillRect(100+i*16, 100, 16, 20);
        }
        if (walls[i][1] == 1) {
            g.fillRect(100+i*16, 120, 16, 20);
        }
        if (walls[i][2] == 1) {
            g.fillRect(100+i*16, 140, 16, 20);
        }
        if (walls[i][3] == 1) {
            g.fillRect(100+i*16, 160, 16, 20);
        }
        if (walls[i][4] == 1) {
            g.fillRect(100+i*16, 180, 16, 20);
        }
        if (walls[i][5] == 1) {
            g.fillRect(100+i*16, 200, 16, 20);
        }
        if (walls[i][6] == 1) {
            g.fillRect(100+i*16, 220, 16, 20);
        }
    }
    
    
}
    
}
