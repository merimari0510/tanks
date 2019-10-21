/**
 Creador: Marc Sau Batlle
 Data:20/03/2015
 */
package Inici;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 Pantalla d'inici de Tank 2D la qual es mostrara quan executem el joc i que te 
 enllaços a les diferents opcions d'aquest
 
 Comportament bàsic:
    -La Pantalla d'inici consta de 3 opcions diferents:
        * Obrir l'editor de mapes interaciu amb l'opcio Crear Mapa
        * Obrir el creador de partides amb l'opcio Nova Partida
        * Tancar l'aplicacio
    -Quan aquesta es tanca el joc acaba la seva execucio.
 */
public class IniciGUI extends javax.swing.JFrame {
    
    /**
    Pre: ---
    Post: Creem i mostrem la pantalla d'inici
    */
    public IniciGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
    Pre:---
    Post: Inicialitzem els valors, posicions, i caracteristiques de tots els elements gràfics de IniciGUI
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BSortir = new javax.swing.JButton();
        ObrirNP = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BSortir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inici/exit.png"))); // NOI18N
        BSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSortirActionPerformed(evt);
            }
        });

        ObrirNP.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        ObrirNP.setText("Nova Partida");
        ObrirNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObrirNPActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        jButton1.setText("Crear Mapa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 90)); // NOI18N
        jLabel1.setText(" TANK 2D");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ObrirNP, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ObrirNP, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
    Pre:---
    Post: Parem l'execucio del programa
    */
    private void BSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSortirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BSortirActionPerformed
    /**
     Pre:---
     Post: Creem i mostrem el menu de creacio de nova partida
     */
    private void ObrirNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObrirNPActionPerformed
        try {
            new NovaParGUI();
        } catch (IOException ex) {
            Logger.getLogger(IniciGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ObrirNPActionPerformed
    /**
    Pre:---
    Post: Creem i mostrem el menu de creacio de tauler
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            new CreadorTaulers();
        } catch (IOException ex) {
            Logger.getLogger(IniciGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(IniciGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSortir;
    private javax.swing.JButton ObrirNP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
