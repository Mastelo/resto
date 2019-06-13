/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coma;

import Controlador.Controlador;
import Controlador.ControladorPedido;
import Consulta.Consulta;
import Modelo.Producto;
import Vista.Vista;
import Vista.VistaPedido2;

/**
 *
 * @author orlandolopez
 */
public class PedidoP {
    
    public static void main(String[] args) {
        /*
        Producto producto = new Producto();
        
        Vista vista = new Vista();*/
        Consulta consulta = new Consulta();
        VistaPedido2 vistap = new VistaPedido2();
        
        ControladorPedido ctrl = new ControladorPedido(vistap, consulta);
        ctrl.iniciar();
        vistap.setVisible(true);
    }
    
}
