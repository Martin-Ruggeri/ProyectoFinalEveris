package MatiasPersistencia;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "api_vendedor")
@DiscriminatorValue(value = "vendedor")
public class Vendedor extends Persona{
    //ATRIBUTO
	@Column(name = "vendedor_sector")
    private String sector;
    
    //CONSTRUCTOR
    public Vendedor() {}
    
    //GETTERS AND SETTERS
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    
}