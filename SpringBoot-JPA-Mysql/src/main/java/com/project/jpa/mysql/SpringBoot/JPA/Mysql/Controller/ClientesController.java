package com.project.jpa.mysql.SpringBoot.JPA.Mysql.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jpa.mysql.SpringBoot.JPA.Mysql.Model.Cliente;
import com.project.jpa.mysql.SpringBoot.JPA.Mysql.Repository.Clientes;


@RestController
@RequestMapping("api/JPA/Mysql/clientes")
public class ClientesController {
	
	@Autowired
	private Clientes clientes;

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		Optional<Cliente> cliente = clientes.findById(id);
		if(cliente != null) {
			clientes.deleteById(id);
		}
		return ResponseEntity.noContent().build();
	}
}