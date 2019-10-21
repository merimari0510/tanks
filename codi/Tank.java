package Inici;

/**
 * \brief Classe que encapsula el tank
 */

import java.util.Stack;
import java.util.ArrayList;

public class Tank extends ObjectesDeTauler{
    protected int dany; /**< indica el dany del tank */
    protected int n_miss;
    protected int blindatge;
    protected int habilitat;
    protected int punts;
    protected int mov;
    protected int modeJoc; //0 per classic, 1 per reydelacolina
    protected Posicio posActual;
    protected Posicio posInicial;
    protected Jugador jug;
    protected Stack<Posicio> moviments; 
    //Tots només es mouran una posicio i només en horitzontal o en vertical
    
    public Tank() {
        dany = 0;
        n_miss = 0;
        blindatge = 0;
        habilitat = 0;
        moviments = new Stack(); 
        punts = 0;
        mov=0;
    }
    
    int getMov() {
        return mov;
    }
    
    public void assignarPosicioInicial(Posicio p){
        posInicial = new Posicio(p.x(), p.y());
        moviments.push(p);
    }
    
    public void disminuirMissil() {
        n_miss--;
    }
    public void disminueixBlindatge(int p) {
        blindatge-=p;
    }
    
    public int getDany() {
        return dany;
    }
    
    public Posicio getPosicio() {
        return posActual;
    }
    
    public void assignarPosicio(Posicio p){
        posActual = new Posicio(p.x(),p.y());
    }
    
    public int getNMissils() {
        return n_miss;
    }
    
    public int getBlindatge() {
        return blindatge;
    }
    
    public void reviureTank() {
        blindatge = 0;
        n_miss = 0;
        habilitat = 0;
        dany = 0;
        moviments.clear();
        posActual=posInicial;
        moviments.push(posActual);
    }
    
    public int getPunts() {
        return punts;
    }
    
}