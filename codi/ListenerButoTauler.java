/*
Creador:Marc Sau Batlle
Dia:25/05/2015
 */
package Inici;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 Lisener que realitza la funcio de avisar a la Pantalla de joc cada cop que una 
 posicio del tauler es clicada per el jugador
 */
public class ListenerButoTauler implements ActionListener {
    ///Enter que representa la posicio en l'eix x del buto que te aquest listener assignat
    int x;
    ///Enter que representa la posicio en l'eix y del buto que te aquest listener assignat
    int y;
    ///Enter que ens indica si aquest lisener esta set fent servir per el creador de taulers o per la pantalla de joc
    int valors;
    /// Pantalla de joc a la qual ha de informar aquest listener
    PantallaDeJoc p;
    /// Tauler de joc al qual ha de informar aquest listener
    CreadorTaulers t;
    
    /**
     Pre: 15>Px>=0 && 15>Py>=0 
     Post: Hem creat el listener del buto a la pòsicio (Px,Py) el qual pertany al la pantalla de joc Pp 
     */
    ListenerButoTauler(int Px, int Py, PantallaDeJoc Pp){
        x=Px;
        y=Py;
        p=Pp;
        valors=0;
    }
    /**
     Pre: 15>Px>=0 && 15>Py>=0 
     Post: Hem creat el listener del buto a la pòsicio (Px,Py) el qual pertany al creador de taulers Pt 
     */
    ListenerButoTauler(int Px, int Py, CreadorTaulers Pt){
        x=Px;
        y=Py;
        t=Pt;
        valors=1;
    }
    
    @Override
    /**
     Pre:---
     Pre: Si valors es 0 informem a la pantalla de joc que algu ha pres el buto 
     altrament informem al creador de taulers que algu ha pres el buto 
     */
    public void actionPerformed(ActionEvent e) {
        try {
            if (valors==0){
                try {
                    p.RealitzarAccio(x,y);
                } catch (LineUnavailableException ex) {
                   
                } catch (UnsupportedAudioFileException ex) {
                    
                }
            }else{
                t.posicioSel(x,y);
            }           
        } catch (IOException ex) {
            Logger.getLogger(ListenerButoTauler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ListenerButoTauler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
