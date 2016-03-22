package com.cad;

import java.util.List;

import com.cad.dao.ClienteDAO;
import com.cad.dao.DAOFactory;
import com.cad.modelo.Cliente;


public class BuscaTodosClientes {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
		
		List<Cliente> clientes = clienteDAO.buscarTodos();
		
		for(Cliente cliente : clientes){
			System.out.println("--------------");
			System.out.printf("Código: %d\n",cliente.getCodigo());
			System.out.printf("Nome: %s\n",cliente.getNome());
			System.out.println();
		}

	}

}
