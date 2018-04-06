/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastnetv2;

import java.util.Random;

/**
 *
 * @author kleimann
 */
public class Genome {
    
    Set[] dataSets = new Set[10];
    
    Set fittestSet;
    
    float[] baseSet = new float[36];
    
    String name;
    
    public Genome(String name, float[] genDNA){
        
        this.name = name;
        
        Random r = new Random();
        
        baseSet = genDNA;

        for(int i = 0; i < 10; i++){
            float[] mutationBaseSet = baseSet;
            
            
            if (i < 1) {
                int mutationEdge = r.nextInt(36);
            
                if (r.nextInt(2) == 1) {
                    mutationBaseSet[mutationEdge] = mutationBaseSet[mutationEdge] + (r.nextInt(2) + r.nextFloat());
                }else{
                    mutationBaseSet[mutationEdge] = mutationBaseSet[mutationEdge] - (r.nextInt(2) + r.nextFloat());
                }
                
            }

            dataSets[i] = new Set(mutationBaseSet, "Set " + i, this);
        }
        
    }
    
    public Set[] getSets(){
        return dataSets;
    }
    
    public float getAvgFitness(){
        
        float avg = 0;
        
        for (int i = 0; i < 10; i++) {
            avg = avg + dataSets[i].getFitness();   
        }
        avg = avg /10;
        
        return avg;
    }
    
    public Set getFittestSet(){
        for (Set dataSet : dataSets) {
            if (fittestSet == null) {
                fittestSet = dataSet;
            }else{
                if (fittestSet.getFitness() < dataSet.getFitness()) {
                    fittestSet = dataSet;
                }
            }
        }
        return fittestSet;
    }
}
