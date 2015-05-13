/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan
 */
public class usuario extends javax.swing.JInternalFrame {

    DefaultTableModel tab = new DefaultTableModel();

    public usuario() throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocation(260, 20);
        this.insert();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clickderecho = new javax.swing.JPopupMenu();
        modificar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        descp = new javax.swing.JMenuItem();
        conteiner = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        inicio = new javax.swing.JMenu();
        log_out = new javax.swing.JMenuItem();
        accion = new javax.swing.JMenu();
        agregar = new javax.swing.JMenuItem();

        modificar.setText("Detalles");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        clickderecho.add(modificar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        clickderecho.add(Eliminar);

        descp.setText("Descripcion");
        descp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descpActionPerformed(evt);
            }
        });
        clickderecho.add(descp);

        setIconifiable(true);
        setMaximizable(true);

        javax.swing.GroupLayout conteinerLayout = new javax.swing.GroupLayout(conteiner);
        conteiner.setLayout(conteinerLayout);
        conteinerLayout.setHorizontalGroup(
            conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        conteinerLayout.setVerticalGroup(
            conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        inicio.setText("Inicio");

        log_out.setText("Cerra Sesion");
        log_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_outActionPerformed(evt);
            }
        });
        inicio.add(log_out);

        jMenuBar1.add(inicio);

        accion.setText("Incidencia");

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        accion.add(agregar);

        jMenuBar1.add(accion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(conteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void log_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_outActionPerformed
        Principal.iniciar_sesion.setEnabled(true);
        Principal.registrarse.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_log_outActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        nueva_incidencia us = null;
        try {
            us = new nueva_incidencia();
            this.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Principal.desk.add(us);
        us.setVisible(true);
    }//GEN-LAST:event_agregarActionPerformed

    private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
        if (evt.isPopupTrigger()) {
            clickderecho.show(this, evt.getX(), evt.getY());
        }


    }//GEN-LAST:event_tablaMouseReleased

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        String id = Integer.toString(nueva_incidencia.idincidencia());
        Detalles det = null;
        try {
            det = new Detalles();
        } catch (SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Principal.desk.add(det);
        Detalles.Idincidencia.setText(tab.getValueAt(tabla.getSelectedRow(), 0).toString());
        Detalles.fechaA.setText(tab.getValueAt(tabla.getSelectedRow(), 2).toString());
        Detalles.fechaUM.setText(tab.getValueAt(tabla.getSelectedRow(), 3).toString());
        det.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_modificarActionPerformed
       public void vaciar(){
       for (int i = 0; i < tabla.getRowCount(); i++) {
           tab.removeRow(i);
           i-=1;
       }
       }
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        conexion con = new conexion();   
        try {
            
            Connection cn = con.conectar();
            String s = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            int id = Integer.parseInt(s);
            try {
                PreparedStatement ps = cn.prepareStatement("DELETE FROM incidencia WHERE idIncidencia = " + id + "");
                PreparedStatement ps2 = cn.prepareStatement("DELETE FROM detalleincidencia WHERE idIncidencia = " + id + "");
                ps.executeUpdate();
                ps2.executeUpdate();
                vaciar();
                insert();
                JOptionPane.showMessageDialog(null, "Se elimino la incidencia");
            } catch ( SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: no has seleccionado ninguna fila");
            }
        } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo elimar " + ex);
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

    }//GEN-LAST:event_tablaMouseClicked

    private void descpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descpActionPerformed
             String id = Integer.toString(nueva_incidencia.idincidencia());
        Detalles det = null;
        
        try {
            det = new Detalles();
        } catch (SQLException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Principal.desk.add(det);
        Detalles.estad.addElement(tab.getValueAt(tabla.getSelectedRow(), 6).toString());
        Detalles.Idincidencia.setText(tab.getValueAt(tabla.getSelectedRow(), 0).toString());
        Detalles.fechaA.setText(tab.getValueAt(tabla.getSelectedRow(), 2).toString());
        Detalles.fechaUM.setText(tab.getValueAt(tabla.getSelectedRow(), 3).toString());
        Detalles.NuevoE.setModel( Detalles.asig);
        Detalles.NuevoE.setModel( Detalles.estad);
      
        Detalles.NuevoE.setEnabled(false);
        det.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_descpActionPerformed
    public ResultSet consulta() throws SQLException, ClassNotFoundException {
        conexion con = new conexion();
        Connection cn = con.conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select * From incidencia where asignada = " + Login.idtecnico + " and estado <> 'Cerrada'");
//                JOptionPane.showMessageDialog(null,Login.idtecnico);
        } catch (SQLException ex) {
            System.out.println("Falla al consultar " + ex);
        }
        return rs;
    }

    public void insert() throws SQLException, ClassNotFoundException {
        this.tabla.setModel(tab);
        ResultSet rs = this.consulta();
        tab.setColumnIdentifiers(new Object[]{"idIncidencia", "titulo", "fechaApertura", "fechaUltimaMod", "asignada", "creador", "estado", "categoria"});
        while (rs.next()) {
            tab.addRow(new Object[]{rs.getInt("idIncidencia"), rs.getString("titulo"), rs.getDate("fechaApertura"), rs.getDate("fechaUltimaMod"), rs.getInt("asignada"), rs.getString("creador"), rs.getString("estado"), rs.getInt("categoria")});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JMenu accion;
    private javax.swing.JMenuItem agregar;
    private javax.swing.JPopupMenu clickderecho;
    private javax.swing.JPanel conteiner;
    private javax.swing.JMenuItem descp;
    private javax.swing.JMenu inicio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem log_out;
    private javax.swing.JMenuItem modificar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
