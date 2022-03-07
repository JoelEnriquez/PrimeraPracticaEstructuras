/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practicaestructura.fronted;

import com.mycompany.practicaestructura.objets.Report;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author joel
 */
public class ReportsForm extends javax.swing.JFrame {

    private Report verificacionDupli;
    private String erroresApuestas;
    private MainForm main;

    /**
     * Creates new form ReportsForm
     */
    public ReportsForm(MainForm main) {
        initComponents();
        this.main = main;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        downloadErrorsButton = new javax.swing.JButton();
        goToHomeButton = new javax.swing.JButton();
        verificacionApuestasButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        downloadErrorsButton.setText("Descargar Errores");
        downloadErrorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadErrorsButtonActionPerformed(evt);
            }
        });

        goToHomeButton.setText("Volver al inicio");
        goToHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToHomeButtonActionPerformed(evt);
            }
        });

        verificacionApuestasButton.setText("Report Verificacion Apuestas");
        verificacionApuestasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificacionApuestasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(downloadErrorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
            .addGroup(layout.createSequentialGroup()
                .addComponent(goToHomeButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(verificacionApuestasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(downloadErrorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(verificacionApuestasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(goToHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goToHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToHomeButtonActionPerformed
        this.setVisible(false);
        main.restart();
        main.setVisible(true);
    }//GEN-LAST:event_goToHomeButtonActionPerformed

    private void downloadErrorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadErrorsButtonActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            int seleccion = fileChooser.showSaveDialog(this);

            if (seleccion == APPROVE_OPTION) {
                try {
                    try ( FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile().getPath())) {
                        fileWriter.write(erroresApuestas);
                    }
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Info", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_downloadErrorsButtonActionPerformed

    private void verificacionApuestasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificacionApuestasButtonActionPerformed
        JOptionPane.showMessageDialog(null, "Tiempo promedio: " + verificacionDupli.getTiempoPromedio() + "s\n" + "Promedio pasos: " + verificacionDupli.getPromedioPasos() + "\n" + "Menor tiempo pasos: " + verificacionDupli.getMenorCantidadPasos() + "\n" + "Mayor cantidad pasos: " + verificacionDupli.getMayorCantidadPasos());
    }//GEN-LAST:event_verificacionApuestasButtonActionPerformed

    public void setVerificacionDupli(Report verificacionDupli) {
        this.verificacionDupli = verificacionDupli;
    }

    public void setErroresApuestas(String erroresApuestas) {
        this.erroresApuestas = erroresApuestas;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton downloadErrorsButton;
    private javax.swing.JButton goToHomeButton;
    private javax.swing.JButton verificacionApuestasButton;
    // End of variables declaration//GEN-END:variables
}
