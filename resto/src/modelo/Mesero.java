
package modelo;


public class Mesero {
    String id;
    String apellidos;
    String nombres;
    String fechaN;
    String direccion;
    int telefono;
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    

    public Mesero(){
        id="";
        apellidos="";
        nombres="";
        fechaN="";
        direccion="";
        telefono= 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }
    
     public String getDireccion() {
        return direccion;
    }
     
    public int getTelefono() {
        return telefono;
    }

    
}
