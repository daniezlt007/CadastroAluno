package com.cad;

import javax.swing.JOptionPane;

import com.cad.dao.ClienteDAO;
import com.cad.dao.DAOFactory;
import com.cad.modelo.Cliente;

public class BuscaPeloCodigo {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
		String sb = "";
		Long a = Long.parseLong(JOptionPane.showInputDialog("Informe o código a ser pesquisado:"));
		Cliente cliente = clienteDAO.buscarPeloCodigo(a);
		
		if(cliente != null){
			sb += ("-----------------------------------\n");
			sb += ("Código: " + cliente.getCodigo() + "\n");
			sb += ("Nome: " + cliente.getNome() + "\n"); 
			sb += ("-------------------------------------");
			
			JOptionPane.showMessageDialog(null, sb);
			/*
			System.out.println("--------------");
			System.out.printf("Código: %d\n",cliente.getCodigo());
			System.out.printf("Nome: %s\n",cliente.getNome());
			System.out.println();*/
		}else{
			System.out.println("Cliente Não existe!");
		}

	}

}
