
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultaInsumo;
import modelo.Insumo;
import modelo.Mesero;
import vista.JFinsumos;

/**
 *
 * @author Ivan
 */
public class CtrlInsumo implements ActionListener, KeyListener{
    
        Insumo ins = new Insumo();
        ConsultaInsumo csins = new ConsultaInsumo();
        JFinsumos frmins = new JFinsumos();
    public CtrlInsumo (Insumo ins, ConsultaInsumo csins, JFinsumos frmins){
        
        this.ins=ins;
        this.csins=csins;
        this.frmins=frmins;
        this.frmins.btnIngresar.addActionListener(this);
        this.frmins.txtprecio.addKeyListener(this);
        this.frmins.txtnombre.addKeyListener(this);
        this.frmins.txtunidad.addKeyListener(this);
        this.frmins.txtcantidad.addKeyListener(this);
    }
    public void iniciar(){
        
        frmins.setTitle("Registro de insumos");
        frmins.setLocationRelativeTo(null);
        LLenarTabla(frmins.jtcompra);
        
         
    }
    
    public void limpiarCampos(){
        frmins.txtnombre.setText("");
        frmins.txtcantidad.setText("");
        frmins.txtdescripcion.setText("");
        frmins.txtunidad.setText("");
        frmins.txtprecio.setText("");
        frmins.fecha.setDate(null);
    }
    
     public void LLenarTabla(JTable tablaD){
        DefaultTableModel modeloT= new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Descripcion");
        modeloT.addColumn("Cantidad");
        modeloT.addColumn("Unidad");
        modeloT.addColumn("Precio");
        modeloT.addColumn("FechaCompra");
      Object[] columna = new Object[6];

        int numInsumos = csins.listInsumo().size();

        for (int i = 0; i < numInsumos; i++) {
            columna[0] = csins.listInsumo().get(i).getNombre();
            columna[1] = csins.listInsumo().get(i).getDescripcion();
            columna[2] = csins.listInsumo().get(i).getCantidad();
            columna[3] = csins.listInsumo().get(i).getUnidad();
            columna[4] = csins.listInsumo().get(i).getPrecio();
            columna[5] = csins.listInsumo().get(i).getFechaC();
             modeloT.addRow(columna);
        }     
           
   }
     @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==frmins.btnIngresar){
            if(frmins.txtnombre.getText().trim().equals("")|| frmins.txtdescripcion.getText().trim().equals("")|| frmins.txtprecio.getText().trim().equals("")||frmins.txtunidad.getText().trim().equals("") || frmins.txtcantidad.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.");
            
            }else{
                    
                    ins.setNombre(frmins.txtnombre.getText());
                    ins.setDescripcion(frmins.txtdescripcion.getText());
                    ins.setPrecio(Double.parseDouble(frmins.txtprecio.getText()));
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    ins.setUnidad(frmins.txtunidad.getText());
                    ins.setFechaC(formatoFecha.format(frmins.fecha.getDate()));
                    ins.setCantidad(Double.parseDouble(frmins.txtcantidad.getText()));
                    limpiarCampos();
            
            if (csins.registrar(ins)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    LLenarTabla(frmins.jtcompra);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo");
            }
            }
         }
    
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == frmins.txtprecio || e.getSource() == frmins.txtcantidad){
            char c = e.getKeyChar();
            if(c<'0' || c>'9'){
                e.consume();
            }
        }
         if(e.getSource() == frmins.txtunidad || e.getSource() == frmins.txtnombre ){
            char c = e.getKeyChar();
            if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c!=(char)KeyEvent.VK_SPACE)){
                e.consume();
            }
        }
        
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    
}
