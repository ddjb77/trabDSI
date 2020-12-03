package com.aula;

//import java.util.List;//
//import java.util.Map;//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.model.Produto;
import com.aula.model.ProdutoService;



@Controller
public class ProdutoController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/produto")
	public String cadastrar(Model model) {
		model.addAttribute("prod",new Produto());
		return "formprod";
	}
	
	@PostMapping("/produto")
	public String acao(@ModelAttribute Produto prod,Model model) {
		model.addAttribute("prod",prod);
		ProdutoService pdao = context.getBean(ProdutoService.class);
		pdao.insert(prod);
		return "produtosucesso";
	}
	
}
