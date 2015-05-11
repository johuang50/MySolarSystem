package by.rakushev.mySolarSystem.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CrudBean implements Crud {
	@Autowired
	private SessionFactory sessionFactory;

	public CrudBean() {
	}

	@SuppressWarnings("unchecked")
	public <T> T merge(T t) {
		return (T) currentSession().merge(t);
	}

	public <T> void saveOrUpdate(T t) {

		currentSession().saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	public <T, PK extends Serializable> T find(Class<T> type, PK id) {

		return (T) currentSession().get(type, id);
	}

	@SuppressWarnings({ "unchecked" })
	public <T> List<T> list(Class<T> type) {

		return currentSession().createCriteria(type).list();
	}

	@SuppressWarnings({ "unchecked" })
	public <T> T getPlanet(Class<T> type, String prop) {

		return (T) currentSession().createCriteria(type)
				.add(Restrictions.eq("nameOfPlanet", prop)).uniqueResult();
	}

	@SuppressWarnings({ "unchecked" })
	public <T> T check(Class<T> type, Long id) {
		return (T) currentSession().createCriteria(type)
				.add(Restrictions.idEq(id)).uniqueResult();
	}

	public <T, PK extends Serializable> void delete(Class<T> type, PK id) {
		try {
			Session currentSession = currentSession();
			Object object = currentSession.get(type, id);
			currentSession.delete(object);
		} catch (HibernateException e) {

		}

	}

	private Session currentSession() {
		Session currentSession = sessionFactory.getCurrentSession();
		// Session currentSession = sessionFactory.openSession();
		return currentSession;
	}
}
