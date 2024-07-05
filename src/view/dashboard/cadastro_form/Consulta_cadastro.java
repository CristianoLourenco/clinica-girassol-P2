package view.dashboard.cadastro_form;

import dao.EspecialidadeDAO;
import dao.MedicoDAO;
import dao.PacienteDAO;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import models.Consulta;
import models.Especialidade;
import models.Medico;
import models.Paciente;

public class Consulta_cadastro extends javax.swing.JFrame {

    private static final List<Paciente> listPaciente = new ArrayList<>();
    private static final List<Especialidade> listEspecialidade = new ArrayList<>();
    private static final List<Medico> listMedico = new ArrayList<>();
    private Consulta consulta = new Consulta();
    private Paciente paciente;
    private Medico medico;

    public Consulta_cadastro() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        loadEspecialidades();
        loadPacientes();
        loadMedicos();
    }

    private void loadEspecialidades() {
        cmbbxEspecialidade.removeAllItems();
        EspecialidadeDAO dao = new EspecialidadeDAO(null);
        var list = dao.listDaoObject();
        for (int i = 0; i < list.size(); i++) {
            listEspecialidade.add(list.get(i));
            cmbbxEspecialidade.addItem(list.get(i).getNomeEspecialidade());
        }
    }

    private void loadPacientes() {
        cmbbxPacientes.removeAllItems();
        PacienteDAO dao = new PacienteDAO(null);
        var list = dao.listDaoObject();
        for (int i = 0; i < list.size(); i++) {
            listPaciente.add(list.get(i));
            cmbbxPacientes.addItem(list.get(i).getNome());
        }
    }

    private void loadMedicos() {
        cmbbxMedico.addItem("");
        MedicoDAO dao = new MedicoDAO(null);
        var list = dao.listDaoObject();
        for (int i = 0; i < list.size(); i++) {
            listMedico.add(list.get(i));
        }
    }

    private Medico selectMedico() {
        for (Medico m : listMedico) {
            if (cmbbxMedico.getSelectedItem().toString()!=null &&  m.getNome_funcionario().matches(cmbbxMedico.getSelectedItem().toString())) {
                consulta.setMedico_id(m.getNome_funcionario());
                return m;
            }
        }
        return new Medico();
    }

    private Paciente selectPacient() {
        for (Paciente p : listPaciente) {
            if (p.getNome() == cmbbxPacientes.getSelectedItem().toString()) {
                consulta.setPaciente_id(p.getNome());
                return p;
            }
        }
        return new Paciente();
    }

    private Especialidade selectEspacialidade() {
        for (Especialidade esp : listEspecialidade) {
            if (esp.getNomeEspecialidade() == cmbbxEspecialidade.getSelectedItem().toString()) {
                return esp;
            }
        }
        return new Especialidade();
    }

    private void setconsulta() {
        if (dateTimePicker.datePicker.getDate() != null) {
            consulta.setDataConsulta(LocalDateTime.of(dateTimePicker.getDateTimePermissive().toLocalDate(), dateTimePicker.getDateTimePermissive().toLocalTime()));
        }
        dados_consulta.setConsultaData(consulta);
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cDadosPanel1 = new view.panels.Dados_paciente_panel();
        panelBorder1 = new view.dashboard.components.PanelBorder();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBtnAgendar_consulta = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbbxPacientes = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cmbbxMedico = new javax.swing.JComboBox<>();
        dados_paciente = new view.panels.Dados_paciente_panel();
        dados_medico = new view.panels.Dados_medico();
        dados_consulta = new view.panels.Dados_consulta();
        jLabel8 = new javax.swing.JLabel();
        cmbbxEspecialidade = new javax.swing.JComboBox<>();
        dateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();

        javax.swing.GroupLayout cDadosPanel1Layout = new javax.swing.GroupLayout(cDadosPanel1);
        cDadosPanel1.setLayout(cDadosPanel1Layout);
        cDadosPanel1Layout.setHorizontalGroup(
            cDadosPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        cDadosPanel1Layout.setVerticalGroup(
            cDadosPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setText("Paciente:");
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setText("Data da Consulta:");
        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setText("STATUS");
        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 255, 51));

        jBtnAgendar_consulta.setText("Agendar");
        jBtnAgendar_consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgendar_consultaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        jLabel9.setText("Disponibilidade do Médico:");
        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setText("Agendar consulta");
        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));

        cmbbxPacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cmbbxPacientes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbxPacientesItemStateChanged(evt);
            }
        });

        jLabel14.setText("Médico:");
        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));

        cmbbxMedico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbxMedicoItemStateChanged(evt);
            }
        });
        cmbbxMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbxMedicoActionPerformed(evt);
            }
        });

        jLabel8.setText("Especialidade:");
        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));

        cmbbxEspecialidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbbxEspecialidadeItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jBtnAgendar_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(542, 542, 542)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbbxPacientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dateTimePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(12, 12, 12)
                                .addComponent(cmbbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dados_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dados_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dados_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbbxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbbxPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbbxEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dados_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dados_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dados_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jBtnAgendar_consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbbxPacientesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbxPacientesItemStateChanged
        dados_paciente.setPacientData(selectPacient());
        setconsulta();
    }//GEN-LAST:event_cmbbxPacientesItemStateChanged

    private void cmbbxMedicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbxMedicoItemStateChanged
      
    }//GEN-LAST:event_cmbbxMedicoItemStateChanged

    private void jBtnAgendar_consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgendar_consultaActionPerformed
        if (consulta.isValid()) {
            consulta.setPaciente_id(String.valueOf(selectPacient().getPaciente_id()));
            consulta.setMedico_id(String.valueOf(selectMedico().getId_funcionario()));
            consulta.setEspecialidade_id(String.valueOf(selectEspacialidade().getEspecialidade_id()));
            consulta.agendarConsulta();
        }

    }//GEN-LAST:event_jBtnAgendar_consultaActionPerformed

    private void cmbbxEspecialidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbbxEspecialidadeItemStateChanged

        cmbbxMedico.removeAllItems();
        
        for (int i = 0; i < listMedico.size(); i++) {
            if (listMedico.get(i).getEspecialidade_id().matches(cmbbxEspecialidade.getSelectedItem().toString())) {
                cmbbxMedico.addItem(listMedico.get(i).getNome_funcionario());
            }
        }
        consulta.setEspecialidade_id(cmbbxEspecialidade.getSelectedItem().toString());
    }//GEN-LAST:event_cmbbxEspecialidadeItemStateChanged

    private void cmbbxMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbxMedicoActionPerformed
        if (cmbbxMedico.getItemCount() <= 0) {
            dados_medico.setMedicoData(new Medico());
            return;
        }
        dados_medico.setMedicoData(selectMedico());
        setconsulta();
    }//GEN-LAST:event_cmbbxMedicoActionPerformed

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
            java.util.logging.Logger.getLogger(Consulta_cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Consulta_cadastro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.panels.Dados_paciente_panel cDadosPanel1;
    private javax.swing.JComboBox<String> cmbbxEspecialidade;
    private javax.swing.JComboBox<String> cmbbxMedico;
    private javax.swing.JComboBox<String> cmbbxPacientes;
    private view.panels.Dados_consulta dados_consulta;
    private view.panels.Dados_medico dados_medico;
    private view.panels.Dados_paciente_panel dados_paciente;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker;
    private javax.swing.JButton jBtnAgendar_consulta;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private view.dashboard.components.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
