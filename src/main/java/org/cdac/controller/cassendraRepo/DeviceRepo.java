package org.cdac.controller.cassendraRepo;

import org.cdac.controller.Entity.Device;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface DeviceRepo extends CassandraRepository<Device, String>{

}
