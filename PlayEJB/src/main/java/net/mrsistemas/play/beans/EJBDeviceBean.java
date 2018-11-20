package net.mrsistemas.play.beans;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.AroundInvoke;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

import net.mrsistemas.play.local.beans.IEJBDeviceBeanLocal;
import net.mrsistemas.play.model.entities.ElectronicCategory;
import net.mrsistemas.play.model.entities.ElectronicDevice;
import net.mrsistemas.play.remote.beans.IDeviceBeanRemote;

/**
 * @generated DT_ID=none
 */
@SuppressWarnings("unchecked")
@Stateless(name = "EJBDeviceBean", mappedName = "Java-EJBDeviceBean")
@TransactionManagement(TransactionManagementType.BEAN)
@Interceptors(EJBDeviceBeanTxnInterceptor.class)
public class EJBDeviceBean implements IEJBDeviceBeanLocal, IDeviceBeanRemote {

	/**
	 * @generated DT_ID=none
	 */
	@Resource
	SessionContext sessionContext;

	/**
	 * @generated DT_ID=none
	 */
	@PersistenceContext(unitName = "PlayEJB")
	private EntityManager em;

	/**
	 * @generated DT_ID=none
	 */
	public EJBDeviceBean() {
	}

	/**
	 * @generated DT_ID=none
	 */
	@ExcludeClassInterceptors
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

	/**
	 * @generated DT_ID=none
	 */
	public ElectronicCategory persistElectronicCategory(ElectronicCategory electronicCategory) {
		em.persist(electronicCategory);
		return electronicCategory;
	}

	/**
	 * @generated DT_ID=none
	 */
	public ElectronicCategory mergeElectronicCategory(ElectronicCategory electronicCategory) {
		return em.merge(electronicCategory);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeElectronicCategory(ElectronicCategory electronicCategory) {
		electronicCategory = em.find(ElectronicCategory.class, electronicCategory.getIdCategory());
		em.remove(electronicCategory);
	}

	/**
	 * @generated DT_ID=none
	 */
	@ExcludeClassInterceptors
	public List<ElectronicCategory> getElectronicCategoryFindAll() {
		return em.createNamedQuery("ElectronicCategory.findAll").getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	@ExcludeClassInterceptors
	public List<ElectronicCategory> getElectronicCategoryFindById(String id) {
		return em.createNamedQuery("ElectronicCategory.findById").setParameter(1, id).getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	public ElectronicDevice persistElectronicDevice(ElectronicDevice electronicDevice) {
		em.persist(electronicDevice);
		return electronicDevice;
	}

	/**
	 * @generated DT_ID=none
	 */
	public ElectronicDevice mergeElectronicDevice(ElectronicDevice electronicDevice) {
		return em.merge(electronicDevice);
	}

	/**
	 * @generated DT_ID=none
	 */
	public void removeElectronicDevice(ElectronicDevice electronicDevice) {
		electronicDevice = em.find(ElectronicDevice.class, electronicDevice.getDeviceId());
		em.remove(electronicDevice);
	}

	/**
	 * @generated DT_ID=none
	 */
	@ExcludeClassInterceptors
	public List<ElectronicDevice> getElectronicDeviceFindAll() {
		return em.createNamedQuery("ElectronicDevice.findAll").getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	@ExcludeClassInterceptors
	public List<ElectronicDevice> getElectronicDeviceFindById(String id) {
		return em.createNamedQuery("ElectronicDevice.findById").setParameter(1, id).getResultList();
	}

	public List<ElectronicDevice> getElectronicDeviceFindById(String id, String user) {
		return em.createNamedQuery("ElectronicDevice.findByUserId").setParameter(1, id).setParameter(2, user)
				.getResultList();
	}

	/**
	 * @generated DT_ID=none
	 */
	public List<ElectronicDevice> getElectronicDeviceFindByUsers(String users) {
		List<ElectronicDevice> lista = em.createNamedQuery("ElectronicDevice.findByUsers").setParameter(1, users)
				.getResultList();
		return lista;
	}

}

/**
 * @generated DT_ID=none
 */
class EJBDeviceBeanTxnInterceptor {
	/**
	 * @generated DT_ID=none
	 */
	public EJBDeviceBeanTxnInterceptor() {}

	/**
	 * @generated DT_ID=none
	 */
	@AroundInvoke
	Object executeInTrans(InvocationContext invocationContext) throws Exception {
		final EJBDeviceBean eJBDeviceBean = (EJBDeviceBean) invocationContext.getTarget();
		final UserTransaction txn = eJBDeviceBean.sessionContext.getUserTransaction();
		if (txn.getStatus() == Status.STATUS_NO_TRANSACTION) {
			txn.begin();
		}

		// Execute the method body, along with any other chained interceptors
		Object result = invocationContext.proceed();

		// Commit the transaction, if it is still active
		if (txn.getStatus() == Status.STATUS_ACTIVE) {
			txn.commit();
		}

		return result;
	}
}
