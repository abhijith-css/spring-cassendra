package org.cdac.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "org.cdac.controller.cassendraRepo")
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Override
	protected String getKeyspaceName() {
		return "web_data_base";
	}

	@Bean
	@Primary
	public CqlSessionFactoryBean session() {
		CqlSessionFactoryBean session = new CqlSessionFactoryBean();
		session.setContactPoints("127.0.0.1");
		session.setPort(9042);
		session.setLocalDatacenter("datacenter1"); // must match nodetool status
		session.setKeyspaceName(getKeyspaceName());
		return session;
	}

	@Override
	public String[] getEntityBasePackages() {
		return new String[] { "org.cdac.controller.Entity" };
	}

	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS; // auto-create missing tables
	}

}
