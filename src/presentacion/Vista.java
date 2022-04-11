package presentacion;
import javax.swing.*;
import java.awt.Canvas;

public class Vista extends javax.swing.JFrame {
    
    private final Modelo modelo;
    private Controlador control;
 
    public Vista(Modelo m) {
        modelo = m;
        initComponents();
        capturarEventos();        
    }
    public Modelo getModelo() {
        return modelo;
    }
    
    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }
    public Canvas getLienzo() {
        return lienzo;
    }
    public JButton getBtnAnimar() {
        return btnAnimar;
    }
    public JLabel getScore() {
        return Score;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAnimar = new javax.swing.JButton();
        lienzo = new java.awt.Canvas();
        Score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 51));

        btnAnimar.setBackground(new java.awt.Color(0, 51, 51));
        btnAnimar.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        btnAnimar.setForeground(new java.awt.Color(255, 204, 51));
        btnAnimar.setText("Iniciar");
        btnAnimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimarActionPerformed(evt);
            }
        });

        Score.setFont(new java.awt.Font("Courier New", 0, 20)); // NOI18N
        Score.setForeground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnAnimar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Score)))
                .addGap(29, 29, 29)
                .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lienzo, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnAnimar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(Score)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lienzo.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnimarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Score;
    private javax.swing.JButton btnAnimar;
    private javax.swing.JPanel jPanel1;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables
    private char direccion;
    
    private void capturarEventos() {
       btnAnimar.addActionListener(getControl());
       lienzo.addKeyListener(getControl());
    }
}
