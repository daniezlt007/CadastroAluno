package com.cad.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cad.dao.ClienteDAO;
import com.cad.dao.DAOException;
import com.cad.modelo.Cliente;

public class JdbcClienteDAO implements ClienteDAO {
	
	private Connection connection;
	
	public JdbcClienteDAO(Connection connection){
		this.connection = connection;
	}
	
	@Override
	public void salvar(Cliente cliente) {
		try {
			String sql = String.format("insert into cliente (nome) values ('%s')", cliente.getNome());
			
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DAOException("Erro ao inserir", e);
		}finally{
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public Cliente buscarPeloCodigo(Long codigo) {
		Cliente cliente = null;
		try {
			String sql = String.format("select * from cliente where id = %d", codigo);
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro buscando Cliente", e);
		}finally{
			try{
				this.connection.close();
			}catch(Exception e){}
		}
		return cliente;
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			String sql = "select * from cliente";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro buscando Cliente", e);
		}finally{
			try{
				this.connection.close();
			}catch(Exception e){}
		}
		return clientes;
			}

	@Override
	public Cliente buscarPeloNome(String nome) {
		Cliente cliente = null;
		try {
			//String sql = String.format("select * from cliente where nome like '%", nome,"%'");
			String sql = "select * from cliente where nome like '" + nome + "%'";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cliente = new Cliente();
				cliente.setCodigo(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro buscando Cliente", e);
		}finally{
			try{
				this.connection.close();
			}catch(Exception e){}
		}
		return cliente;
	}
}
