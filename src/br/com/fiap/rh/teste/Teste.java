package br.com.fiap.rh.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.rh.conexao.PropriedadeConexao;
import br.com.fiap.rh.model.Pessoa;

public class Teste {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		
		try {
			
			conn = DriverManager.getConnection(url, PropriedadeConexao.getProperties());
			stmt = conn.createStatement();
			
			if(conn != null) {
				
				String  sql = "INSERT INTO PESSOA(ID, NOME, IDADE) VALUES (3, 'EVANDO', 44)";
				stmt.executeUpdate(sql);
				
				sql = "SELECT * FROM PESSOA";
				ResultSet rs = stmt.executeQuery(sql);
				
				List<Pessoa> listaPessoa = new ArrayList<>();
				while (rs.next()) {
					Pessoa pessoa = new Pessoa();
					System.out.println("O ID da pessoa é: " + rs.getInt("ID"));
					pessoa.setId(rs.getInt("ID"));
					System.out.println("O NOME da pessoa é: " + rs.getString("NOME"));
					pessoa.setNome(rs.getString("NOME"));
					System.out.println("A IDADE da pessoa é: " + rs.getInt("IDADE"));
					pessoa.setIdade(rs.getInt("IDADE"));
					listaPessoa.add(pessoa);
				}
					
				System.out.println("Cadastro efetuado com sucesso.");
				
			}
			
			System.out.println("Conectado no banco de dados");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			stmt.close();
		}
		
		

	}

}
