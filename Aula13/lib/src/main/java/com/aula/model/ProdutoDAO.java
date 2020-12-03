package com.aula.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class ProdutoDAO extends JdbcDaoSupport{
	@Autowired 
    DataSource dataSource;
        
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    
    public void insert(Produto prod) {
        String sql = "INSERT INTO produto " +
    "(nome,preco) VALUES (?,?)" ;
        getJdbcTemplate().update(sql, new Object[]{
        		prod.getNome(), prod.getPreco()
        });
    }
}