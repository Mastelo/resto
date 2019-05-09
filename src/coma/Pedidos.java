
package coma;

import modelo.*;
import vista.*;
import controlador.*;
import vista.VistaPedido;
import Controlador.ControladorPedido;
import Modelo.Pedido;


public class Pedidos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaPedido vistaC = new VistaPedido();
        Pedido modeloC = new Pedido();
        ControladorPedido controlaC = new ControladorPedido(vistaC, modeloC);
        
        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);
    }
    
}
