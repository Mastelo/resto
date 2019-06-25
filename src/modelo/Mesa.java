/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author orlandolopez
 */
public class Mesa {

    private int nroMesa;
    private int estado;
    private int capacidad;

    public Mesa() {
    }

    public Mesa(int nroMesa, int estado, int capacidad) {
        this.nroMesa = nroMesa;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public int getNroMesa() {
        return nroMesa;
    }

    public void setNroMesa(int nroMesa) {
        this.nroMesa = nroMesa;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
