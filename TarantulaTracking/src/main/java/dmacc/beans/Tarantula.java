package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarantula 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String species;
	private String sizeClassification;
	//connect molts class here?
	//test push
	
	public Tarantula() {
		super();
	}
	
	public Tarantula(int id, String name, String species, String sizeClassification) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSizeClassification() {
		return sizeClassification;
	}

	public void setSizeClassification(String sizeClassification) {
		this.sizeClassification = sizeClassification;
	}

	@Override
	public String toString() {
		return "Tarantula [id=" + id + ", name=" + name + ", species=" + species + ", sizeClassification="
				+ sizeClassification + "]";
	}
	
	
	
	
}
