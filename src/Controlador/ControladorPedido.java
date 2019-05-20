
package Controlador;


import Modelo.ListaProductos;
import Modelo.ListaPedidos;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.*;

/* boton de nuevo pedido y haga consulta que inserte usuario

*/
public class ControladorPedido implements ActionListener, KeyListener, MouseListener {
    
    
    VistaPedido vistaCRUD = new VistaPedido();
    ListaProductos modeloCRUD = new ListaProductos();
    ListaPedidos modeloPP = new ListaPedidos();
    
    public ControladorPedido(VistaPedido vistaCRUD, ListaProductos modeloCRUD, ListaPedidos modeloPP){
    //public ControladorPedido(VistaPedido vistaCRUD, ListaProductos modeloCRUD){
        this.modeloPP = modeloPP;
        this.modeloCRUD = modeloCRUD;
       
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnListar.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnNuevoPedido.addActionListener(this);
        this.vistaCRUD.btnGEdit.addActionListener(this);
        this.vistaCRUD.txtBusqueda.addKeyListener(this);
        this.vistaCRUD.txtIdProducto.addKeyListener(this);
        this.vistaCRUD.txtNombre.addKeyListener(this);
        this.vistaCRUD.txtIdPedido.addKeyListener(this);
        
        this.vistaCRUD.txtCantidad.addKeyListener(this);
        this.vistaCRUD.txtIdMesero.addKeyListener(this);
        //vistaCRUD.txtMesero.setEditable(false);
        //vistaCRUD.txtPedido.setEditable(false);
      //  this.
      //  resume.addMouseListener(new MyMouseListener());
        
    }
    
    /*public void iniciar() {
        vistaCRUD.setTitle("Coma Comida");
        vistaCRUD.setLocationRelativeTo(null);
    }*/
    
   
    
    
    public void LlenarTablaPP(JTable tablaT){
        DefaultTableModel  modeloX = new DefaultTableModel();
        tablaT.setModel(modeloX);
        
        modeloX.addColumn("ID");
        modeloX.addColumn("ID");
        modeloX.addColumn("CANTIDAD");
        modeloX.addColumn("SUBTOTAL");

        Object[] columna = new Object[1];

        int numRegistros = modeloPP.listaPedidos().size();

        for (int i = 0; i < numRegistros; i++) {
            //reconoce listaProductos tal vez algo mal en listaPedidos
           // columna[0] = modeloPP.listaPedidos().get(i).getIdPedido();
            columna[0] = modeloCRUD.listaProductos().get(i).getId();
           // columna[0] = modeloPP.listaPedidos().get(i).getIdPedido();
               // vistaCRUD.btnGEdit.setEnabled(true);
            
            //columna[2] = modeloPP.listPersona().get(i).getNombres();
            /*columna[3] = modeloCRUD.listPersona().get(i).getFechaN();
            columna[4] = modeloCRUD.listPersona().get(i).getDireccion(); 
            columna[5] = modeloCRUD.listPersona().get(i).getTelefono();*/
            modeloX.addRow(columna);
        }
    }
    
    public void LlenarTabla(JTable tablaD){
        DefaultTableModel  modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("ID");
        modeloT.addColumn("FOTO");
        modeloT.addColumn("PRECIO");
        modeloT.addColumn("");
  
        Object[] columna = new Object[3];

        int numRegistros = modeloCRUD.listaProductos().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloCRUD.listaProductos().get(i).getId();
             try{
                    FileInputStream bi = modeloCRUD.listaProductos().get(i).getImage();
                    BufferedImage image = null;
                    //InputStream in = new ByteArrayInputStream(bi);
                    //image = ImageIO.read(in);
                    image = ImageIO.read(bi);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(80, 80, 0));
                    columna[1] = new JLabel(imgi);

                }catch(Exception ex){
                    columna[1] = new JLabel("No imagen");
                }
             columna[2] = modeloCRUD.listaProductos().get(i).getPrecio();

