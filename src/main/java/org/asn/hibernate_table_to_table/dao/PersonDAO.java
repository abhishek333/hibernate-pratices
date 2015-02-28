/**
 * 
 */
package org.asn.hibernate_table_to_table.dao;

import java.util.List;

import org.asn.hibernate_table_to_table.entites.SourcePerson;
import org.asn.hibernate_table_to_table.entites.TargetPerson;

/**
 * @author Abhishek
 *
 */
public interface PersonDAO {
	
	public SourcePerson save(SourcePerson newPerson);
	public List<TargetPerson> moveByPersonIdToTargetPerson(List<Long> personIdList);

}
