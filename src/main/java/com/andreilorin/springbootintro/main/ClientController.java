package com.andreilorin.springbootintro.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/clients")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}
	
	@RequestMapping("/clients/{id}")
	public Client getClient(@PathVariable int id) {
		return clientService.getClient(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/clients")
	public void addClient(@RequestBody Client client) {
		clientService.addClient(client);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/clients/{id}")
	public void updateClient(@RequestBody Client client, @PathVariable int id) {
		clientService.updateClient(id, client);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/clients/{id}")
	public void deleteClient(@PathVariable int id) {
		clientService.deleteClient(id);
	}

}