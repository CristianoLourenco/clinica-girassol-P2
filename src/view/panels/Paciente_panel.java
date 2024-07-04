/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.panels;

import dao.PacienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Paciente;

public class Paciente_panel extends javax.swing.JPanel {

    public Paciente_panel() {
        initComponents();
        initializePatients();
    }

    private void initializePatients() {
        DefaultTableModel defultTableModel = (DefaultTableModel) jTablePaciente.getModel();
        PacienteDAO dao = new PacienteDAO(null);

        List<Paciente> lista = (ArrayList<Paciente>) dao.listDaoObject();
        for (int i = 0; i < lista.size(); i++) {
            defultTableModel.addRow(lista.get(i).toList());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Pacientes");

        jTablePaciente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Nº Bilhete", "Telefone ", "Nascido aos", "Genero", "Morada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePaciente.setShowGrid(false);
        jTablePaciente.getTableHeader().setResizingAllowed(false);
        jTablePaciente.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTablePaciente);

        jButton1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jButton1.setText("Adicionar paciente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablePaciente;
    // End of variables declaration//GEN-END:variables
}
