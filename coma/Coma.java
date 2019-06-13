/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coma;

import Controlador.Controlador;
import Consulta.Consulta;
import Modelo.Producto;
import Vista.Vista;

/**
 *
 * @author orlandolopez
 */
public class Coma {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Producto producto = new Producto();
        Consulta consulta = new Consulta();
        Vista vista = new Vista();
        
        Controlador ctrl = new Controlador(producto, consulta, vista);
        ctrl.iniciar();
        vista.setVisible(true);
    }
    
}
