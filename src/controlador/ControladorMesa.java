/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.ConsultaMesa;
import modelo.Mesa;
import vista.VistaMesa;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import menur.botones;

/**
 *
 * @author orlandolopez
 */
public class ControladorMesa implements ActionListener {

    private Mesa mesa;
    private ConsultaMesa consulta;
    private VistaMesa vista;
    private ArrayList<JButton> botones;

    public ControladorMesa(Mesa mesa, ConsultaMesa consulta, VistaMesa vista) {
        this.mesa = mesa;
        this.consulta = consulta;
        this.vista = vista;

        botones = new ArrayList<>();

        this.vista.textCapacidad.addActionListener(this);
        this.vista.textNroMesa.addActionListener(this);
        this.vista.cmboxDispo.addActionListener(this);
        this.vista.btnRegistrar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);   
        this.vista.btnvolver.addActionListener(this);
        cargarBotones();
    }

    public void iniciar() {
        vista.setTitle("Registar Mesa");
        vista.setLocationRelativeTo(null);

        vista.cmboxDispo.addItem("Disponible");
        vista.cmboxDispo.addItem("Ocupado");

        //cargarBotones();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnvolver) {
            new botones().setVisible(true);
            vista.dispose();
        }
        
        if (e.getSource() == vista.btnRegistrar) {
            System.out.println("kakakaka");
            if (!camposVacios()) {
                if (vista.cmboxDispo.getSelectedIndex() == 0) {
                    mesa.setEstado(0);
                } else {
                    mesa.setEstado(1);
                }
                mesa.setCapacidad(Integer.parseInt(vista.textCapacidad.getText()));

                if (consulta.registrar(mesa)) {
                    JOptionPane.showMessageDialog(null, "Registro con exito");
                    limpiar();
                    refresh();

                } else {
                    JOptionPane.showMessageDialog(null, "Registro erroneo");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Rellene los campos");
            }

        }

        if (e.getSource() == vista.btnModificar) {
            if (!camposVacios()) {
                System.out.println("kikiki");

                mesa.setNroMesa(Integer.parseInt(vista.textNroMesa.getText()));
                mesa.setEstado(vista.cmboxDispo.getSelectedIndex());
                mesa.setCapacidad(Integer.parseInt(vista.textCapacidad.getText()));
                /*
                if (vista.cmboxDispo.getSelectedIndex() == 0) {
                    mesa.setEstado(0);
                } else {
                    mesa.setEstado(1);
                }            
                mesa.setCapacidad(Integer.parseInt(vista.textCapacidad.getText()));*/

                if (consulta.modificar(mesa)) {
                    JOptionPane.showMessageDialog(null, "Modificado con exito");
                    //cargarBotones();
                    limpiar();
                    refresh();
                } else {
                    JOptionPane.showMessageDialog(null, "Modificacion erronea");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Rellene los campos");
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            if (!camposVacios()) {
                System.out.println("kikiki");
                mesa.setNroMesa(Integer.parseInt(vista.textNroMesa.getText()));

                if (consulta.eliminar(mesa)) {
                    JOptionPane.showMessageDialog(null, "Eliminado con exito");
                    limpiar();
                    refresh();
                } else {
                    JOptionPane.showMessageDialog(null, "Eliminacion erronea");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Rellene los campos");
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            if (!campoVacio()) {
                System.out.println("lslslslslsl");
                mesa.setNroMesa(Integer.parseInt(vista.textNroMesa.getText()));
                if (consulta.buscar(mesa)) {
                    vista.textNroMesa.setText(String.valueOf(mesa.getNroMesa()));
                    vista.textCapacidad.setText(String.valueOf(mesa.getCapacidad()));
                    vista.cmboxDispo.setSelectedIndex(mesa.getEstado());
                    vista.lblNroMesa.setText(String.valueOf(mesa.getNroMesa()));
                } else {
                    JOptionPane.showMessageDialog(null, "No encontrado");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Rellene el campo Buscar");
            }
        }
    }

    public void limpiar() {
        vista.textNroMesa.setText(null);
        vista.textCapacidad.setText(null);
        vista.cmboxDispo.setSelectedItem(null);
        vista.lblNroMesa.setText("Valor autoIncrementable");
    }

    public boolean camposVacios() {
        boolean estado = false;
        if (vista.textCapacidad.getText().length() == 0 || vista.cmboxDispo.getSelectedItem().toString().length() == 0){ 
                //|| vista.textNroMesa.getText().length() == 0) {
            estado = true;
        }
        return estado;
    }

    public boolean campoVacio(){
        boolean estado = false;
        if (vista.textNroMesa.getText().length() == 0) {
            estado = true;
        }
        return estado;
    }
    
    public void refresh() {        
        vista.panel.removeAll();
        cargarBotones();       
    }

    public void cargarBotones() {
        ArrayList<Mesa> mesas = consulta.recuperarMesa();

        for (int i = 0; i < mesas.size(); i++) {

            JButton boton = new JButton("Mesa Nro " + mesas.get(i).getNroMesa());
            if(mesas.get(i).getEstado() == 1){
                boton.setBackground(Color.RED);
                
            }else{
                boton.setBackground(Color.GREEN);
            }
            vista.panel.add(boton);
            botones.add(boton);
            vista.panel.updateUI();
        }

    }
    
}
