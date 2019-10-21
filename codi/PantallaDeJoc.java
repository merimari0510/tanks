/*
Creador:Marc Sau Batlle
Data:25/05/2015
 */
package Inici;

import java.awt.Color;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
    Pantalla que representa la pantalla de joc que l'usuari usara per 
    interactuar amb Tank 2D i en la qual l'usuari pot veure les accions que 
    realitzen els tanks enemics al igual que pot escollir quina realitzar.
    
    Comportament basic:
      - Les accions que l'usuari pot realitzar en la pantalla de joc son les 
      seguents:
        * Escollir quina accio vol realitzar
        * Interactuar amb el tauler de joc quan aquest estigui realitzant una 
        accio
        * Visualitzat quines accions estan realitzant els tanks enemics
    
 */

public class PantallaDeJoc extends javax.swing.JFrame {
    ///Matriu d'enters que representa el mapa de joc
    int[][] mapa;
    ///Mida del mapa de joc
    int mida;
    ///Matriu de butons usats per mostrar el tauler per pantalla al igual que per interactuar amb l'usuari
    JButton [][] TaulerB;
    ///Modul d'entrada/sortida usat per llegir i escriure fitxers
    ETauler Entrada;
    ///Enters usat per saber si el jugador vol atacar
    int Atacar=0;
    ///Enter usat per saber si el jugador vol moures
    int Moures=0;
    ///Enter usat per saber si el jugadors vol disparar un missil
    int Missil=0;
    ///Enter usat per saber si el jugadors vol passar de torn
    int PasTorn=0; 
    ///Enter que ens mostra quantes accions principals podem fer
    int FetAccPri=1;
    ///Enter que ens diu quantes accions secundaries podem fer
    int FetAccSec=1;
    ///Boolea que es diu si estem realitzant un moviment
    boolean RealitzantMoviment=false;
    ///Boolea que es diu si estem atacant
    boolean Disparant=false;
    ///Llista dels diferents tanks del tauler
    ArrayList<Tank> LlistaJugadors;
    ///Llista amb les diferents posicions que el nostre tanks es pot moure
    ArrayList<Posicio> Posicions;
    ///Controlador de la IA i de la interaccio entre els tanks
    Tauler Controlador;
    