               // vistaCRUD.btnGEdit.setEnabled(true);
            
           
            modeloT.addRow(columna);
        }
    }
    public void llenarCombo(JComboBox cbox_paises){
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
         if(e.getSource() == vistaCRUD.btnListar){
            LlenarTabla(vistaCRUD.jtDatos);
            LlenarTablaPP(vistaCRUD.jTable1);
            llenarCombo(vistaCRUD.cboxMesero);
            JOptionPane.showMessageDialog(null, "Lista de productos.");
         }
         
         /*if(e.getSource() == vistaCRUD.btnNuevoPedido){
             
             //recueperar id de mesero como? en el login y con variable global?
             int idMesero = 1;
             String rptaRegistro = modeloCRUD.insertPedido(idMesero );
             
     
            if(rptaRegistro!=null){
                JOptionPane.showMessageDialog(null, rptaRegistro);
                this.vistaCRUD.txtIdMesero.setText(String.valueOf(idMesero));
                this.vistaCRUD.txtIdMesero.setText(String.valueOf(idMesero));
                //LLenarTabla(vistaCRUD.jtDatos);
            }else{
                JOptionPane.showMessageDialog(null, "Registro Erroneo.");
            }
        }*/
         
         if(e.getSource() == vistaCRUD.btnRegistrar){
            /* llenar la tabla de pedidos
             LLenarTabla(vistaCRUD.jtDatos);*/
             if(vistaCRUD.txtCantidad.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debe llenar los campos ");
            }
            else{
                 
            int idPedido = Integer.parseInt(vistaCRUD.txtIdPedido.getText());
            int idProducto = Integer.parseInt(vistaCRUD.txtIdProducto.getText());
            int cantidad = Integer.parseInt(vistaCRUD.txtCantidad.getText());
            int precio = Integer.parseInt(vistaCRUD.txtPrecio.getText());
            
            double subtotal= cantidad *precio ;
            this.vistaCRUD.txtTotal.setText(String.valueOf(subtotal));
            // deberia ser modeloPP
            String rptaRegistro = modeloCRUD.insertProductoPedido(idPedido, idProducto , cantidad, subtotal);
            double total = subtotal+ subtotal; 
            
            if(rptaRegistro!=null){
                JOptionPane.showMessageDialog(null, rptaRegistro);
                
                
                LlenarTabla(vistaCRUD.jtDatos);
            }else{
                JOptionPane.showMessageDialog(null, "Registro Erroneo.");
            }
            }
         }
         
    }

     @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == vistaCRUD.txtCantidad){
            char c = e.getKeyChar();
            if(c<'0' || c>'9'){
                e.consume();
            }
        }
       /*
        if(e.getSource() == vistaCRUD.txtCantidad ){
            char c = e.getKeyChar();
            if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c!=(char)KeyEvent.VK_SPACE)){
                e.consume();
            }
        }*/
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int clic = vistaCRUD.jtDatos.rowAtPoint(me.getPoint());
        int codigo;
        
        codigo = (int)vistaCRUD.jtDatos.getValueAt(clic, 0);
        vistaCRUD.txtNombre.setText(String.valueOf(codigo));
    }

    @Override
    public void mousePressed(MouseEvent me) {
         int clic = vistaCRUD.jtDatos.rowAtPoint(me.getPoint());
        int codigo;
        
        codigo = (int)vistaCRUD.jtDatos.getValueAt(clic, 0);
        vistaCRUD.txtNombre.setText(String.valueOf(codigo));
    }

    @Override
    public void mouseReleased(MouseEvent me) {
         int clic = vistaCRUD.jtDatos.rowAtPoint(me.getPoint());
        int codigo;
        
        codigo = (int)vistaCRUD.jtDatos.getValueAt(clic, 0);
        vistaCRUD.txtNombre.setText(String.valueOf(codigo));
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
 

   
}
