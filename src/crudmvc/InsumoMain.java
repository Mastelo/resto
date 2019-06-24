/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import controlador.CtrlInsumo;
import modelo.ConsultaInsumo;
import modelo.Insumo;
import vista.JFinsumos;

/**
 *
 * @author Ivan
 */
public class InsumoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Insumo ins =new Insumo();
        ConsultaInsumo csins = new ConsultaInsumo();
        JFinsumos jfins = new JFinsumos();
        
        CtrlInsumo ctrl = new CtrlInsumo(ins, csins, jfins);
        ctrl.iniciar();
        jfins.setVisible(true);
    }
    
}
