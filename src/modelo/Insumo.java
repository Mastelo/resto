
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import vista.JFinsumos;

/**
 *
 * @author Ivan
 */
public class Insumo {
    private String nombre;
    private String Descripcion;
    private Double precio;
    private String fechaC;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFechaC() {
        
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }
    

    
}
