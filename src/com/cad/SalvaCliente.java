package com.cad;

import javax.swing.JOptionPane;

import com.cad.dao.ClienteDAO;
import com.cad.dao.DAOFactory;
import com.cad.modelo.Cliente;



public class SalvaCliente {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		String nome = JOptionPane.showInputDialog(null, "Nome do solicitante",
				"Cadastro de solicitante", JOptionPane.QUESTION_MESSAGE);
		
		if(nome != null){
			cliente.setNome(nome);
			
			ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
			clienteDAO.salvar(cliente);
			System.out.println("Cliente Salvo com Sucesso!");
		}
	}

}