    /**
     Pre:---
     Post: Creem i mostrem una pantalla de joc sense cap contingut
     */
    public PantallaDeJoc() {
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    /**
     Pre:---
     Post: Creem i mostrem una pantalla de joc amb les caracteristiques entrades
     per parametre(Mapa,Jugador,Enemic_1,Enemic_2,Enemic_3,Mode_Joc)
     */
    public PantallaDeJoc(int Mapa,int Jugador,int Enemic_1,int Enemic_2,int Enemic_3) throws IOException{
        initComponents();
        setVisible(true);
        Entrada = new ETauler();
        
        if(Jugador == 1){
            JugadorGUI.setText("Artilleria");
        }else if(Jugador == 2){
            JugadorGUI.setText("Terrestre");
        }else{
            JugadorGUI.setText("Antiaeri");
        }
        
        if(Enemic_1 == 1){
            Enemic1GUI.setText("Artilleria");   
        }else if(Enemic_1 == 2){
            Enemic1GUI.setText("Terrestre");
        }else{
            Enemic1GUI.setText("Antiaeri");
        }
        
        if(Enemic_2 == 1){
            Enemic2GUI.setText("Artilleria");
        }else if(Enemic_2 == 2){
            Enemic2GUI.setText("Terrestre");
        }else{
            Enemic2GUI.setText("Antiaeri");
        }
        
        if(Enemic_3 == 1){
            Enemic3GUI.setText("Artilleria");
        }else if(Enemic_3 == 2){
            Enemic3GUI.setText("Terrestre");
        }else{
            Enemic3GUI.setText("Antiaeri");
        }
        
        llegirMapa(Mapa);
        CreaTauler();
        Controlador = new Tauler(mapa);       
        LlistaJugadors=Controlador.CrearTanks(Jugador, Enemic_1, Enemic_2, Enemic_3);        
        actualitzaValors();
        PintarTanks();
        this.setLocationRelativeTo(null);
    }
    /**
     Pre:---
     Post: Llegim el contingut del fitxer de text amb identificador Mapa i el 
     guardem com a mapa del tauler
     */   
    private void llegirMapa(int Mapa) throws FileNotFoundException{
        
         if(Mapa == 1){
            mida=Entrada.LlegirFitxer ("Mapa1.txt");
            mapa=Entrada.getMap();
        }else if(Mapa == 2){
            mida=Entrada.LlegirFitxer ("Mapa2.txt");
            mapa=Entrada.getMap();
        }else if(Mapa==3){
            mida=Entrada.LlegirFitxer ("Mapa3.txt");
            mapa=Entrada.getMap();
        }else{
            mida=Entrada.LlegirFitxer ("MapaCostum.txt");
            mapa=Entrada.getMap();       
        }
    }
    /**
     Pre:---
     Post:Pintem les imatges dels tanks actualment vius del joc a la matriu de 
     butons
     */
    private void PintarTanks(){
        ///Posicio usada per guardar la posicio d'un dels tanks
        Posicio p;
        ///Imatge que pintarem com a icona d'un buto del tauler
        Image img; 
        try {
            
            for(int i=0;i<4;i++){
               if(LlistaJugadors.get(i).getBlindatge()>0){
                    if(LlistaJugadors.get(i) instanceof Artilleria){
                      if(i==0){
                        img = ImageIO.read(getClass().getResource("TankArtiJug.png")); 
                      }else{
                        img = ImageIO.read(getClass().getResource("TankArti.png"));
                      }
                    }else if(LlistaJugadors.get(i) instanceof Antiaeri){
                      if(i==0){
                        img = ImageIO.read(getClass().getResource("TankTerrJug.png"));  
                      }else{
                        img = ImageIO.read(getClass().getResource("TankTerr.png")); 
                      }   
                    }else{
                      if(i==0){
                        img = ImageIO.read(getClass().getResource("TankAntJug.png")); 
                      }else{
                        img = ImageIO.read(getClass().getResource("TankAnt.png")); 
                      } 
                    }
                    p=LlistaJugadors.get(i).getPosicio();
                    TaulerB[p.x()][p.y()].setIcon(new ImageIcon(img));
               }
            }
        
        } catch (IOException ex) {
             Logger.getLogger(PantallaDeJoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     Pre:---
     Post:Creem un tauler de butons amb icones que representen el tauler de joc
     */
    private void CreaTauler() throws IOException{
        
        TaulerB = new JButton[mida][mida];
        ///Variable usada per delimitar la gruixudesa del contorn dels butons
        Border thickBorder = new LineBorder(Color.BLACK, 1);
        //String que conte una posicio (x,y) del tauler
        String Posicio;
        for(int i=0; i<mida;i++){
            for(int j=0; j<mida;j++){
                ///String usat per la contruccio d'un string que contingui la posicio d'un buto al tauler
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i);
                sb.append(" ");
                sb.append(j);
                Posicio = sb.toString();
                ///Listener que s'assigna al buto per tal de saber quan l'usuari el clica
                ListenerButoTauler List= new ListenerButoTauler(i,j,this);
                ///Imatge que representa una casella
                Image img;
                if(mapa[i][j]==0){
                   
                   TaulerB[i][j] = new JButton(Posicio);
                   TaulerGUI.add(TaulerB[i][j]);                   
                   img = ImageIO.read(getClass().getResource("Terra1.png"));
                   TaulerB[i][j].setIcon(new ImageIcon(img));
                   TaulerB[i][j].setBorder(thickBorder);
                   
               }else if(mapa[i][j]==1){
                   
                   TaulerB[i][j] = new JButton(" ");
                   TaulerGUI.add(TaulerB[i][j]);
                   img = ImageIO.read(getClass().getResource("Paret1.png"));
                   TaulerB[i][j].setIcon(new ImageIcon(img));
                   TaulerB[i][j].setBorder(thickBorder);
                   
               }
               TaulerB[i][j].addActionListener(List);
            }
         }
        
    }
    /**
     Pre: 0<=Px<15 && 0<=Py<15
     Post: Realitzem l'accio corresponent a les dades entrades antriorment usant
     com a referencia la casella que es troba a la posicio Px,Py del tauler de joc
     */
    public void RealitzarAccio(int Px, int Py) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
        if(RealitzantMoviment){
            
            int i=0;
            while (i<Posicions.size() && RealitzantMoviment){                
                   if(Px==Posicions.get(i).x() && Py==Posicions.get(i).y()){
                     RealitzantMoviment=false;
                   }
                   i++;
            }
            
            if(!RealitzantMoviment){
                ///Posicio desti a la que es vol moure el jugador
                Posicio p=new Posicio(Px,Py);
                ///Posicio actual del tank del jugador
                Posicio x=LlistaJugadors.get(0).getPosicio();   
                ///Imatge que representa una casella
                Image img = ImageIO.read(getClass().getResource("Terra1.png"));
                TaulerB[x.x()][x.y()].setIcon(new ImageIcon(img));               
                Controlador.canviarPosicio(0,p);                
                TextAccions.setText("T'has mogut a la posicio x= " + Px + " y= " + Py);                
                netejaTaulerM();
                PintarTanks();
                FetAccSec--;
            }
            
        }else if (Disparant){
            ///Enter que ens diu la direccio on hem disparat
            int i=-1;
            ///String que ens diu la direccio en la que hem disparat  
            String dir="Buit";
            ///Posicio actual del tank del jugador
            Posicio pos=LlistaJugadors.get(0).getPosicio();
            if (Py==pos.y() && Px>pos.x()){
                Disparant=false;
                dir="Baix";
                i=1;
            }else if(Py==pos.y() && Px<pos.x()){           
                Disparant=false;
                i=0;
                dir="Dalt";
            }else if(Px==pos.x() && Py>pos.y()){           
                Disparant=false;
                i=2;
                dir="Dreta";
            }else if(Px==pos.x() && Py<pos.y()){
                Disparant=false;
                i=3;              
                dir="Esquerra";
            }            
            
            
            if(!Disparant){
                
                ///Posicio on impactara l'atac del tank
                Posicio p;
                if(Missil==0){                       
                    p=Controlador.atacar(0,i);                            
                    netejaTaulerD(); 

                }else{
                    System.out.print("Missil disparat");
                    p=Controlador.missil(0,i);   
                    Missil=0;                      
                    PintarTauler();
                    PintarTanks();
                }
                if(p.x()>=0 && p.x()<15 && p.y()>=0 && p.y()<15){
                    TextAccions.setText( "Has Disparat amd direccio " + dir + " hi has impactat a (" + p.x() + "," + p.y() +")");
                }else{
                    TextAccions.setText( "Has Disparat amd direccio " + dir );
                }                  
                FetAccPri--;                              
            }           
        }
        if ((FetAccPri==0 && FetAccSec==0)){
                   if(FetAccPri==0) FetAccPri++;
                   if(FetAccSec==0) FetAccSec++;
                   Atacar=0;Moures=0;               
                   PassarTorn();
               } 
        actualitzaValors();
    }
    /**
     Pre:---
     Post: Canviem les imatges de tots els butons perque representin el tauler 
     de joc
     */
    private void PintarTauler() throws IOException{
        for(int i=0; i<mida;i++){
            for(int j=0; j<mida;j++){
               ///Imatge que representa una casella del tauler
               Image img; 
               if(mapa[i][j]==0){
                   img = ImageIO.read(getClass().getResource("Terra1.png"));
                   TaulerB[i][j].setIcon(new ImageIcon(img));      
               }else if(mapa[i][j]==1){
                   img = ImageIO.read(getClass().getResource("Paret1.png"));
                   TaulerB[i][j].setIcon(new ImageIcon(img));                   
               }
            }
         }
    }
    /**
     Pre:---
     Post: Canviem les imatges del tauler de terra seleccionat per atacar per 
     imatges de terra normal.
     */
    private void netejaTaulerD() throws IOException{
        ///Posicio actual del tanks del jugador
        Posicio pos=LlistaJugadors.get(0).getPosicio();
        ///Enter que ens marca l'eix en que desseleccionem les imatges
        int i=pos.y()+1;
        ///Imatge que representa una casella del tauler
        Image img;
        while(i<15 && mapa[pos.x()][i]==0){
             img = ImageIO.read(getClass().getResource("Terra1.png"));
             TaulerB[pos.x()][i].setIcon(new ImageIcon(img));
             i++;
        }

        i=pos.y()-1;

        while(i>=0 && mapa[pos.x()][i]==0){
             img = ImageIO.read(getClass().getResource("Terra1.png"));
             TaulerB[pos.x()][i].setIcon(new ImageIcon(img));
             i--;
        }

        i=pos.x()+1;

        while(i<15 && mapa[i][pos.y()]==0){
             img = ImageIO.read(getClass().getResource("Terra1.png"));
             TaulerB[i][pos.y()].setIcon(new ImageIcon(img));
             i++;
        }

        i=pos.x()-1;

        while(i>=0 && mapa[i][pos.y()]==0){
             img = ImageIO.read(getClass().getResource("Terra1.png"));
             TaulerB[i][pos.y()].setIcon(new ImageIcon(img));
             i--;
        }
        PintarTanks();
    }
    /**
     Pre:---
     Post: Actualitzem a la pantalla els nous vlors dels atributs del tank
     */
    private void actualitzaValors(){
                
        VidaJ.setText(Integer.toString(LlistaJugadors.get(0).getBlindatge()));
        MissilsJ.setText(Integer.toString(LlistaJugadors.get(0).getNMissils()));
        PosJ.setText("(" +LlistaJugadors.get(0).getPosicio().x() + "," + LlistaJugadors.get(0).getPosicio().y() + ")");
        
        VidaE1.setText(Integer.toString(LlistaJugadors.get(1).getBlindatge()));
        MissilsE1.setText(Integer.toString(LlistaJugadors.get(1).getNMissils()));
        if(LlistaJugadors.get(1).getBlindatge()>0){
            PosE1.setText("(" +LlistaJugadors.get(1).getPosicio().x() + "," + LlistaJugadors.get(1).getPosicio().y() + ")");
        }else{
            PosE1.setText("RIP");
        }
        
        
        VidaE2.setText(Integer.toString(LlistaJugadors.get(2).getBlindatge()));
        MissilsE2.setText(Integer.toString(LlistaJugadors.get(2).getNMissils()));
        if(LlistaJugadors.get(2).getBlindatge()>0){
            PosE2.setText("(" +LlistaJugadors.get(2).getPosicio().x() + "," + LlistaJugadors.get(2).getPosicio().y() + ")");
        }else{
            PosE2.setText("RIP");
        }
        
        VidaE3.setText(Integer.toString(LlistaJugadors.get(3).getBlindatge()));
        MissilsE3.setText(Integer.toString(LlistaJugadors.get(3).getNMissils()));
        if(LlistaJugadors.get(3).getBlindatge()>0){
            PosE3.setText("(" +LlistaJugadors.get(3).getPosicio().x() + "," + LlistaJugadors.get(3).getPosicio().y() + ")");
        }else{
            PosE3.setText("RIP");            
        }
    }
    /**
     Pre:---
     Post: Canviem les imatges del tauler de terra seleccionat per moures per 
     imatges de terra normal.
     */
    private void netejaTaulerM() throws IOException{
        
        for(int i=0;i<Posicions.size();i++){
            Image img = ImageIO.read(getClass().getResource("Terra1.png"));
             TaulerB[Posicions.get(i).x()][Posicions.get(i).y()].setIcon(new ImageIcon(img));
        }
    }
    /**
    Pre:---
    Post: Inicialitzem els valors, posicions, i caracteristiques de tots els 
    elements gràfics de IniciGUI.
     */
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Accio = new javax.swing.ButtonGroup();
        TaulerGUI = new javax.swing.JPanel();
        Enemic1GUI = new javax.swing.JLabel();
        Enemic2GUI = new javax.swing.JLabel();
        Enemic3GUI = new javax.swing.JLabel();
        JugadorGUI = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        VidaE1 = new javax.swing.JLabel();
        VidaE2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        VidaE3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        VidaJ = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ButoAtac = new javax.swing.JRadioButton();
        ButoPasTorn = new javax.swing.JRadioButton();
        ButoMov = new javax.swing.JRadioButton();
        ButoAccio = new javax.swing.JButton();
        ButoMiss = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        TextAvisos = new javax.swing.JLabel();
        MissilsE2 = new javax.swing.JLabel();
        MissilsE1 = new javax.swing.JLabel();
        MissilsE3 = new javax.swing.JLabel();
        MissilsJ = new javax.swing.JLabel();
        TextAccions = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        PosE1 = new javax.swing.JLabel();
        PosE2 = new javax.swing.JLabel();
        PosE3 = new javax.swing.JLabel();
        PosJ = new javax.swing.JLabel();
        TextAccions2 = new javax.swing.JTextField();
        TextAccions3 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        TextAccions4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        TaulerGUI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TaulerGUI.setLayout(new java.awt.GridLayout(15, 15));

        Enemic1GUI.setText("jLabel1");

        Enemic2GUI.setText("jLabel2");

        Enemic3GUI.setText("jLabel3");

        JugadorGUI.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JugadorGUI.setText("Armadura:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Armadura:");

        VidaE1.setText("jLabel2");

        VidaE2.setText("jLabel2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Armadura:");

        VidaE3.setText("jLabel2");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Armadura:");

        VidaJ.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Missils:");

        Accio.add(ButoAtac);
        ButoAtac.setText("Atacar");
        ButoAtac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButoAtacActionPerformed(evt);
            }
        });

        Accio.add(ButoPasTorn);
        ButoPasTorn.setText("Pasar Torn");
        ButoPasTorn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButoPasTornActionPerformed(evt);
            }
        });

        Accio.add(ButoMov);
        ButoMov.setText("Moviment");
        ButoMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButoMovActionPerformed(evt);
            }
        });

        ButoAccio.setText("Realitzar Accio");
        ButoAccio.setToolTipText("");
        ButoAccio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButoAccioActionPerformed(evt);
            }
        });

        Accio.add(ButoMiss);
        ButoMiss.setText("Missil");
        ButoMiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButoMissActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Missils:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Missils:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Missils:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Accio Principal:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Accio Secundaria:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Enemic1");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Enemic2");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Enemic3");

        TextAvisos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TextAvisos.setText("Entri l'accio que vol realitzar:");

        MissilsE2.setText("jLabel13");

        MissilsE1.setText("jLabel13");

        MissilsE3.setText("jLabel13");

        MissilsJ.setText("jLabel13");

        TextAccions.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel13.setText("Jugador:");

        jLabel14.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel14.setText("Enemics:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Posicio Tauler:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Posicio Tauler:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Posicio Tauler:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Posicio Tauler:");

        PosE1.setText("jLabel19");

        PosE2.setText("jLabel20");

        PosE3.setText("jLabel21");

        PosJ.setText("jLabel22");

        TextAccions2.setEditable(false);
        TextAccions2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextAccions2ActionPerformed(evt);
            }
        });

        TextAccions3.setEditable(false);

        jTextField3.setText("jTextField3");

        TextAccions4.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Jugador:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Enemic1:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Enemic2:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Enemic3:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("14");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("13");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("1");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("2");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("12");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("3");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("4");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("5");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("6");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("7");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("8");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("9");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("10");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("11");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("12");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("13");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("14");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("11");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("10");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("9");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("8");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("7");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("6");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("5");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("4");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("3");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("2");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("1");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel23)
                .addGap(35, 35, 35)
                .addComponent(jLabel26)
                .addGap(30, 30, 30)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel29)
                .addGap(31, 31, 31)
                .addComponent(jLabel30)
                .addGap(33, 33, 33)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addGap(30, 30, 30)
                .addComponent(jLabel33)
                .addGap(28, 28, 28)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addGap(27, 27, 27)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addGap(24, 24, 24)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41)
                            .addComponent(jLabel25)
                            .addComponent(jLabel24))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(TaulerGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PosJ))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ButoMov)
                                            .addComponent(ButoAtac))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ButoPasTorn)
                                            .addComponent(ButoMiss))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ButoAccio))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(JugadorGUI)
                                        .addGap(18, 18, 18)
                                        .addComponent(VidaJ))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(34, 34, 34)
                                        .addComponent(MissilsJ))
                                    .addComponent(jLabel13)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(TextAvisos))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TextAccions3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TextAccions2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TextAccions, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TextAccions4, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(31, 31, 31)
                                .addComponent(Enemic1GUI))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(MissilsE1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PosE1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(VidaE1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(31, 31, 31)
                                .addComponent(Enemic2GUI))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PosE2))
                            .addComponent(jLabel14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(VidaE2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(MissilsE2))))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(VidaE3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(36, 36, 36)
                                .addComponent(MissilsE3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(31, 31, 31)
                                .addComponent(Enemic3GUI))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PosE3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TaulerGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(Enemic1GUI)
                                                .addComponent(jLabel10))
                                            .addComponent(Enemic3GUI)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel17)
                                            .addComponent(PosE1)
                                            .addComponent(PosE3))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel1)
                                                    .addComponent(VidaE1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel3)
                                                    .addComponent(MissilsE1)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel6)
                                                    .addComponent(VidaE3))
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel7)
                                                    .addComponent(MissilsE3)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Enemic2GUI)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(PosE2))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(VidaE2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(MissilsE2))))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JugadorGUI)
                                    .addComponent(VidaJ))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(MissilsJ)
                                    .addComponent(jLabel2))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(PosJ))
                                .addGap(38, 38, 38)
                                .addComponent(TextAvisos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ButoAccio)
                                        .addGap(12, 12, 12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ButoAtac)
                                            .addComponent(ButoMiss)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ButoMov)
                                            .addComponent(ButoPasTorn)
                                            .addComponent(jLabel9))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextAccions, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextAccions2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextAccions3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextAccions4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel52)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel51)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel50)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel49)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel48)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel47)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel46)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel45)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel44)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel43)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel42)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel41)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel28)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel25)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jLabel26)
                        .addComponent(jLabel27)
                        .addComponent(jLabel29))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(jLabel39)
                        .addComponent(jLabel38)
                        .addComponent(jLabel37)
                        .addComponent(jLabel36)
                        .addComponent(jLabel35)
                        .addComponent(jLabel34)
                        .addComponent(jLabel33)
                        .addComponent(jLabel32)
                        .addComponent(jLabel31))
                    .addComponent(jLabel30)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
    Pre:---
    Post: Indiquem que volem realitzar l'accio de passar torn canviant el  
    valor de PasTorna 1 .
     */
    private void ButoPasTornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoPasTornActionPerformed
        if(!RealitzantMoviment && !Disparant){
            PasTorn=1;Atacar=0;Moures=0;Missil=0;
        }       
    }//GEN-LAST:event_ButoPasTornActionPerformed
    /**
    Pre:---
    Post: si no hem realitzat la nostra accio principal Indiquem que volem 
    realitzar l'accio de disparar un missil canviant el valor de Missil a 1 
    altrament mostrem un error per pantalla.
     */
    private void ButoMissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoMissActionPerformed
      if (FetAccPri>0 && LlistaJugadors.get(0).getNMissils()>0 && !RealitzantMoviment && !Disparant){         
        Missil=1;
      }else{
        TextAvisos.setText("Accio Principal ja realitzada");
      }
    }//GEN-LAST:event_ButoMissActionPerformed
    /**
     Pre:---
     Post:Canviem les imatges de terra de totes les caselles en el mateix eix x 
     i y que el tank del jugador fins a la primera paret que trobin agafant com 
     a punt d'inici la casella on es troba el jugador.     
     */
    void pintarLineaAtac() throws IOException{
                       ///Posicio on es troba el tank del jugador
                       Posicio pos=LlistaJugadors.get(0).getPosicio();
                       ///Enter que ens marca l'eix en que desseleccionem les imatges
                       int i=pos.y()+1;
                       ///Imatge que representa una casella del tauler
                       Image img;
                       while(i<15 && mapa[pos.x()][i]==0){
                            img = ImageIO.read(getClass().getResource("Terra1Sel.png"));
                            TaulerB[pos.x()][i].setIcon(new ImageIcon(img));
                            i++;
                       }
                       
                       i=pos.y()-1;
                       
                       while(i>=0 && mapa[pos.x()][i]==0){
                            img = ImageIO.read(getClass().getResource("Terra1Sel.png"));
                            TaulerB[pos.x()][i].setIcon(new ImageIcon(img));
                            i--;
                       }
                       
                       i=pos.x()+1;
                       
                       while(i<15 && mapa[i][pos.y()]==0){
                            img = ImageIO.read(getClass().getResource("Terra1Sel.png"));
                            TaulerB[i][pos.y()].setIcon(new ImageIcon(img));
                            i++;
                       }
                       
                       i=pos.x()-1;
      
                       while(i>=0 && mapa[i][pos.y()]==0){
                            img = ImageIO.read(getClass().getResource("Terra1Sel.png"));
                            TaulerB[i][pos.y()].setIcon(new ImageIcon(img));
                            i--;
                       }
                       
                       PintarTanks();
        
    }
    /**
     Pre:---
     Post:Pintem totes les posicions un el tank es pot moure 
     */
    void pintarAreaMov() throws IOException{
        Posicions= Controlador.PosicionsPossibles(0); 
        for(int i=0;i<Posicions.size();i++){
            Posicio p=Posicions.get(i);
            if(!(p.x()==LlistaJugadors.get(0).getPosicio().x() && p.y()==LlistaJugadors.get(0).getPosicio().y())){
             Image img = ImageIO.read(getClass().getResource("Terra1Sel.png"));
             TaulerB[Posicions.get(i).x()][Posicions.get(i).y()].setIcon(new ImageIcon(img));
            }
        }
        
    }
    /**
     Pre:---
     Post:Realitzem l'accio seleccionada per l'usuari
     */
    private void ButoAccioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoAccioActionPerformed
        if(LlistaJugadors.get(0).getBlindatge()>0){
        Accio.clearSelection();
        try {
            if(!RealitzantMoviment && !Disparant){
               if (Atacar==1 ||  Missil==1){                  
                    Disparant=true;
                    pintarLineaAtac();
               }else if(Moures==1){                  
                   pintarAreaMov();
                   RealitzantMoviment=true;
               }
               Atacar=0;Moures=0;
               if (PasTorn==1){
                   if(FetAccPri==0) FetAccPri++;
                   if(FetAccSec==0) FetAccSec++;
                   Atacar=0;Moures=0;               
                   PassarTorn();
               }  
            }
            PasTorn=0;
           } catch (IOException ex) {
                           Logger.getLogger(PantallaDeJoc.class.getName()).log(Level.SEVERE, null, ex);
           } catch (LineUnavailableException ex) {
            Logger.getLogger(PantallaDeJoc.class.getName()).log(Level.SEVERE, null, ex);
           } catch (UnsupportedAudioFileException ex) {
               Logger.getLogger(PantallaDeJoc.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
    }//GEN-LAST:event_ButoAccioActionPerformed
   /**
    Pre:---
    Post: Realitzem el torn dels enemics del tank del jugador 
    */
    public void PassarTorn() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        ///Variable que ens diu si algun dels tnks enemics esta viu
        boolean AlguViu=false;
        
        int i=1, ordre=0, dir=0;
        while(i<4 && LlistaJugadors.get(0).getBlindatge()>=0){
            if(LlistaJugadors.get(i).getBlindatge()>0){
                 Posicio p=null;
                ArrayList<Integer> ord = Controlador.FerTorn(i,p,this);
                String g;
                ordre=ord.get(0);
                dir=ord.get(1);
                if(dir==0){
                    g="Dalt";
                }else if (dir==1){
                    g="Baix";
                }else if (dir==3){
                    g="Dreta";
                }else if (dir==2){
                    g="Esquerra";
                }else{
                    g="Res";
                }
                System.out.println("                                        Direccio"+ordre);
                System.out.println("                                        Ordre"+dir);
                if(ordre==0){
                    if(i==1){
                        TextAccions2.setText("L'enemic " + i + " s'ha mogut a: (" + LlistaJugadors.get(i).getPosicio().x() + "," + LlistaJugadors.get(i).getPosicio().y() + ")");
                    }else if(i==2){
                        TextAccions3.setText("L'enemic " + i + " s'ha mogut a: (" + LlistaJugadors.get(i).getPosicio().x() + "," + LlistaJugadors.get(i).getPosicio().y() + ")");
                    }else{
                        TextAccions4.setText("L'enemic " + i + " s'ha mogut a: (" + LlistaJugadors.get(i).getPosicio().x() + "," + LlistaJugadors.get(i).getPosicio().y() + ")");
                    }
                    PintarTauler();
                    PintarTanks();                   
                }else if(ordre==1 || ordre==2){
                    if(i==1){
                        TextAccions2.setText("L'enemic " + i + " ha disparat en direccio "+ g );
                    }else if(i==2){
                        TextAccions3.setText("L'enemic " + i + " ha disparat en direccio "+ g );
                    }else{
                        TextAccions4.setText("L'enemic " + i + " ha disparat en direccio "+ g );
                    }
                    PintarTauler();
                    PintarTanks(); 
                }else if(ordre==3 || ordre==6){
                    if(i==1){
                        TextAccions2.setText("L'enemic " + i + " s'ha mogut a: (" + LlistaJugadors.get(i).getPosicio().x() + "," + LlistaJugadors.get(i).getPosicio().y() + ") hi ha disparat cap a " + g);
                    }else if(i==2){
                        TextAccions3.setText("L'enemic " + i + " s'ha mogut a: (" + LlistaJugadors.get(i).getPosicio().x() + "," + LlistaJugadors.get(i).getPosicio().y() +") hi ha disparat cap a "+ g);
                    }else{
                        TextAccions4.setText("L'enemic " + i + " s'ha mogut a: (" + LlistaJugadors.get(i).getPosicio().x() + "," + LlistaJugadors.get(i).getPosicio().y() +") hi ha disparat cap a "+ g);
                    }
                    PintarTauler();
                    PintarTanks();
                }else if(ordre==4 || ordre==5){
                    if(i==1){
                        TextAccions2.setText("L'enemic " + i + " ha disparat cap a "+ g + " hi s'ha mogut a: (" + LlistaJugadors.get(i).getPosicio().x() + "," + LlistaJugadors.get(i).getPosicio().y() +")" );
                    }else if(i==2){
                        TextAccions3.setText("L'enemic " + i + " ha disparat cap a "+ g  + " hi s'ha mogut a: (" + LlistaJugadors.get(i).getPosicio().x() + "," + LlistaJugadors.get(i).getPosicio().y() +")" );
                    }else{
                        TextAccions4.setText("L'enemic " + i + " ha disparat cap a "+ g  + " hi s'ha mogut a: (" + LlistaJugadors.get(i).getPosicio().x() + "," + LlistaJugadors.get(i).getPosicio().y() +")" );
                    }
                    PintarTauler();
                    PintarTanks();
                }
                AlguViu=true;
            } 
            i++;   
            actualitzaValors();
        }
        if(!AlguViu){
            
            new ResultatPartida();
            
        }else if (LlistaJugadors.get(0).getBlindatge()<=0 ){
            
            new ResultatPartidaDerr();
        }
        
    } 
    /**
    Pre:---
    Post: si no hem realitzat la nostra accio principal Indiquem que volem 
    realitzar l'accio de atacar canviant el valor de Atacar a 1 
    altrament mostrem un error per pantalla.
     */
    private void ButoAtacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoAtacActionPerformed
      if (FetAccPri>0 && !RealitzantMoviment && !Disparant){
        PasTorn=0;Atacar=1;Moures=0;Missil=0;
      }else{
        TextAvisos.setText("Accio Principal ja realitzada");
      }
    }//GEN-LAST:event_ButoAtacActionPerformed

   /**
    Pre:---
    Post: si no hem realitzat la nostra accio secundaria Indiquem que volem 
    realitzar l'accio de mourens canviant el valor de Moures a 1 
    altrament mostrem un error per pantalla.
     */
    private void ButoMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoMovActionPerformed
      if (FetAccSec>0 && !RealitzantMoviment && !Disparant){
        PasTorn=0;Atacar=0;Moures=1;Missil=0;
      }else{
        TextAvisos.setText("Accio Secundaria ja realitzada");
      }      
    }//GEN-LAST:event_ButoMovActionPerformed

    private void TextAccions2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextAccions2ActionPerformed

    }//GEN-LAST:event_TextAccions2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaDeJoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaDeJoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaDeJoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaDeJoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaDeJoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Accio;
    private javax.swing.JButton ButoAccio;
    private javax.swing.JRadioButton ButoAtac;
    private javax.swing.JRadioButton ButoMiss;
    private javax.swing.JRadioButton ButoMov;
    private javax.swing.JRadioButton ButoPasTorn;
    private javax.swing.JLabel Enemic1GUI;
    private javax.swing.JLabel Enemic2GUI;
    private javax.swing.JLabel Enemic3GUI;
    private javax.swing.JLabel JugadorGUI;
    private javax.swing.JLabel MissilsE1;
    private javax.swing.JLabel MissilsE2;
    private javax.swing.JLabel MissilsE3;
    private javax.swing.JLabel MissilsJ;
    private javax.swing.JLabel PosE1;
    private javax.swing.JLabel PosE2;
    private javax.swing.JLabel PosE3;
    private javax.swing.JLabel PosJ;
    private javax.swing.JPanel TaulerGUI;
    private javax.swing.JTextField TextAccions;
    private javax.swing.JTextField TextAccions2;
    private javax.swing.JTextField TextAccions3;
    private javax.swing.JTextField TextAccions4;
    private javax.swing.JLabel TextAvisos;
    private javax.swing.JLabel VidaE1;
    private javax.swing.JLabel VidaE2;
    private javax.swing.JLabel VidaE3;
    private javax.swing.JLabel VidaJ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
