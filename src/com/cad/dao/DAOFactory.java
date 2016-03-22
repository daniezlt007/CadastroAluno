package com.cad.dao;

import com.cad.dao.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(){
		return new JdbcDAOFactory();
	}
	
	public abstract ClienteDAO getClienteDAO();
}
