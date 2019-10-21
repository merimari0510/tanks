/**
 Creador: Marc Sau Batlle
 Data:18/03/2015
 */
package Inici;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ETauler {
    ///Mida del tauler 
    int mida;
    ///Matriu que representa un tauler 
    int m[][];
    
    /**
    Pre:NFitxer correspon al nom d'un dels fitxers de mapa del joc
    Post:Llegim el fitxer de text NFitxer i el guardem a m
     */
    public int LlegirFitxer (String NFitxer) throws FileNotFoundException {
        String path = ETauler.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String g=new File(path).getParentFile().getAbsolutePath();
        Scanner entrada=new Scanner(new File(g+ "/" + NFitxer));
        mida = Integer.parseInt(entrada.next());
        int act;
        m = new int[mida][mida];
        for(int i=0; i<mida;i++){
            for(int j=0; j<mida;j++){
                act=Integer.parseInt(entrada.next());
                m[i][j]=act;
            }
        }
        entrada.close();
        return mida;
       
    }
    /**
     Pre:---
     Post: Retornem la matriu llegida per fitxer
     */
    public int[][] getMap(){
        return m;
    }
    /**
     Pre: m es una matriu de 15x15
     Post: Escrivim la mida i el contingut de m en el fitxer de text Mapa Costum
     */
    public void escriureMapa(int [][] m) throws IOException, URISyntaxException{
        String path = ETauler.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String g=new File(path).getParentFile().getAbsolutePath();     
        File file = new File(g+ "/MapaCostum.txt");
        PrintWriter writer = new PrintWriter(file); 
        writer.println("15");        
        for(int i=0; i<mida;i++){
            for(int j=0; j<mida;j++){
                writer.print(m[i][j]);
                writer.print(" ");
                System.out.print(m[i][j]);
            }
            System.out.println();
            writer.println("");
        }
        writer.close();
     }  
}