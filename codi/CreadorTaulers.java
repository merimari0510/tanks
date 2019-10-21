/*
Creador:Marc Sau Batlle
Data:25/05/2015
 */
package Inici;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


/**
 Pantalla de creacio de tauler en la qual podem modificar un mapa custom per 
 poder jugarlo previament en el joc de Tank 2D
 
 Comportament bàsic:
    -En la pantalla de creacio de Tauler podrem fer principalment 2 coses:
        * Canviar el contingut d'una casella previament seleccionada al 
        contingut que desitgem
        * Guardar els canvis realitzats al tauler 
 */

public class CreadorTaulers extends javax.swing.JFrame {

    ///Mida del tauler
    int mida;
    ///Matriu que representa el tauler
    int[][] mapa;
    ///Modul d'entrada/sortida usat per llegir i escriure fitxers
    ETauler Entrada;
    ///Matriu de butons que mostrem el tauler per pantalla
    JButton [][] TaulerB;
    ///Posicio en l'eix x de la posicio ue tenim seleccionada
    int P_actX=0;
    ///Posicio en l'eix y de la posicio ue tenim seleccionada
    int P_actY=0;
    ///Enter que ens diu si volem posicionat una paret en el tauler o un tros de terra
    int Paret=0;
    
    /**
    Pre: ---
    Post: Creem i mostrem la pantalla d'inici
    */
    public CreadorTaulers() throws IOException {
        initComponents();
        Entrada = new ETauler();
        mida=Entrada.LlegirFitxer("MapaCostum.txt");
        mapa=Entrada.getMap();
        CreaTauler();
        setVisible(true);
        ButoTerra.setSelected(true);
        this.setLocationRelativeTo(null);
    }

    /**
    Pre: ---
    Post: Creem una matriu de butons que mostra el tauler per pantalla
    */
    private void CreaTauler() throws IOException{
        
        TaulerB = new JButton[mida][mida];
        Border thickBorder = new LineBorder(Color.BLACK, 1);
        String Posicio;
        for(int i=0; i<mida;i++){
            for(int j=0; j<mida;j++){
                
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(i);
                sb.append(" ");
                sb.append(j);
                Posicio = sb.toString();
                ListenerButoTauler List= new ListenerButoTauler(i,j,this);
                if(mapa[i][j]==0){
                   
                   TaulerB[i][j] = new JButton(Posicio);
                   TaulerGUI.add(TaulerB[i][j]);
                   Image img = ImageIO.read(getClass().getResource("/Inici/"+"Terra1.png"));
                   TaulerB[i][j].setIcon(new ImageIcon(img));
                   TaulerB[i][j].setBorder(thickBorder);
                   
               }else if(mapa[i][j]==1){
                   
                   TaulerB[i][j] = new JButton(" ");
                   TaulerGUI.add(TaulerB[i][j]);
                   Image img = ImageIO.read(getClass().getResource("/Inici/"+"Paret1.png"));
                   TaulerB[i][j].setIcon(new ImageIcon(img));
                   TaulerB[i][j].setBorder(thickBorder);
                   
               }
               TaulerB[i][j].addActionListener(List);
            }
         }
        Image img = ImageIO.read(getClass().getResource("/Inici/"+"TankTerr.png"));
        TaulerB[0][0].setIcon(new ImageIcon(img));
        TaulerB[0][14].setIcon(new ImageIcon(img));
        TaulerB[14][0].setIcon(new ImageIcon(img));
        TaulerB[14][14].setIcon(new ImageIcon(img));
    }
    
