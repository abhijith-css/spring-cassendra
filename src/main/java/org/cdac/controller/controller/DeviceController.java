package org.cdac.controller.controller;

import org.cdac.controller.dto.Request;
import org.cdac.controller.dto.Response;
import org.cdac.controller.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devices")
public class DeviceController {

	@Autowired
	DeviceService deviceService;

	private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

	@PostMapping("/save")
	public ResponseEntity<Response> saveDevice(@RequestBody Request request) {
		Response response = deviceService.saveDevice(request);
		logger.info("Device Saved");
		return ResponseEntity.ok(response);
	}
}