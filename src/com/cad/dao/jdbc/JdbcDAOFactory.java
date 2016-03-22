package com.cad.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import com.cad.dao.ClienteDAO;
import com.cad.dao.DAOFactory;

public class JdbcDAOFactory extends DAOFactory {
	
	private Connection connection;
	
	public JdbcDAOFactory(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost/projetojdbc","root","root");
		} catch (Exception e) {
			throw new RuntimeException("Erro ao recuperar conexão!", e);
		}
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new JdbcClienteDAO(connection);
	}
	
}
