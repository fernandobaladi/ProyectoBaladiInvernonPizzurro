/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobaladiinvernonpizzurro;

/**
 *
 * @author Invernon
 */
public class distanceMatrix {
    double distanceMatrix[][] = new double[20][20];

    public distanceMatrix() {
        this.InitialMatrix();
    }

    public void setDistance(int row , int col, double value) {
        this.distanceMatrix[row][col] = value;
        this.distanceMatrix[col][row] = value;
    }
    
    public void drawMatrix(){
        for( int i = 0 ; i < 20 ; i++ ){
            for( int j = 0 ; j < 20 ; j++ ){
                System.out.print( distanceMatrix[i][j] + " " );
            }
            System.out.println("\n");
        }
    }
    
    public void InitialMatrix(){
        for( int i = 0 ; i < 20 ; i++ ){
            for( int j = 0 ; j < 20 ; j++ ){
                distanceMatrix[i][j] = -1;
            }
            
        }
    }
    
    public void delete (int pos) {
    
        for( int i = 0 ; i < 20 ; i++ ){
           
            distanceMatrix [i][pos] = -1;
            
        }
        
        for( int i = 0 ; i < 20 ; i++ ){
           
            distanceMatrix [pos][i] = -1;
            
        }
    }
}



