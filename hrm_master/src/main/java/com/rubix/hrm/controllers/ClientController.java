package com.rubix.hrm.controllers;

import java.util.List;
import java.util.Optional;

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

import com.rubix.hrm.models.Client;
import com.rubix.hrm.services.ClientService;

/* *@author  Muruganandham
* @version 1.0
*
*/
@RestController
@RequestMapping("/hrm/client")

public class ClientController {
	@Autowired
	private ClientService clientService;

	@PostMapping
	public String saveClient(@RequestBody Client client) {
		Optional<Client> clientDb = clientService.create(client);
		if (clientDb.isPresent()) {
			return "The client data has been saved successfully!";
		} else {
			return "client data already exist in records";
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id")Long id) {
		Optional<Client> cli = clientService.retrieveOne(id);
		if (cli.isPresent()) {
			return new ResponseEntity<>(cli.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public List<Client> getALLClient() {
		return clientService.retrieve();
	}

	@PutMapping
	public String updateClient(@RequestBody Client client) {
		Optional<Client> cli = clientService.update(client);
		if (cli.isEmpty()) {
			return "The Client data does not exist in records!";
		} else {
			return "The Client data has been updated successfully!";
		}
	}

	@DeleteMapping("/{id}")
	public String deleteClientById(@PathVariable("id")Long id) {
		return clientService.delete(id);
	}

}
