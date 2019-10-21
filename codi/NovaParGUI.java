/*
Creador:Marc Sau Batlle
Data:20/4/2015
 */
package Inici;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
   Pantalla de creacio de una nova partida en la qual podem escollir les 
   caracteristiques de la partida que volem jugar.
   
   Comportament bàsic:
      - La pantalla de creacio de partida ens deixa escollir diferentes
      caracteristiques:
        * Tipus de tank que usarem
        * Tipus de tank que usaran els enemics
        * Mapa en el que es jugara
      - Quan es premi el buto de començar(Buto del tank) s'iniciara la partida 
      amb les opcions seleccionades
 */

public class NovaParGUI extends javax.swing.JFrame {
    
    ///Enter que ens indica el mapa seleccionar
    int Mapa=1;
    ///Enter que ens indica el tank que usara el jugador
    int Jugador=1;
    ///Enter que ens indica el tank que usara el primer enemic
    int Enemic_1=1;
    ///Enter que ens indica el tank que usara el segon enemic
    int Enemic_2=1;
    ///Enter que ens indica el tank que usara el tercer enemic
    int Enemic_3=1; 
    /**
     Pre:---
     Post: Creem i mostrem la pantalla de creacio de partida
     */       
    public NovaParGUI() throws IOException {
        initComponents();
        Buto_Map1.setSelected(true);
        Jugador1.setSelected(true);
        Enemic1_1.setSelected(true);
        Enemic2_1.setSelected(true);
        Enemic3_1.setSelected(true);
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    /**
    Pre:---
    Post: Inicialitzem els valors, posicions, i caracteristiques de tots els elements gràfics de IniciGUI
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grup_Mapa = new javax.swing.ButtonGroup();
        Grup_Jugador = new javax.swing.ButtonGroup();
        Grup_Enemic1 = new javax.swing.ButtonGroup();
        Grup_Enemic2 = new javax.swing.ButtonGroup();
        Grup_Enemic3 = new javax.swing.ButtonGroup();
        Grup_ModeDeJoc = new javax.swing.ButtonGroup();
        jLabel16 = new javax.swing.JLabel();
        Buto_Com = new javax.swing.JButton();
        Enemic1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Enemic1_1 = new javax.swing.JRadioButton();
        Enemic1_2 = new javax.swing.JRadioButton();
        Enemic1_3 = new javax.swing.JRadioButton();
        Enemic2_1 = new javax.swing.JRadioButton();
        Enemic2_2 = new javax.swing.JRadioButton();
        Enemic2_3 = new javax.swing.JRadioButton();
        Enemic3_1 = new javax.swing.JRadioButton();
        Enemic3_2 = new javax.swing.JRadioButton();
        Enemic3_3 = new javax.swing.JRadioButton();
        Jugador1 = new javax.swing.JRadioButton();
        Jugador2 = new javax.swing.JRadioButton();
        Jugador3 = new javax.swing.JRadioButton();
        Buto_Map1 = new javax.swing.JRadioButton();
        Buto_Map2 = new javax.swing.JRadioButton();
        Buto_Mapa3 = new javax.swing.JRadioButton();
        MapCos = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jLabel16.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel16.setText("Enemics:");

        setResizable(false);

        Buto_Com.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inici/IconaNouJoc.png"))); // NOI18N
        Buto_Com.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buto_ComActionPerformed(evt);
            }
        });

        Enemic1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Enemic1.setText("Enemic1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Enemic2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Enemic3");

        Grup_Enemic1.add(Enemic1_1);
        Enemic1_1.setText("Artilleria");
        Enemic1_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enemic1_1MouseClicked(evt);
            }
        });

        Grup_Enemic1.add(Enemic1_2);
        Enemic1_2.setText("Terrestre");
        Enemic1_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enemic1_2MouseClicked(evt);
            }
        });

        Grup_Enemic1.add(Enemic1_3);
        Enemic1_3.setText("Antiaeri");
        Enemic1_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enemic1_3MouseClicked(evt);
            }
        });

        Grup_Enemic2.add(Enemic2_1);
        Enemic2_1.setText("Artilleria");
        Enemic2_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enemic2_1MouseClicked(evt);
            }
        });

        Grup_Enemic2.add(Enemic2_2);
        Enemic2_2.setText("Terrestre");
        Enemic2_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enemic2_2MouseClicked(evt);
            }
        });

        Grup_Enemic2.add(Enemic2_3);
        Enemic2_3.setText("Antiaeri");
        Enemic2_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enemic2_3MouseClicked(evt);
            }
        });

        Grup_Enemic3.add(Enemic3_1);
        Enemic3_1.setText("Artilleria");
        Enemic3_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enemic3_1MouseClicked(evt);
            }
        });

        Grup_Enemic3.add(Enemic3_2);
        Enemic3_2.setText("Terrestre");
        Enemic3_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enemic3_2MouseClicked(evt);
            }
        });

        Grup_Enemic3.add(Enemic3_3);
        Enemic3_3.setText("Antiaeri");
        Enemic3_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Enemic3_3MouseClicked(evt);
            }
        });

        Grup_Jugador.add(Jugador1);
        Jugador1.setText("Artilleria");
        Jugador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jugador1MouseClicked(evt);
            }
        });

        Grup_Jugador.add(Jugador2);
        Jugador2.setText("Terrestre");
        Jugador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jugador2MouseClicked(evt);
            }
        });

        Grup_Jugador.add(Jugador3);
        Jugador3.setText("Antiaeri");
        Jugador3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jugador3MouseClicked(evt);
            }
        });

        Grup_Mapa.add(Buto_Map1);
        Buto_Map1.setText("Mapa1");
        Buto_Map1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Buto_Map1MouseClicked(evt);
            }
        });

        Grup_Mapa.add(Buto_Map2);
        Buto_Map2.setText("Mapa 2");
        Buto_Map2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Buto_Map2MouseClicked(evt);
            }
        });

        Grup_Mapa.add(Buto_Mapa3);
        Buto_Mapa3.setText("Mapa3");
        Buto_Mapa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Buto_Mapa3MouseClicked(evt);
            }
        });

        Grup_Mapa.add(MapCos);
        MapCos.setText("Costum");
        MapCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapCosActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel14.setText("Mapa:");

        jLabel15.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel15.setText("Enemics:");

        jLabel17.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel17.setText("Jugador:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inici/Terra1.png"))); // NOI18N
        jLabel1.setText("Terra");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inici/TankTerr.png"))); // NOI18N
        jLabel4.setText("Tank Terrestre");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inici/TankArti.png"))); // NOI18N
        jLabel5.setText("Tank Artilleria");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inici/TankAntJug.png"))); // NOI18N
        jLabel6.setText("Tank del Jugador");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inici/TankAnt.png"))); // NOI18N
        jLabel8.setText("Tank Antiaeri");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inici/Paret1.png"))); // NOI18N
        jLabel9.setText("Paret");

        jLabel18.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel18.setText("Ajuda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(Enemic2_1)
                                            .addGap(18, 18, 18)
                                            .addComponent(Enemic2_2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Enemic2_3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Enemic1)
                                            .addGap(18, 18, 18)
                                            .addComponent(Enemic1_1)
                                            .addGap(18, 18, 18)
                                            .addComponent(Enemic1_2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Enemic1_3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(Enemic3_1)
                                            .addGap(18, 18, 18)
                                            .addComponent(Enemic3_2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Enemic3_3))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(306, 306, 306)
                                    .addComponent(jLabel18)))
                            .addGap(41, 41, 41))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(182, 182, 182)
                                    .addComponent(Jugador1)
                                    .addGap(18, 18, 18)
                                    .addComponent(Jugador2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Jugador3))
                                .addComponent(jLabel17))
                            .addGap(39, 39, 39)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(Buto_Map1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Buto_Map2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Buto_Mapa3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MapCos)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(Buto_Com, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Buto_Map1)
                            .addComponent(Buto_Map2)
                            .addComponent(Buto_Mapa3)
                            .addComponent(MapCos)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Enemic1)
                            .addComponent(Enemic1_1)
                            .addComponent(Enemic1_2)
                            .addComponent(Enemic1_3)
                            .addComponent(jLabel15))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Enemic2_1)
                                    .addComponent(Enemic2_2)
                                    .addComponent(Enemic2_3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Enemic3_1)
                                .addComponent(Enemic3_2)
                                .addComponent(Enemic3_3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(Jugador1)
                            .addComponent(Jugador2)
                            .addComponent(Jugador3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(Buto_Com, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     Pre:---
     Post:Canviem el valor de Mapa a  1
     */
    private void Buto_Map1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buto_Map1MouseClicked
        Mapa = 1;
    }//GEN-LAST:event_Buto_Map1MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Mapa a  2
     */
    private void Buto_Map2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buto_Map2MouseClicked
        Mapa = 2;
    }//GEN-LAST:event_Buto_Map2MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Mapa a  3
     */
    private void Buto_Mapa3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Buto_Mapa3MouseClicked
        Mapa = 3;
    }//GEN-LAST:event_Buto_Mapa3MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Jugador a  1
     */
    private void Jugador1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jugador1MouseClicked
       Jugador = 1;
    }//GEN-LAST:event_Jugador1MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Jugador a  2
     */
    private void Jugador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jugador2MouseClicked
       Jugador = 2;
    }//GEN-LAST:event_Jugador2MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Jugador a  3
     */
    private void Jugador3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jugador3MouseClicked
       Jugador = 3;
    }//GEN-LAST:event_Jugador3MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Enemic_1 a  1
     */
    private void Enemic1_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enemic1_1MouseClicked
        Enemic_1 = 1;
    }//GEN-LAST:event_Enemic1_1MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Enemic_1 a  2
     */
    private void Enemic1_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enemic1_2MouseClicked
        Enemic_1 = 2;
    }//GEN-LAST:event_Enemic1_2MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Enemic_1 a  3
     */
    private void Enemic1_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enemic1_3MouseClicked
        Enemic_1 = 3;
    }//GEN-LAST:event_Enemic1_3MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Enemic_2 a  1
     */
    private void Enemic2_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enemic2_1MouseClicked
        Enemic_2 = 1;
    }//GEN-LAST:event_Enemic2_1MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Enemic_2 a  2
     */
    private void Enemic2_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enemic2_2MouseClicked
        Enemic_2 = 2;
    }//GEN-LAST:event_Enemic2_2MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Enemic_2 a  3
     */
    private void Enemic2_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enemic2_3MouseClicked
        Enemic_2 = 3;
    }//GEN-LAST:event_Enemic2_3MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Enemic_3 a  1
     */
    private void Enemic3_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enemic3_1MouseClicked
        Enemic_3 = 1;
    }//GEN-LAST:event_Enemic3_1MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Enemic_3 a  2
     */
    private void Enemic3_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enemic3_2MouseClicked
        Enemic_3 = 2;
    }//GEN-LAST:event_Enemic3_2MouseClicked
    /**
     Pre:---
     Post:Canviem el valor de Enemic_3 a  3
     */
    private void Enemic3_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Enemic3_3MouseClicked
        Enemic_3 = 3;
    }//GEN-LAST:event_Enemic3_3MouseClicked
    /**
     Pre:---
     Post:Creem una partida amb les opcions escollides
     */
    private void Buto_ComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buto_ComActionPerformed
            try {
                new PantallaDeJoc(Mapa, Jugador, Enemic_1, Enemic_2, Enemic_3);
            } catch (IOException ex) {
                Logger.getLogger(NovaParGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_Buto_ComActionPerformed

   /**
     Pre:---
     Post:Canviem el valor de Mapa a  4
     */
    private void MapCosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapCosActionPerformed
       Mapa=4;
    }//GEN-LAST:event_MapCosActionPerformed

    public static void main(String args[]) {

         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NovaParGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(NovaParGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buto_Com;
    private javax.swing.JRadioButton Buto_Map1;
    private javax.swing.JRadioButton Buto_Map2;
    private javax.swing.JRadioButton Buto_Mapa3;
    private javax.swing.JLabel Enemic1;
    private javax.swing.JRadioButton Enemic1_1;
    private javax.swing.JRadioButton Enemic1_2;
    private javax.swing.JRadioButton Enemic1_3;
    private javax.swing.JRadioButton Enemic2_1;
    private javax.swing.JRadioButton Enemic2_2;
    private javax.swing.JRadioButton Enemic2_3;
    private javax.swing.JRadioButton Enemic3_1;
    private javax.swing.JRadioButton Enemic3_2;
    private javax.swing.JRadioButton Enemic3_3;
    private javax.swing.ButtonGroup Grup_Enemic1;
    private javax.swing.ButtonGroup Grup_Enemic2;
    private javax.swing.ButtonGroup Grup_Enemic3;
    private javax.swing.ButtonGroup Grup_Jugador;
    private javax.swing.ButtonGroup Grup_Mapa;
    private javax.swing.ButtonGroup Grup_ModeDeJoc;
    private javax.swing.JRadioButton Jugador1;
    private javax.swing.JRadioButton Jugador2;
    private javax.swing.JRadioButton Jugador3;
    private javax.swing.JRadioButton MapCos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
