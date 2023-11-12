package br.com.material.web.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.material.dao.MaterialDAO;
import br.com.material.model.Material;

@Controller
public class WelcomeController {
	
		@Autowired
		private MaterialDAO dao;
	
	
		@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
		public ModelAndView cadastrar() {
			ModelAndView view = new ModelAndView("welcome");
			return view;
		}
		
		@RequestMapping(value= "/formulario", method= RequestMethod.GET)
		public ModelAndView formulario(Model model) {
			model.addAttribute("material", new Material());
			return new ModelAndView ("formulario");
			
		}
		
		@RequestMapping(value = "/formulario", method= RequestMethod.POST)
		public ModelAndView cmaterial(@ModelAttribute Material material) {
			ModelAndView view = new ModelAndView("formulario");
			view.addObject("mensagem", material.getNome() + " foi cadastrado com sucesso com a quantidade no estoque : " + material.getQuantidade());
			
			return view;
			
		}
		
		@RequestMapping(value="/cadastro", method= RequestMethod.POST )
		public ModelAndView cadastrarMaterial(@ModelAttribute Material material) {
			
			
			
			dao.salvar(material);
			
			ModelAndView view = new ModelAndView("formulario");
			view.addObject("mensagem"," Material Cadastrado com sucesso!");
			view.addObject("materiais", dao.getAll());
			return view;
			
		}
		@GetMapping(value="/cadastro")
		public ModelAndView retornarAposExcluir(@ModelAttribute Material material) {
			
			
			
			
			ModelAndView view = new ModelAndView("formulario");
			view.addObject("mensagem"," Material Cadastrado com sucesso!");
			view.addObject("materiais", dao.getAll());
			return view;
			
		}
		
		@GetMapping(value="/excluir/{id}")
		public String excluirMaterial(@PathVariable("id")int id, Model model) {
			dao.excluir(id);
			
			
			return "redirect:../cadastro";
		}
		
		@GetMapping(value= "/editar/{id}")
		public ModelAndView editarMaterial(@PathVariable("id") int id, Model model) {
			
			ModelAndView view = new ModelAndView("editar");
					model.addAttribute("material", dao.getId(id));
			
			return view;
		}
		
		@PostMapping(value= "/update/{id}")
		public String updateMaterial(@PathVariable("id")int id, @ModelAttribute Material material) {
			dao.editar(id, material);
			return "redirect:../cadastro";
		}
		
		@GetMapping(value = "/produtos-mais-caros")
	    public ModelAndView produtosMaisCaros() {
	        List<Material> materiais = dao.getAll();
	        
	        Collections.sort(materiais, (p1, p2) -> Double.compare(Double.parseDouble(p2.getPreco()), Double.parseDouble(p1.getPreco())));

	        ModelAndView view = new ModelAndView("produtosMaisCaros");
	        view.addObject("materiais", materiais);
	        return view;
	    }

}

