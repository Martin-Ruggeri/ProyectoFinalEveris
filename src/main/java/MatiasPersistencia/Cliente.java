package MatiasPersistencia;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity(name = "api_cliente")
@DiscriminatorValue(value = "cliente")
public class Cliente extends Persona{
    
    //ATRIBUTOS
	@Column(name = "cliente_ocupacion")
    private String ocupacion;
    
    //CONSTRUCTOR
    public Cliente() {}

    //GETERS AND SETTERS
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
    
     
}