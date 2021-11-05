package br.com.single.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.single.beans.Single;
import br.com.single.dao.SingleDAO;

@RestController
public class SingleController {
	
	@Autowired //Criando o objeto automaticamente.
	private SingleDAO dao;
	
	@GetMapping("/single")
	public ResponseEntity<List<Single>> getAll(){ 
		
		List<Single> list = (List<Single>)dao.findAll();
		return ResponseEntity.ok(list);
		
	}
	
}
