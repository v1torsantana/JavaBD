package br.com.fiap.rh.conexao;

import java.util.Properties;

public class PropriedadeConexao {
	
	public static Properties getProperties() {
		Properties prop = new Properties();
		prop.put("user", "pf2012");
		prop.put("password", "fiap24");
		return prop;
	}

}
