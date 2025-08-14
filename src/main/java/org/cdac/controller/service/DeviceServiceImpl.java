package org.cdac.controller.service;

import org.cdac.controller.Entity.Device;
import org.cdac.controller.cassendraRepo.DeviceRepo;
import org.cdac.controller.dto.Request;
import org.cdac.controller.dto.Response;
import org.cdac.controller.utils.ControllerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceRepo deviceRepo;
	@Autowired
	ControllerUtils controllerUtils;

	private static final Logger logger = LoggerFactory.getLogger(DeviceServiceImpl.class);

	@Override
	public Response saveDevice(Request request) {

		Response response = new Response();
		Device device = new Device();
		Device d = new Device();
		String key = controllerUtils.createPrimaryKey();
		device.setId(key);
		device.setDevicename(request.getDeviceName());
		device.setIp(request.getIp());
		device.setMac(request.getMac());
		device.setType(request.getType());
		if (request.getDeviceName() == null || request.getDeviceName().isEmpty()) {
			response.setMessage("Must fill Name");
		} else {
			d = deviceRepo.save(device);
		}

		if (d.getId().isEmpty()) {
			response.setMessage("Error in saving ");
			logger.info("Data not saved");
		} else {
			response.setMessage("Data saved ");
			response.setStatus("Id:" + d.getId());
			logger.info("Device details saved");
		}

		return response;
	}

}
