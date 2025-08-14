package org.cdac.controller.Entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("devices")
public class Device {

	@PrimaryKey
	String id;
	String devicename;
	String mac;
	String ip;
	String type;

}
