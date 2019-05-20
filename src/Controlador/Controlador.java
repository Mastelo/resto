/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consulta;
import Modelo.ListaProductos;
import Modelo.Producto;
import Vista.Vista;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import vista.VistaPedido;

/**
 *
 * @author orlandolopez
 */
public class Controlador implements ActionListener {

    private Producto producto;
    private Consulta consulta;
    private Vista vista;
    
    String ruta = "";

    public Controlador(Producto producto, Consulta consulta, Vista vista) {
        this.producto = producto;
        this.consulta = consulta;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnSeleccionar.addActionListener(this);   

    }
    
    public void iniciar() {
        vista.setTitle("Coma Comida");
        vista.setLocationRelativeTo(null);
        /*vista.comboTamanho.addItem("Pequeño");
        vista.comboTamanho.addItem("Mediano");
        vista.comboTamanho.addItem("Grande");*/
        
        anhadirItem();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == vista.btnGuardar) {       
                     //  Vista().setVisible(false);

            if (!camposVacios()) {
                
                producto.setNombre(vista.textNombre.getText());
                producto.setDescripcion(vista.textDescripcion.getText());
                producto.setPrecio(Double.parseDouble(vista.textPrecio.getText()));
                //producto.setTamanho(vista.comboTamanho.getSelectedItem().toString());
                producto.setImage(mFile(ruta));                              

                limpiar();
                if (consulta.registrar(producto)) {
                    JOptionPane.showMessageDialog(null, "Registro con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Registro erroneo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene los campos");
            }
        }

        if (e.getSource() == vista.btnSeleccionar) {
            //JOptionPane.showMessageDialog(null, "imagen");
            captarImagen();

        }
    }

    public void limpiar() {
        vista.textNombre.setText(null);
        vista.textDescripcion.setText(null);
        vista.textPrecio.setText(null);
        vista.lblImagen.setIcon(null);
    }

    public boolean camposVacios() {
        boolean estado = false;
        if (vista.textNombre.getText().length() == 0 || vista.textDescripcion.getText().length() == 0 
                || vista.textPrecio.getText().length() == 0) {
            estado = true;
        }
        return estado;
    }

    public void captarImagen() {
        JFileChooser file = new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Png, Jpg, Jpeg file", "jpg", "jpeg", "png");
        file.setFileFilter(filtro);
        int num = file.showOpenDialog(vista);

        
        if (num == JFileChooser.APPROVE_OPTION) {
            ruta = file.getSelectedFile().getAbsolutePath();
            ImageIcon img = new ImageIcon(ruta);
            Image imgEs = img.getImage().getScaledInstance(vista.lblImagen.getWidth(), vista.lblImagen.getHeight(), Image.SCALE_SMOOTH);
            vista.lblImagen.setIcon(new ImageIcon(imgEs));
        }
        mFile(ruta);
        
    }
    
    public FileInputStream mFile(String ruta){
        FileInputStream fi = null;
        File fileImagen = new File(ruta);
        try {
            fi = new FileInputStream(fileImagen);
            //producto.setImagen2(fileImagen);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fi;
    }
    
    public void anhadirItem(){
        vista.comboTamanho.addItem("Pequeño");
        vista.comboTamanho.addItem("Mediano");
        vista.comboTamanho.addItem("Grande");
    }
}

