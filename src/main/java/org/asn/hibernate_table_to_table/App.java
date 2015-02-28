package org.asn.hibernate_table_to_table;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.asn.hibernate_table_to_table.dao.PersonDAO;
import org.asn.hibernate_table_to_table.entites.Person;
import org.asn.hibernate_table_to_table.entites.SourcePerson;
import org.asn.hibernate_table_to_table.entites.TargetPerson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Hello world!
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class App 
{
	@Autowired
	private PersonDAO personDAO;
	
	/*@Test
	public void test(){
		for(int i=1; i<=10; i++){
			SourcePerson newPerson = new SourcePerson("Abhishek"+i, "India");		
			SourcePerson savedPerson = personDAO.save(newPerson);		
			assertNotNull(savedPerson);
		}
	}*/
	
	@Test
	public void testMoveByPersonIdToSelectedPerson(){		
		List<Long> idList = new ArrayList<Long>();
		idList.add(4l);
		idList.add(5l);
		idList.add(6l);
		idList.add(7l);
		List<TargetPerson> personsMovedList = personDAO.moveByPersonIdToTargetPerson(idList);		
		assertNotNull(personsMovedList);		
		assertNotEquals(0, personsMovedList.size());		
	}
}
