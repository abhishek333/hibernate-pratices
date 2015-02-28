/**
 * 
 */
package org.asn.hibernate_table_to_table.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.asn.hibernate_table_to_table.dao.PersonDAO;
import org.asn.hibernate_table_to_table.entites.Person;
import org.asn.hibernate_table_to_table.entites.SourcePerson;
import org.asn.hibernate_table_to_table.entites.TargetPerson;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Abhishek
 *
 */
@Service
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sf;
	
	private Session getCurrentSession(){
		return sf.getCurrentSession();
	}

	@Transactional
	public SourcePerson save(SourcePerson newPerson) {
		Session session = getCurrentSession();
		Long id = (Long) session.save(newPerson);
		return (SourcePerson) session.get(SourcePerson.class, id);
	}

	@Transactional
	public List<TargetPerson> moveByPersonIdToTargetPerson(List<Long> personIdList) {
		List<TargetPerson> personsMovedList = new ArrayList<TargetPerson>();
		String hql = "INSERT INTO "+TargetPerson.class.getName()
				+ " (name, country) SELECT p.name, p.country FROM "+SourcePerson.class.getName()+
				" p WHERE p.id IN (:ids)";
		Session session = getCurrentSession();
		Query qry = session.createQuery(hql);
		qry.setParameterList("ids", personIdList);
		qry.executeUpdate();
		return session.createCriteria(TargetPerson.class).list();
	}

}
