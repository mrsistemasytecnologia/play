package net.mrsistemas.play.model.bo;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJBException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.mrsistemas.play.model.dto.DeviceBeanController;
import net.mrsistemas.play.model.entities.ElectronicCategory;
import net.mrsistemas.play.model.entities.ElectronicDevice;
import net.mrsistemas.play.model.vo.CategoryVO;
import net.mrsistemas.play.model.vo.DeviceVO;

public class DeviceBO {
	private static final Logger log = LogManager.getLogger(UsuarioBO.class.getName());

	public DeviceBO() {
	}

	public DeviceVO persistDevice(DeviceVO device) throws Exception {
		try {
			DeviceVO deviceVO = deviceAdapter(
					DeviceBeanController.getInstance().createElectronicDevice(deviceAdapter(device)));
			return deviceVO;
		} catch (Exception e) {
			log.error("Se ha presentado un error con la consulta del usuario: [" + device.getDeviceId() + "] "
					+ e.getLocalizedMessage());
			throw new Exception(e);
		}
	}

	public Set<DeviceVO> getDevices() throws EJBException {
		Set<DeviceVO> deviceList = new HashSet<DeviceVO>();
		for (ElectronicDevice eDev : DeviceBeanController.getInstance().getElectronicDevices()) {
			deviceList.add(deviceAdapter(eDev));
		}
		return deviceList;
	}

	public DeviceVO getDeviceById(String id) throws EJBException {
		return deviceAdapter(DeviceBeanController.getInstance().getElectronicDevice(id));
	}

	public DeviceVO getDeviceByUsersId(String id, String Users) throws EJBException {
		return deviceAdapter(DeviceBeanController.getInstance().getElectronicDevice(id, Users));
	}

	public Set<DeviceVO> getDeviceByUsers(String Users) throws EJBException {
		Set<DeviceVO> list = new HashSet<DeviceVO>();
		for (ElectronicDevice eDev : DeviceBeanController.getInstance().getElectronicDeviceByUser(Users)) {
			list.add(deviceAdapter(eDev));
		}
		return list;
	}

	public DeviceVO updateDeviceById(DeviceVO device) throws EJBException {
		return deviceAdapter(DeviceBeanController.getInstance().updateDevice(deviceAdapter(device)));
	}

	public DeviceVO updateDevicesByUsers(String id, String user, String operation) throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	private DeviceVO deviceAdapter(ElectronicDevice device) {
		return new DeviceVO(device.getDeviceId(), device.getName(),
				new CategoryVO(device.getElectronicCategory().getIdCategory(), device.getElectronicCategory().getDescription(), device.getElectronicCategory().getName()), device.getUsuarioId(),
				device.getEstado());

	}

	private ElectronicDevice deviceAdapter(DeviceVO device) {
		return new ElectronicDevice(device.getDeviceId(), device.getState(), device.getName(), device.getUsuarioId(),
				new ElectronicCategory(device.getCategory().getIdCategory()));
	}

}
