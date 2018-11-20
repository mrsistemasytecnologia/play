package net.mrsistemas.play.remote.beans;

import java.util.List;

import javax.ejb.Remote;
import net.mrsistemas.play.model.entities.ElectronicCategory;
import net.mrsistemas.play.model.entities.ElectronicDevice;

/**
 * @generated DT_ID=none
 */
@Remote
public interface IDeviceBeanRemote {

	/**
	 * @generated DT_ID=none
	 */
	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

	/**
	 * @generated DT_ID=none
	 */
	public ElectronicCategory persistElectronicCategory(ElectronicCategory electronicCategory);

	/**
	 * @generated DT_ID=none
	 */
	public ElectronicCategory mergeElectronicCategory(ElectronicCategory electronicCategory);

	/**
	 * @generated DT_ID=none
	 */
	public void removeElectronicCategory(ElectronicCategory electronicCategory);

	/**
	 * @generated DT_ID=none
	 */
	public List<ElectronicCategory> getElectronicCategoryFindAll();

	/**
	 * @generated DT_ID=none
	 */
	public List<ElectronicCategory> getElectronicCategoryFindById(String param1);

	/**
	 * @generated DT_ID=none
	 */
	public ElectronicDevice persistElectronicDevice(ElectronicDevice device);

	/**
	 * @generated DT_ID=none
	 */
	public ElectronicDevice mergeElectronicDevice(ElectronicDevice device);

	/**
	 * @generated DT_ID=none
	 */
	public void removeElectronicDevice(ElectronicDevice device);

	/**
	 * @generated DT_ID=none
	 */
	public List<ElectronicDevice> getElectronicDeviceFindAll();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<ElectronicDevice> getElectronicDeviceFindById(String id);

	/**
	 * @generated DT_ID=none
	 */
	public List<ElectronicDevice> getElectronicDeviceFindById(String id, String user);

	/**
	 * @generated DT_ID=none
	 */
	public List<ElectronicDevice> getElectronicDeviceFindByUsers(String users);

}
