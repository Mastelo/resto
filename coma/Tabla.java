/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coma;

import Controlador.Controlador;
import Controlador.ControladorTabla;
import Modelo.Consulta;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Vista;
import Vista.VistaListaProductos;

/**
 *
 * @author orlandolopez
 */
public class Tabla {
    
    
    public static void main(String[] args) {
        
        Pedido pedido = new Pedido();
        Consulta consulta = new Consulta();
        VistaListaProductos vista = new VistaListaProductos();
        
        ControladorTabla ctrl = new ControladorTabla(pedido, consulta, vista);
        ctrl.iniciar();
        vista.setVisible(true);
    }
}
