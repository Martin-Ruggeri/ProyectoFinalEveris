package MatiasPersistencia;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "api_producto")
public class Producto extends Base{
    //ATRIBUTOS
	@Column(name = "producto_nombre")
    private String nombreProducto;
	@Column(name = "producto_precio")
    private double precio;
    
    //CONSTRUCTOR
    public Producto() {}
        
    //GETTERS AND SETTERS
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecioUnitario(double precio) {
        this.precio = precio;
    }
 
}