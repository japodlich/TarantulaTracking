package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Tarantula 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tId;
	private String name;
	private String species;
	private String sizeClassification;
	
	//connect molts class here?
	//test push

	
	public Tarantula(int id, String name, String species, String sizeClassification) {
		super();
		this.tId = id;
		this.name = name;
		this.species = species;
		this.sizeClassification = sizeClassification;
	}

	public Tarantula(String name, String species, String sizeClassification) {
		super();
		this.name = name;
		this.species = species;
		this.sizeClassification = sizeClassification;
	}


	
	
	
	
	
}
