package com.rubix.hrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubix.hrm.models.Client;
import com.rubix.hrm.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public Optional<Client> create(Client client) {	
			return Optional.of(clientRepository.save(client));
	}

	public List<Client> retrieve() {
		return clientRepository.findAll();
	}

	public Optional<Client> retrieveOne(Long clientId) {
		return clientRepository.findById(clientId);
	}

	public Optional<Client> update(Client cli) {
		if (clientRepository.existsById((cli.getClientId()))) {
			return Optional.of(clientRepository.save(cli));
		} else {
			return Optional.empty();
		}
	}

	public String delete(Long clientId) {
		if (clientRepository.existsById(clientId)) {
			clientRepository.deleteById(clientId);
			return clientId + " deleted successfully!";
		} else {
			return "The client data does not exist in records!";
		}
	}

}
