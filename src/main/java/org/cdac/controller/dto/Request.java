package org.cdac.controller.dto;

import lombok.Data;

@Data
public class Request {
	String id;
	String deviceName;
	String mac;
	String ip;
	String type;

}
