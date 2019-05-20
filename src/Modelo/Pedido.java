
package Modelo;


public class Pedido {
    
    private int idPedido;
    private String idMesero;
    private Double total;
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(String idMesero) {
        this.idMesero = idMesero;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
   
}
