package MatiasPersistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "api_factura")
@DiscriminatorValue(value = "factura")
public class Factura extends Comprobante{

    //ATRIBUTOS
	@Column(name = "factura_tipo")
    private String tipo;
    
    //RELACIONES
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "DetalleFactura.id")
    private List<DetalleFactura> detalles;
    
    
    //CONSTRUCTOR
    public Factura() {
        this.detalles = new ArrayList<>();
    }

    
    //GETTERS AND SETTERS
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public List<DetalleFactura> getDetalles() {
        return detalles;
    }
    public void setDetalles(ArrayList<DetalleFactura> detalles) {
        this.detalles = detalles;
    }
    public void addDetalles(DetalleFactura detalles){
        this.detalles.add(detalles);
    }
    
}