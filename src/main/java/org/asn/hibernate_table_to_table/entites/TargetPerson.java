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
public class TargetPerson extends Person {

	public TargetPerson() {
		super();
	}

	public TargetPerson(String name, String country) {
		super(name, country);
	}

	
}
