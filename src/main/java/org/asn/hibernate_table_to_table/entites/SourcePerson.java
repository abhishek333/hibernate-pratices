/**
 * 
 */
package org.asn.hibernate_table_to_table.entites;

import javax.persistence.Entity;

/**
 * @author Abhishek
 *
 */
@Entity
public class SourcePerson extends Person {

	public SourcePerson() {
		super();
	}

	public SourcePerson(String name, String country) {
		super(name, country);
	}

	
}
