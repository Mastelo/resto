
package Controlador;

import Modelo.*;
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
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.*;


public class ControladorPedido implements ActionListener, KeyListener, MouseListener {
    
    
    VistaPedido vistaCRUD = new VistaPedido();
    Pedido modeloCRUD = new Pedido();
    
    
    public ControladorPedido(VistaPedido vistaCRUD, Pedido modeloCRUD){
        this.modeloCRUD = modeloCRUD;
        this.vistaCRUD = vistaCRUD;
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnListar.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnEliminar.addActionListener(this);
        this.vistaCRUD.btnGEdit.addActionListener(this);
        this.vistaCRUD.txtBusqueda.addKeyListener(this);
        this.vistaCRUD.txtMesero.addKeyListener(this);
        this.vistaCRUD.txtNombre.addKeyListener(this);
        this.vistaCRUD.txtPedido.addKeyListener(this);
        vistaCRUD.txtMesero.setEditable(false);
        vistaCRUD.txtPedido.setEditable(false);
      //  this.
      //  resume.addMouseListener(new MyMouseListener());
        
    }
    
    public void iniciar() {
        vistaCRUD.setTitle("Coma Comida");
        vistaCRUD.setLocationRelativeTo(null);
     
    }
    
    public void LLenarTabla(JTable tablaD){
        DefaultTableModel  modeloT = new DefaultTableModel();
        tablaD.setModel(modeloT);
        
        modeloT.addColumn("ID");
        modeloT.addColumn("FOTO");
        modeloT.addColumn("");
        modeloT.addColumn("");
       
        
        Object[] columna = new Object[2];

        int numRegistros = modeloCRUD.listPersona().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloCRUD.listPersona().get(i).getId();
             try{
                    FileInputStream bi = modeloCRUD.listPersona().get(i).getImage();
                    BufferedImage image = null;
                    //InputStream in = new ByteArrayInputStream(bi);
                    //image = ImageIO.read(in);
                    image = ImageIO.read(bi);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(80, 80, 0));
                    columna[1] = new JLabel(imgi);

                }catch(Exception ex){
                    columna[1] = new JLabel("No imagen");
                }
                     
               // vistaCRUD.btnGEdit.setEnabled(true);
            
           /* columna[1] = modeloCRUD.listPersona().get(i).getApellidos();
            columna[2] = modeloCRUD.listPersona().get(i).getNombres();
            columna[3] = modeloCRUD.listPersona().get(i).getFechaN();
            columna[4] = modeloCRUD.listPersona().get(i).getDireccion(); 
            columna[5] = modeloCRUD.listPersona().get(i).getTelefono();*/
            modeloT.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
         if(e.getSource() == vistaCRUD.btnListar){
            LLenarTabla(vistaCRUD.jtDatos);
            JOptionPane.showMessageDialog(null, "Lista de registros.");
        }
    }

     @Override
    public void keyTyped(KeyEvent e) {
        /*if(e.getSource() == vistaCRUD.txtMesero){
            char c = e.getKeyChar();
            if(c<'0' || c>'9'){
                e.consume();
            }
        }
        
        if(e.getSource() == vistaCRUD.txtApellidos || e.getSource() == vistaCRUD.txtNombres || e.getSource() == vistaCRUD.txtDireccion ){
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
