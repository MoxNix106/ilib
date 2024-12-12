package com.mycompany.views;

import com.mycompany.ilib.DAOPersonalImpl;
import com.mycompany.interfaces.DAOPersonal;
import com.mycompany.db.Database;
import com.mycompany.models.Personal;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class PersonalF extends javax.swing.JPanel {

    private Connection conn;

    public PersonalF(Connection conn) {
        this.conn = conn;
        initComponents();
        initStyles();
        loadPersonal();
    }

    private void initStyles() {
        titulo.putClientProperty("FlatLaf.styleClass", "h1");
        titulo.setForeground(java.awt.Color.black);
        buscarPersonalTxt.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del personal a buscar.");
    }

    private void loadPersonal() {
        try {
            DAOPersonal dao = new DAOPersonalImpl(conn);
            DefaultTableModel model = (DefaultTableModel) tablaPersonal.getModel();
            model.setRowCount(0); // Limpiar tabla
            dao.listar("").forEach((p) -> model.addRow(new Object[]{
                p.getId(),
                p.getUsuario(),
                p.getNombre(),
                p.getApellido(),
                p.getCorreo()
            }));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los registros: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        buscarPersonalTxt = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonal = new javax.swing.JTable();
        botonBorrar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        titulo.setText("Personal");

        buscarPersonalTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPersonalTxtActionPerformed(evt);
            }
        });

        botonBuscar.setBackground(new java.awt.Color(18, 90, 173));
        botonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("Buscar");
        botonBuscar.setBorderPainted(false);
        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaPersonal.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tablaPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Nombre", "Apellido", "Correo", "Contraseña", "F.Creacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPersonal.getTableHeader().setReorderingAllowed(false);
        tablaPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaPersonalMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPersonal);

        botonBorrar.setBackground(new java.awt.Color(18, 90, 173));
        botonBorrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonBorrar.setForeground(new java.awt.Color(255, 255, 255));
        botonBorrar.setText("Borrar");
        botonBorrar.setBorderPainted(false);
        botonBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonEditar.setBackground(new java.awt.Color(18, 90, 173));
        botonEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonEditar.setForeground(new java.awt.Color(255, 255, 255));
        botonEditar.setText("Editar");
        botonEditar.setBorderPainted(false);
        botonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonAgregar.setBackground(new java.awt.Color(18, 90, 173));
        botonAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregar.setText("Nuevo");
        botonAgregar.setBorderPainted(false);
        botonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(427, 427, 427)
                                .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(buscarPersonalTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBuscar)))
                        .addGap(50, 50, 50))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscarPersonalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBorrar)
                    .addComponent(botonEditar)
                    .addComponent(botonAgregar))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPersonalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonalMousePressed

    }//GEN-LAST:event_tablaPersonalMousePressed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        JOptionPane.showMessageDialog(this, "Abrir pantalla para agregar personal.");

    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
 try {
            DAOPersonal dao = new DAOPersonalImpl(conn);
            DefaultTableModel model = (DefaultTableModel) tablaPersonal.getModel();
            model.setRowCount(0);
            dao.listar(buscarPersonalTxt.getText().trim()).forEach((p) -> model.addRow(new Object[]{
                p.getId(),
                p.getUsuario(),
                p.getNombre(),
                p.getApellido(),
                p.getCorreo()
            }));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar registros: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
      
    if (tablaPersonal.getSelectedRow() > -1) {
            try {
                int id = (int) tablaPersonal.getValueAt(tablaPersonal.getSelectedRow(), 0);
                DAOPersonal dao = new DAOPersonalImpl(conn);
                Personal personal = dao.obtenerPorId(id);
                JOptionPane.showMessageDialog(this, "Abrir pantalla para editar personal con ID: " + id);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar el registro para editar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
         
    if (tablaPersonal.getSelectedRow() > -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el registro seleccionado?");
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int id = (int) tablaPersonal.getValueAt(tablaPersonal.getSelectedRow(), 0);
                    DAOPersonal dao = new DAOPersonalImpl(conn);
                    dao.eliminar(id);
                    ((DefaultTableModel) tablaPersonal.getModel()).removeRow(tablaPersonal.getSelectedRow());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el registro: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_botonBuscarActionPerformed

    private void buscarPersonalTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPersonalTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarPersonalTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JTextField buscarPersonalTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPersonal;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}