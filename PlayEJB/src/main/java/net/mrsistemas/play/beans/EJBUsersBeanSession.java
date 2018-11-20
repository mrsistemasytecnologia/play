package net.mrsistemas.play.beans;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.mrsistemas.play.model.entities.GenCiudad;
import net.mrsistemas.play.model.entities.GenSession;
import net.mrsistemas.play.model.entities.TourDatosUsuario;
import net.mrsistemas.play.remote.beans.IUsuariosEJBRemote;



@Stateless(name = "UsersBeanEJB", mappedName = "userOperationBeans")
public class EJBUsersBeanSession implements IUsuariosEJBRemote {
	@Resource
	SessionContext sessionContext;
	@PersistenceContext(unitName = "PlayEJB")
	private EntityManager em;

	public EJBUsersBeanSession() {
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
		Query query = em.createQuery(jpqlStmt);
		if (firstResult > 0) {
			query = query.setFirstResult(firstResult);
		}
		if (maxResults > 0) {
			query = query.setMaxResults(maxResults);
		}
		return query.getResultList();
	}

	public <T> T persistEntity(T entity) {
		em.persist(entity);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T findDatosUsuario(String id) {
		return (T) em.find(TourDatosUsuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T validaDatosSession(String id) {
		return (T) em.find(GenSession.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T findCityById(String id) {
		return (T) em.find(GenCiudad.class, id);
	}

	public <T> T mergeEntity(T entity) {
		return em.merge(entity);
	}

	public Object getEntities(String jpqlStmt) {
		return em.createNamedQuery(jpqlStmt).getResultList();
	}

	@Override
	public Object getConsultaDosParametros(String jpqlStmt, String parametroUno, String parametroDos) {
		Query query = em.createNamedQuery(jpqlStmt);
		query.setParameter(1, parametroUno);
		query.setParameter(2, parametroDos);
		return query.getSingleResult();
	}

	@Override
	public Object getEntityById(String jpqlStmt, String parametro) {
		Query query = em.createNamedQuery(jpqlStmt);
		query.setParameter(1, parametro);
		return query.getSingleResult();
	}
	
	@Override
	public Object getEntitiesById(String jpqlStmt, String parametro) {
		Query query = em.createNamedQuery(jpqlStmt);
		query.setParameter(1, parametro);
		return query.getResultList();
	}

	
}
