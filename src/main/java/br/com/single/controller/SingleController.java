package br.com.single.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.single.beans.Single;
import br.com.single.dao.SingleDAO;

@RestController
public class SingleController {
	
	@Autowired //Criando o objeto automaticamente.
	private SingleDAO dao;
	
	//método para achar todos os dados do BD.
	@GetMapping("/single")
	public ResponseEntity<List<Single>> getAll(){ 
		
		List<Single> list = (List<Single>)dao.findAll();
		if(list.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(list);
		
	}
	//método para achar os dados pelo ID.
	@GetMapping("/single/{id}")
	public ResponseEntity<Single> getSingle(@PathVariable int id){
		Single resp = dao.findById(id).orElse(null);
		
		if(resp == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resp);
	}
	
	//método para inserir os dados no BD.
	@PostMapping("/wolf")
	public ResponseEntity<Single> addSingle(@RequestBody Single objeto){
		try {
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	//método para criar a rota de login
	@PostMapping("/login")
	public ResponseEntity<Single> logar(@RequestBody Single objeto){
		Single resp = dao.findByPatenteAndNome(objeto.getPatente(), objeto.getNome());
		if(resp == null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resp);
	}
}