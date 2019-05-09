/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author orlandolopez
 */
public class Producto {

    private int id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private FileInputStream foto;
    private String tamaño;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTamanho() {
        return tamaño;
    }

    public void setTamanho(String tamanho) {
        this.tamaño = tamanho;
    }

    public FileInputStream getImage() {
        return foto;
    }

    public void setImage(FileInputStream image) {
        this.foto = image;
    }
}
