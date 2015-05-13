/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectofinal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramón
 */
public class ayuda extends javax.swing.JInternalFrame {
  DefaultTableModel cat = new DefaultTableModel();
  DefaultTableModel tec = new DefaultTableModel();
    public ayuda() throws SQLException, ClassNotFoundException {
        initComponents();
        this.insert();
        this.insert1();
    }

       public ResultSet consulta() throws SQLException, ClassNotFoundException {
        conexion con = new conexion();
        Connection cn = con.conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select * From categoria ");
//                JOptionPane.showMessageDialog(null,Login.idtecnico);
        } catch (SQLException ex) {
            System.out.println("Falla al consultar categoria" + ex);
        }
        return rs;
    }

    public void insert() throws SQLException, ClassNotFoundException {
        this.categoria.setModel(cat);
        ResultSet rs = this.consulta();
        cat.setColumnIdentifiers(new Object[]{"idCategoria", "nombreCategoria", "responsable"});
        while (rs.next()) {
            cat.addRow(new Object[]{rs.getInt("idCategoria"), rs.getString("nombreCategoria"), rs.getInt("responsable")});
        }
    }
           public ResultSet consulta1() throws SQLException, ClassNotFoundException {
        conexion con = new conexion();
        Connection cn = con.conectar();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("Select idTecnico,nombreTecnico,telefonoTecnico From tecnico ");
//                JOptionPane.showMessageDialog(null,Login.idtecnico);
        } catch (SQLException ex) {
            System.out.println("Falla al consultar tecnico" + ex);
        }
        return rs;
    }

    public void insert1() throws SQLException, ClassNotFoundException {
        this.tecnico.setModel(tec);
        try{
                   ResultSet rs = this.consulta1();
        tec.setColumnIdentifiers(new Object[]{"idTecnico", "nombreTecnico", "telefonoTecnico"});
        while (rs.next()) {
            tec.addRow(new Object[]{rs.getInt("idTecnico"), rs.getString("nombreTecnico"), rs.getString("telefonoTecnico")});
        } 
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Error en la tabla tecnico " + ex);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tecnico = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoria = new javax.swing.JTable();

        setClosable(true);

        tecnico.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tecnico);

        categoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(categoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable categoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tecnico;
    // End of variables declaration//GEN-END:variables
}
