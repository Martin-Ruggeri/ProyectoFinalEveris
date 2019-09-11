package MatiasPersistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "api_detallefactura")
public class DetalleFactura extends Base{
    //ATRIBUTOS
	@Column(name = "detallefactura_cantidad")
    private int cantidad;
    
    //RELACIONES
    @ManyToOne()
    @JoinColumn(name = "Producto.id")
    private Producto producto;
    
    @OneToMany(mappedBy = "detalles")
    private Factura factura;
    
    //CONSTRUCTOR
    public DetalleFactura() {}
    
    //GETTERS AND SETTERS
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
}