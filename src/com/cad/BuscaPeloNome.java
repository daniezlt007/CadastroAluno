package com.cad;

import javax.swing.JOptionPane;

import com.cad.dao.ClienteDAO;
import com.cad.dao.DAOFactory;
import com.cad.modelo.Cliente;



public class BuscaPeloNome {
	public static void main(String[] args) {
		ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();
		String sb = "";
		String n = JOptionPane.showInputDialog("Informe o nome a ser pesquisado: ");
		
		Cliente cliente = clienteDAO.buscarPeloNome(n);
		if(cliente != null){
			sb += ("-----------------------------------\n");
			sb += ("Código: " + cliente.getCodigo() + "\n");
			sb += ("Nome: " + cliente.getNome() + "\n"); 
			sb += ("-------------------------------------");
			
			JOptionPane.showMessageDialog(null, sb);
			
		}else{
			System.out.println("Cliente Não existe!");
		}
		
	}
}
