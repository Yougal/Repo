package com.journaldev.spring.jdbc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.journaldev.spring.jdbc.model.Address;

public class AddressDAOImpl implements AddressDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Address address) {
		String queryAddress = "insert into Address (id, address,country) values (?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(queryAddress, new Object[] { address.getId(),
				address.getAddress(),
				address.getCountry() });
		System.out.println("Inserted into Address Table Successfully");
	}

}
