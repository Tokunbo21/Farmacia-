package com.Farmacia.Saude.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Farmacia.Saude.Model.Produto;
import com.Farmacia.Saude.Repository.ProdutoRepository;

@RestController
@RequestMapping ("/remedio")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAllProduto(){
		return ResponseEntity.status(200).body(repository.findAll());
	}
   @GetMapping("/{id}")
   public ResponseEntity<Produto> GetById(@PathVariable long id){
	   return repository.findById(id).map(respo-> ResponseEntity.ok(respo)).orElse(ResponseEntity.notFound().build());
   }
   @GetMapping("/remedio/{remedio}")
   public ResponseEntity<List<Produto>> GetByNomeproduto(@PathVariable String nomeproduto){
	   return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nomeproduto));
   }
   @PostMapping 
   public ResponseEntity<Produto> post(@RequestBody Produto produto) {
	   return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
   }
   @PutMapping 
   public ResponseEntity<Produto> put(@RequestBody Produto produto) {
	   return ResponseEntity.ok(repository.save(produto));
   }
    @DeleteMapping ("/{id}")
    public void delete(@PathVariable long id) {
    	repository.deleteById(id);
    }
}
