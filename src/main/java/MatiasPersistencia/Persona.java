package MatiasPersistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity(name = "api_persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminador")
@Table(name = "persona")
public class Persona extends Base{
    
    //ATRIBUTOS
	@Column(name = "persona_nombre")
    protected String nombre;
	@Column(name = "persona_apellido")
    protected String apellido;
	@Column(name = "persona_edad")
    protected int edad;
    
    //RELACIONES
    @ManyToMany(mappedBy = "personas", fetch = FetchType.LAZY)
    protected List<Comprobante> comprobantes = new ArrayList<>();
    
    
    //CONSTRUCTOR
    public Persona() {}

    
    //GETERS AND SETTERS
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	public List<Comprobante> getComprobantes() {
        return comprobantes;
    }
	public void setComprobantes(List<Comprobante> comprobantes) {
		this.comprobantes = comprobantes;
	}
    public void addComprobante(Comprobante comprobante){
        this.comprobantes.add(comprobante);
    }

    
}
