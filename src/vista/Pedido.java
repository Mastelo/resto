
package vista;

import modelo.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Pedido extends javax.swing.JFrame {
    Conexion conexion;
    /**
     * Creates new form JFCrud
     */
    
    public Pedido() {
        initComponents();
        conexion = new Conexion();
        
         try {
            Connection acceDB = conexion.getConexion(); 
            PreparedStatement ps = acceDB.prepareStatement("select ci from mesero");
            PreparedStatement ps2 = acceDB.prepareStatement("select nromesa from mesa");
            
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            
            cboxMesero.addItem("Selecione mesero");
            cboxMesa.addItem("Selecione mesa");
            while(rs.next()){
                cboxMesero.addItem(rs.getString("ci"));
            }
            while(rs2.next()){
                cboxMesa.addItem(rs2.getString("nromesa"));
            }
            

        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        btnNuevoPedido = new javax.swing.JButton();
        btnAgregarOrden = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        cboxMesero = new javax.swing.JComboBox<>();
        cboxMesa = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txtPlato = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro pedido");

        btnNuevoPedido.setText("Nuevo Pedido");
        btnNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPedidoActionPerformed(evt);
            }
        });

        btnAgregarOrden.setText("Agregar orden a pedido");
        btnAgregarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarOrdenActionPerformed(evt);
            }
        });

        txtBusqueda.setForeground(new java.awt.Color(0, 0, 204));
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "PLATO", "CANTIDAD", "IMPORTE"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setText("CANTIDAD");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        txtPrecio.setEditable(false);

        jLabel6.setText("PRECIO");

        jLabel7.setText("TOTAL");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        cboxMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMesaActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "PRECIO", "DESCRIPCION"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        txtPlato.setVisible(false);
        txtPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlatoActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboxMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnAgregarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnNuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtCantidad))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboxMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cboxMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtPlato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(btnAgregarOrden))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    void actualizarPedido(int pedido){
       
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("ID ");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("IMPORTE");
        

        //jTable1.setModel(modelo);

        String []datos = new String [4];
            try {
                Connection acceDB = conexion.getConexion();
                //aumentar nombre del plato
                PreparedStatement ps1 = acceDB.prepareStatement( "SELECT c.idcomida, nombre,cantidad, subtotal FROM producto_pedido pp, comida c where pp.idcomida=c.idcomida and idpedido="+pedido);
                ResultSet rs = ps1.executeQuery();

                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    modelo.addRow(datos);
                }
                jTable1.setModel(modelo);
            } catch (SQLException ex) {

            }
    }
    
    
    void actualizarTotal(int pedido){
            try {
                Connection acceDB = conexion.getConexion();
                //aumentar nombre del plato
                PreparedStatement ps1 = acceDB.prepareStatement( "SELECT sum(subtotal)as total FROM producto_pedido where idpedido="+pedido);
                ResultSet rs = ps1.executeQuery();

                if(rs.next()){
                    double total = rs.getDouble("total");
                    String tot = String.valueOf(total);
                    txtTotal.setText(tot);
                    //System.out.println(tot);
                    try{
                        String sql1 = "update pedido set total=? where idpedido=?;";
                        Connection accesoD = conexion.getConexion();
                        CallableStatement pss = accesoD.prepareCall(sql1);
                        pss.setDouble(1,total);
                        pss.setInt(2, pedido);
                        pss.executeUpdate();
                    }
                    catch(Exception eTotal){
                        System.err.println(eTotal);
                    }
                }            
                
            } catch (SQLException ex) {

            }
    }
    
    
    void buscarPrecioNombre(String preciNombre){
       
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("DESCRIPCION");

        String []datos = new String [4];
            try {
                Connection acceDB = conexion.getConexion();
                //aumentar nombre del plato
                PreparedStatement ps1 = acceDB.prepareStatement( "select * from comida where nombre like '%"+ preciNombre +"%' or precio like '%"+ preciNombre +"%';");
                ResultSet rs = ps1.executeQuery();

                
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    modelo.addRow(datos);
                }
               
                jTable2.setModel(modelo);
                
            } catch (SQLException ex) {

            }
    }
    
    public void limpiar(){
        txtPrecio.setText("");
        txtCantidad.setText("");
    }
    
    public void registrarPedido( int plato, int cantidad, double subtotal){
        Connection accesoDB = conexion.getConexion();
        PreparedStatement ps1;
        String rptaRegistro="";
        try {
            ps1 = accesoDB.prepareStatement("select max(idpedido)as id from pedido  ");
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()){
                int pedido = rs1.getInt("id");
                //System.out.println(pedido);
            
                //insertar a la tabla producto_pedido
                String sql2 = "INSERT INTO producto_pedido (idpedido,idcomida, cantidad, subtotal ) VALUES (?,?,?,?)";
                CallableStatement ps;
                ps = accesoDB.prepareCall(sql2);
                ps.setInt(1, pedido);
                ps.setInt(2, plato);
                ps.setInt(3, cantidad);
                ps.setDouble(4, subtotal);
            
                //System.out.println(plato +" platon "+cantidad +" can "+ subtotal+" sub ");
                int numFAfectas = ps.executeUpdate();

                if(numFAfectas>0){
                    rptaRegistro="Registro plato exitoso.";
                    actualizarPedido(pedido);
                    actualizarTotal(pedido);
                }
                
            }
        } catch (SQLException e2) {
            System.err.println(e2+"e2 ");
        }
        limpiar();
    }
    
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListarActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPedidoActionPerformed
       //registar nuevo pedido en tabla pedido
      
       jTable1.setModel(new DefaultTableModel());
       
       String mesa = (String) cboxMesa.getSelectedItem();
       String  mesero = (String) cboxMesero.getSelectedItem();
       String rptaRegistro ="";
       
      
       //System.out.println(" "+ mesero);
       try {
            Connection accesoDB = conexion.getConexion();
            String sql = "INSERT INTO pedido ( ci, idmesa,fechapedido) VALUES (?,?,?);";
            CallableStatement ps = accesoDB.prepareCall(sql);
            java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
            
            ps.setString(1, mesero);
            ps.setString(2, mesa);
            ps.setDate(3, sqlDate);
            //System.out.println(" "+ mesero);
            //actualizar mesa
           int numFAfectas = ps.executeUpdate();
            
            if(numFAfectas>0){
                rptaRegistro="Registro exitoso.";
              try{
                Connection accesoD = conexion.getConexion();
                String sql1 = "update mesa set disponibilidad=? where nromesa=?;";

                CallableStatement pss = accesoD.prepareCall(sql1);
                pss.setInt(1,1);
                pss.setString(2, mesa);
                pss.executeUpdate();
                //System.out.println("exito" );
              }catch (Exception e){
                  System.err.println(e);
              }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        txtTotal.setText("");
    }//GEN-LAST:event_btnNuevoPedidoActionPerformed

    private void btnAgregarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarOrdenActionPerformed
        // registrar platon al pedido
        /* obtener el ultimo pedido
        recuperar id de plato(precio?), nombre 
        pedir cantidad 
        manda a insertar idpedido, idplato, cantidad y calcular subtotal
        mostrar en tabla
        */
       
        //String plato = (String) cboxProducto.getSelectedItem();
        
        int plato = (int) Double.parseDouble(txtPlato.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        int cantidad = (int) Double.parseDouble(txtCantidad.getText());
       // double cantidad = Double.parseDouble(txtCantidad.getText());
        double subtotal = precio * cantidad;
        //System.out.println(precio +" p "+cantidad +" can "+ subtotal+" sub ");

        registrarPedido(plato, cantidad, subtotal);
        
        
    }//GEN-LAST:event_btnAgregarOrdenActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cboxMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxMesaActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // iniciar busqueda
        
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        // busqueda automatica
        if( txtBusqueda.getText() != null){
            String precNombr = txtBusqueda.getText();
            buscarPrecioNombre(precNombr);
        }
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int clic = jTable2.rowAtPoint(evt.getPoint());
        
         int codigo=   Integer.parseInt((String) jTable2.getValueAt(clic, 0));
        //int codigo = (int)jTable2.getValueAt(clic, 0);
        //String nombre = " "+jTable2.getValueAt(clic, 1);
        double precio = Double.parseDouble((String) jTable2.getValueAt(clic, 2));
        
        txtPlato.setText(String.valueOf(codigo));
        txtPrecio.setText(String.valueOf(precio));
        //registrarPedido(codigo,,precio);
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlatoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtPlatoActionPerformed

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
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarOrden;
    public javax.swing.JButton btnNuevoPedido;
    private javax.swing.JComboBox<String> cboxMesa;
    public javax.swing.JComboBox<String> cboxMesero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTextField txtBusqueda;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtPlato;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
