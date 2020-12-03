package com.aula.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	  @Autowired 
	  ProdutoDAO pdao;
	  
	  public void insert(Produto prod) {
	    pdao.insert(prod);
	  }
}