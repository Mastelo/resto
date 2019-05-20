
package Controlador;

import Vista.VistaPrincipal;
import Vista.Vista;
//import Vista.VistaPedido;
import Modelo.Producto;
import Modelo.Consulta;
import Modelo.ListaPedidos;
import Modelo.ListaProductos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaPedido;

public class ControladorPrincipal implements ActionListener {

     private VistaPrincipal vistaPrincipal;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.getBtnAlumnos().addActionListener(this);
        this.vistaPrincipal.getBtnProfesores().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipal.getBtnAlumnos()) {
            System.out.println("getBtnAlumnos PRINCIPAL ALUMNOS FUNCIONA");
            Vista vistaProductos = new Vista();
            Producto producto =new Producto();
            Consulta consulta = new Consulta();
            Vista vista = new Vista();
            Controlador cPedido = new Controlador(producto, consulta, vistaProductos);
            vistaProductos.setVisible(true);
            vistaProductos.setLocationRelativeTo(null);
           
            
           
        }// FIN IF getBtnAlumnos

        // Capturo los eventos del Boton Agregar
        if (e.getSource() == vistaPrincipal.getBtnProfesores()) {
            VistaPedido vistaC = new VistaPedido();
            ListaProductos modeloC = new ListaProductos();
            ListaPedidos modeloPP = new ListaPedidos();

            //ControladorPedido controlaC = new ControladorPedido(vistaC, modeloC);
            ControladorPedido controlaC = new ControladorPedido(vistaC, modeloC, modeloPP);

            vistaC.setVisible(true);
            vistaC.setLocationRelativeTo(null);
            
           

        }
    }
    
}
