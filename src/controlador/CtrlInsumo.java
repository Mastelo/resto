
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CtrlInsumo implements ActionListener{
    
        Insumo ins = new Insumo();
        ConsultaInsumo csins = new ConsultaInsumo();
        JFinsumos frmins = new JFinsumos();
    public CtrlInsumo (Insumo ins, ConsultaInsumo csins, JFinsumos frmins){
        
        this.ins=ins;
        this.csins=csins;
        this.frmins=frmins;
        this.frmins.btnIngresar.addActionListener(this);
        
    }
    public void iniciar(){
        
        frmins.setTitle("Insumos");
        frmins.setLocationRelativeTo(null);
        LLenarTabla(frmins.jtcompra);
        
         
    }
     public void LLenarTabla(JTable tablaD){
        DefaultTableModel modeloT= new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("nombre");
        modeloT.addColumn("descripcion");
        modeloT.addColumn("precio");
        modeloT.addColumn("fecha");
      Object[] columna = new Object[4];

        int numInsumos = csins.listInsumo().size();

        for (int i = 0; i < numInsumos; i++) {
            columna[0] = csins.listInsumo().get(i).getNombre();
            columna[1] = csins.listInsumo().get(i).getDescripcion();
            columna[2] = csins.listInsumo().get(i).getPrecio();
            columna[3] = csins.listInsumo().get(i).getFechaC();
             modeloT.addRow(columna);
        }     
           
   }

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==frmins.btnIngresar){
            ins.setNombre(frmins.txtnombre.getText());
            ins.setDescripcion(frmins.txtdescripcion.getText());
            ins.setPrecio(Double.parseDouble(frmins.txtprecio.getText()));
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            ins.setFechaC(formatoFecha.format(frmins.fecha.getDate()));
            
            
           
         }
    
        if (csins.registrar(ins)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    LLenarTabla(frmins.jtcompra);
                } else {
                    JOptionPane.showMessageDialog(null, "Registro erroneo");
                }
    }
       
    
}
