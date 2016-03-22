package com.cad;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		int escolha;
		
		String msg = "";
		msg += "Escolha a Opção\n";
		msg += "1 = Busca Pelo Código\n";
		msg += "2 = Busca Pelo Nome\n";
		msg += "3 = Busca Todos os Clientes\n";
		msg += "4 = Salvar Cliente\n";
		
		escolha = Integer.parseInt(JOptionPane.showInputDialog(msg));
		
		switch (escolha) {
		case 1:
			BuscaPeloCodigo a = new BuscaPeloCodigo();
			a.main(args);
			break;
		case 2:
			BuscaPeloNome b = new BuscaPeloNome();
			b.main(args);
			break;
		case 3:
			BuscaTodosClientes c = new BuscaTodosClientes();
			c.main(args);
			break;
		case 4:
			SalvaCliente d = new SalvaCliente();
			d.main(args);
			break;	
		default:
			break;
		}

	}

}
