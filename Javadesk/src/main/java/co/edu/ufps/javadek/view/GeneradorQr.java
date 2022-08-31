/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.ufps.javadek.view;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import co.edu.ufps.javadesk.controller.GenerarQR;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Base64;
import sun.misc.BASE64Decoder;

/**
 *
 * @author usuario
 */
public class GeneradorQr extends javax.swing.JFrame {

    /**
     * Creates new form GeneradorQr
     */
    public GeneradorQr() {
        initComponents();
    }

    public void decoder(String base64Image, String pathFile) {

        try ( FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
            //Convertir B64 a Imagen
            byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
            imageOutFile.write(imageByteArray);

            File file = new File(System.getProperty("user.dir") + "\\imagesQR\\image_qr.png");        
            BufferedImage bufferedImage = ImageIO.read(file);
            ImageIcon imageIcon = new ImageIcon(bufferedImage);

            this.labelQr.setIcon(imageIcon);
        } catch (FileNotFoundException e) {
            System.out.println("Imagen no encontrada" + e);
        } catch (IOException ioe) {
            System.out.println("Error" + ioe);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRound2 = new co.edu.ufps.javadek.view.PanelRound();
        sitiWeb2 = new javax.swing.JLabel();
        GenerarBut1 = new javax.swing.JButton();
        textUrl = new javax.swing.JTextField();
        sitiWeb1 = new javax.swing.JLabel();
        ExportarBut2 = new javax.swing.JButton();
        labelQr = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        userNombre = new javax.swing.JLabel();
        icono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(132, 140, 220));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(153, 51, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Genere su código QR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 280, -1));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(10);
        panelRound2.setRoundBottomRight(10);
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);

        sitiWeb2.setBackground(new java.awt.Color(0, 0, 0));
        sitiWeb2.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        sitiWeb2.setText("Sitio web (URL)");

        GenerarBut1.setBackground(new java.awt.Color(105, 115, 184));
        GenerarBut1.setFont(new java.awt.Font("Bell MT", 1, 14)); // NOI18N
        GenerarBut1.setForeground(new java.awt.Color(255, 255, 255));
        GenerarBut1.setText("Generar código QR");
        GenerarBut1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GenerarBut1.setBorderPainted(false);
        GenerarBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarBut1ActionPerformed(evt);
            }
        });

        textUrl.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        textUrl.setText("URL...");
        textUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUrlActionPerformed(evt);
            }
        });

        sitiWeb1.setBackground(new java.awt.Color(0, 0, 0));
        sitiWeb1.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        sitiWeb1.setText("Código QR");

        ExportarBut2.setBackground(new java.awt.Color(105, 115, 184));
        ExportarBut2.setFont(new java.awt.Font("Bell MT", 1, 14)); // NOI18N
        ExportarBut2.setForeground(new java.awt.Color(255, 255, 255));
        ExportarBut2.setText("Exportar QR");
        ExportarBut2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ExportarBut2.setBorderPainted(false);
        ExportarBut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportarBut2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(sitiWeb2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sitiWeb1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(GenerarBut1))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(textUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(labelQr, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExportarBut2)
                .addGap(92, 92, 92))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sitiWeb1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sitiWeb2))
                        .addGap(58, 58, 58)
                        .addComponent(textUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(GenerarBut1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(labelQr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExportarBut2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 700, 270));

        jPanel4.setBackground(new java.awt.Color(175, 179, 210));

        userNombre.setBackground(new java.awt.Color(255, 255, 255));
        userNombre.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        userNombre.setForeground(new java.awt.Color(255, 255, 255));
        userNombre.setText("User1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 667, Short.MAX_VALUE)
                .addComponent(userNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(icono)
                .addGap(87, 87, 87))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icono))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUrlActionPerformed

    private void GenerarBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarBut1ActionPerformed
        // TODO add your handling code here:
        GenerarQR generar = new GenerarQR();

        try {
            String data = GenerarQR.generarQR("https://www.facebook.com/", "1");
            System.out.println(data);
            decoder(data.split("data:image/png;base64,")[1], System.getProperty("user.dir") + "\\imagesQR\\image_qr.png");
        } catch (IOException ex) {
            Logger.getLogger(GeneradorQr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(GeneradorQr.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_GenerarBut1ActionPerformed

    private void ExportarBut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportarBut2ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_ExportarBut2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GeneradorQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneradorQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneradorQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneradorQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneradorQr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ExportarBut2;
    public javax.swing.JButton GenerarBut1;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelQr;
    private co.edu.ufps.javadek.view.PanelRound panelRound2;
    private javax.swing.JLabel sitiWeb1;
    private javax.swing.JLabel sitiWeb2;
    private javax.swing.JTextField textUrl;
    private javax.swing.JLabel userNombre;
    // End of variables declaration//GEN-END:variables
}
