package br.com.alura.gerenciador.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alura.gerenciador.Empresa;

public class EmpresaDAO {
	
	private final static Map<Long, Empresa> EMPRESAS = new HashMap<>();
	static {
		 geraIdEAdiciona(new Empresa("Distribuidora"));
		 geraIdEAdiciona(new Empresa("Ferragista"));
		 geraIdEAdiciona(new Empresa("Doceria"));
		 geraIdEAdiciona(new Empresa("Supermecado"));
		 geraIdEAdiciona(new Empresa("PetShop"));
		 geraIdEAdiciona(new Empresa("Banco"));
		 
	}
	
	public Collection<Empresa> buscaPorSimilaridade(String nome){ 
		if(nome == null) { 
			return EMPRESAS.values();
		}
		
		List<Empresa> similares = new ArrayList();
		for(Empresa empresa : EMPRESAS.values()) { 
			if(empresa.getNome().toLowerCase().contains(nome.toLowerCase())) { 
				similares.add(empresa);
			}
		}
		return similares;
	}
	
	public void adiciona(Empresa empresa) { 
		geraIdEAdiciona(empresa);
	}
	
	private static void geraIdEAdiciona(Empresa empresa) { 
		long id = EMPRESAS.size()+11;
		empresa.setId(id);
		EMPRESAS.put(id, empresa);
	}

}
