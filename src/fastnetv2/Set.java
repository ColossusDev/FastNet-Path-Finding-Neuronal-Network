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
public class Set {
    
    int Fitness = 0;
    
    float[] edges;
    
    float A1, A2, A3, A4, B1, B2, B3, B4;
    
    String name;
    
    Genome parent;
    
    //Layer 1
    Edge E_In1_A1;
    Edge E_In1_A2;
    Edge E_In1_A3;
    Edge E_In1_A4;
    
    Edge E_In2_A1;
    Edge E_In2_A2;
    Edge E_In2_A3;
    Edge E_In2_A4;
    
    Edge E_In3_A1;
    Edge E_In3_A2;
    Edge E_In3_A3;
    Edge E_In3_A4;
    
    //Layer 2
    Edge E_A1_B1;
    Edge E_A1_B2;
    Edge E_A1_B3;
    Edge E_A1_B4;

    Edge E_A2_B1;
    Edge E_A2_B2;
    Edge E_A2_B3;
    Edge E_A2_B4;
    
    Edge E_A3_B1;
    Edge E_A3_B2;
    Edge E_A3_B3;
    Edge E_A3_B4;
    
    Edge E_A4_B1;
    Edge E_A4_B2;
    Edge E_A4_B3;
    Edge E_A4_B4;
    
    //Layer 3
    Edge E_B1_Out1;
    Edge E_B2_Out1;
    Edge E_B3_Out1;
    Edge E_B4_Out1;  
    
    Edge E_B1_Out2;
    Edge E_B2_Out2;
    Edge E_B3_Out2;
    Edge E_B4_Out2;

    public Set(float[] edges, String name, Genome parent){
        
        this.edges = edges;
        this.name = name;
        this.parent = parent;

        //Layer 1
        this.E_In1_A1 = new Edge(edges[0]);
        this.E_In2_A1 = new Edge(edges[1]);
        this.E_In3_A1 = new Edge(edges[2]);
        this.E_In1_A2 = new Edge(edges[3]);
        
        this.E_In2_A2 = new Edge(edges[4]);
        this.E_In3_A2 = new Edge(edges[5]);
        this.E_In1_A3 = new Edge(edges[6]);
        this.E_In2_A3 = new Edge(edges[7]);
        
        this.E_In3_A3 = new Edge(edges[8]);
        this.E_In1_A4 = new Edge(edges[9]);
        this.E_In2_A4 = new Edge(edges[10]);
        this.E_In3_A4 = new Edge(edges[11]);
        
        //Layer 2
        this.E_A1_B1 = new Edge(edges[12]);
        this.E_A1_B2 = new Edge(edges[13]);
        this.E_A1_B3 = new Edge(edges[14]);
        this.E_A1_B4 = new Edge(edges[15]);   
        
        this.E_A2_B1 = new Edge(edges[16]);
        this.E_A2_B2 = new Edge(edges[17]);
        this.E_A2_B3 = new Edge(edges[18]);
        this.E_A2_B4 = new Edge(edges[19]);
        
        this.E_A3_B1 = new Edge(edges[20]);
        this.E_A3_B2 = new Edge(edges[21]);
        this.E_A3_B3 = new Edge(edges[22]);
        this.E_A3_B4 = new Edge(edges[23]);
        
        this.E_A4_B1 = new Edge(edges[24]);
        this.E_A4_B2 = new Edge(edges[25]);
        this.E_A4_B3 = new Edge(edges[26]);
        this.E_A4_B4 = new Edge(edges[27]);
        
        //Layer 3
        this.E_B1_Out1 = new Edge(edges[28]);
        this.E_B2_Out1 = new Edge(edges[29]);
        this.E_B3_Out1 = new Edge(edges[30]);
        this.E_B4_Out1 = new Edge(edges[31]);
        
        this.E_B1_Out2 = new Edge(edges[32]);
        this.E_B2_Out2 = new Edge(edges[33]);
        this.E_B3_Out2 = new Edge(edges[34]);
        this.E_B4_Out2 = new Edge(edges[35]);
    }
    
    
    public float[] generateOutput(int input1, int input2, int input3){
        
        int in1 = input1;
        int in2 = input2;
        int in3 = input3;
        
        float out1;
        float out2;
        
        A1 = (in1 * E_In1_A1.getX()) + (in2 * E_In2_A1.getX()) + (in3 * E_In3_A1.getX());
        A2 = (in1 * E_In1_A2.getX()) + (in2 * E_In2_A2.getX()) + (in3 * E_In3_A2.getX());
        A3 = (in1 * E_In1_A3.getX()) + (in2 * E_In2_A3.getX()) + (in3 * E_In3_A3.getX());
        A4 = (in1 * E_In1_A4.getX()) + (in2 * E_In2_A4.getX()) + (in3 * E_In3_A4.getX());
        
        B1 = (A1 * E_A1_B1.getX()) + (A2 * E_A2_B1.getX()) + (A3 * E_A3_B1.getX()) + (A4 * E_A4_B1.getX());
        B2 = (A1 * E_A1_B2.getX()) + (A2 * E_A2_B2.getX()) + (A3 * E_A3_B2.getX()) + (A4 * E_A4_B2.getX());
        B3 = (A1 * E_A1_B3.getX()) + (A2 * E_A2_B3.getX()) + (A3 * E_A3_B3.getX()) + (A4 * E_A4_B3.getX());
        B4 = (A1 * E_A1_B4.getX()) + (A2 * E_A2_B4.getX()) + (A3 * E_A3_B4.getX()) + (A4 * E_A4_B4.getX());
        
        out1 = (B1 * E_B1_Out1.getX()) + (B2 * E_B2_Out1.getX()) + (B3 * E_B3_Out1.getX()) + (B4 * E_B4_Out1.getX());
        out2 = (B1 * E_B1_Out2.getX()) + (B2 * E_B2_Out2.getX()) + (B3 * E_B3_Out2.getX()) + (B4 * E_B4_Out2.getX());

        float[] output = new float[2];
        
        output[0] = out1;
        output[1] = out2;
        
        return output;
    }
    
    public float getFitness(){
        return Fitness;
    }
}
