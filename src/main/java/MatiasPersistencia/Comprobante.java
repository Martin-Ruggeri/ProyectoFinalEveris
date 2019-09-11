package MatiasPersistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "api_comprobante")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
@Table(name = "comprobante")
public class Comprobante extends Base{
    
	//ATRIBUTOS
	@Column(name = "comprobante_fecha")
    protected String fecha;
    
    //RELACIONES 
    @ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.DETACH)
    @JoinTable(name = "api_comprobante_persona", joinColumns = @JoinColumn(name = "comprobante_id"),
                                             inverseJoinColumns = @JoinColumn(name = "persona_id"))
    protected List<Persona> personas = new ArrayList<>();
    
    
    //CONSTRUCTOR
    public Comprobante() {}
    
    
    //GETTERS AND SETTERS
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Persona> getPersonas() {
        return personas;
    }
	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
    public void addPersona(Persona personas){
        this.personas.add(personas);
    }
    
    
}
