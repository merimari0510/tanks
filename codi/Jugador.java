/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inici;

/**
 *
 * @author Meriem
 */
public class Jugador {
    private int punts;
    private boolean jug_maq; //0 jugador, 1 maquina
    
    public Jugador(){
        punts=0;
    }
    
    public Jugador(boolean j){
        punts=0;
        jug_maq=j;
    }
    
    public void incrementarPunts(int p){
        punts+=p;
    }
    
    public int obtenirPunts() {
        return punts;
    }
    
}