/**
 * 
 */
package org.asn.hibernate_table_to_table.entites;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Abhishek
 *
 */
@MappedSuperclass
public abstract class Person {
	
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	private String country;
	
	public Person(){super();}

	public Person(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