    /**
    Pre: ---
    Post: La posicio seleccionada pasa a ser la posicio (x,y)
    */
    void posicioSel(int x, int y){
        P_actX=x;
        P_actY=y;
        Casella.setText("(" + x + "," + y + ")");
    }
    /**
    Pre:---
    Post: Inicialitzem els valors, posicions, i caracteristiques de tots els elements gràfics de IniciGUI
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        ButoTerra = new javax.swing.JRadioButton();
        ButoParet = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        Casella = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TaulerGUI = new javax.swing.JPanel();
        ButoCanviCasella = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonGroup1.add(ButoTerra);
        ButoTerra.setText("Terra");
        ButoTerra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButoTerraActionPerformed(evt);
            }
        });

        buttonGroup1.add(ButoParet);
        ButoParet.setText("Paret");
        ButoParet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButoParetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Casella Seleccionada:");

        Casella.setText("(X,X)");

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inici/save.png"))); // NOI18N
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Canviar el contingut de la casella a: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("INSTRUCCIONS D'ÚS:");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("El tauler situat a l'esquerra de la pantalla representa ");

        jLabel6.setText("el tauler que estas editant, si  vols canviar el contingut");

        jLabel7.setText("d'una casella clica sobre ella, selecciona quin contingut");

        jLabel8.setText("vols que tingui,  clica el boto de canviar casella,  i");

        jLabel9.setText(" automaticament el mapa es canviara.  ");

        jLabel10.setText("Per guardar els canvis que hagis fet en el tauler clica el");

        jLabel11.setText("boto de guardar de la part inferior dreta de la finestra.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TaulerGUI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TaulerGUI.setLayout(new java.awt.GridLayout(15, 15));

        ButoCanviCasella.setFont(new java.awt.Font("Tunga", 0, 18)); // NOI18N
        ButoCanviCasella.setText("Canviar Casella");
        ButoCanviCasella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButoCanviCasellaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TaulerGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ButoParet)
                                                .addComponent(ButoTerra))
                                            .addGap(18, 18, 18)
                                            .addComponent(ButoCanviCasella))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(3, 3, 3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Casella))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(60, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Casella))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ButoParet)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButoTerra))
                            .addComponent(ButoCanviCasella))
                        .addGap(38, 38, 38)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TaulerGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
    Pre:---
    Post: Canviem el valor de Paret a 1
     */
    private void ButoParetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoParetActionPerformed
       Paret=1;
    }//GEN-LAST:event_ButoParetActionPerformed
     /**
    Pre:---
    Post: Canviem el valor de Paret a 0
     */
    private void ButoTerraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoTerraActionPerformed
       Paret=0;
    }//GEN-LAST:event_ButoTerraActionPerformed
   /**
   Pre:---
   Post: Si la casella seleccionada no es tracta de la casella (0,0) o (0,14) o
   (14,0) o (14,14) canviem el seu contingut per el contingut de Paret altrament
   no fem res
   */
    private void ButoCanviCasellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButoCanviCasellaActionPerformed
        
        if(!(P_actX==0 && P_actY==0) && !(P_actX==0 && P_actY==14) && !(P_actX==14 && P_actY==0) && !(P_actX==14 && P_actY==14)){
            mapa[P_actX][P_actY]=Paret;
            if(Paret==0){
                try {
                    Image img = ImageIO.read(getClass().getResource("/Inici/"+"Terra1.png"));
                    TaulerB[P_actX][P_actY].setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    Logger.getLogger(CreadorTaulers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    Image img = ImageIO.read(getClass().getResource("/Inici/"+"Paret1.png"));
                    TaulerB[P_actX][P_actY].setIcon(new ImageIcon(img));
                } catch (IOException ex) {
                    Logger.getLogger(CreadorTaulers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ButoCanviCasellaActionPerformed
    /**
     Pre:---
     Post: Guardem els canvis fets al mapa
     */
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        
        try {
            Entrada.escriureMapa(mapa);
        } catch (IOException ex) {
            Logger.getLogger(CreadorTaulers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CreadorTaulers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CreadorTaulers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreadorTaulers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreadorTaulers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreadorTaulers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CreadorTaulers().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(CreadorTaulers.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButoCanviCasella;
    private javax.swing.JRadioButton ButoParet;
    private javax.swing.JRadioButton ButoTerra;
    private javax.swing.JLabel Casella;
    private javax.swing.JPanel TaulerGUI;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
