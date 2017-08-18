package com.andreilorin.springbootintro.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	private List<Client> clients = new ArrayList<>(Arrays.asList(
			new Client(1, "Andrei", 100.00),
			new Client(2, "Lorin", 200.00),
			new Client(3, "andreilorin", 300.00)
			));
	
	public List<Client> getAllClients() {
		return clients;
	}
	
	public Client getClient(int id) {
		return clients.stream().filter(t -> t.getId() == id).findFirst().get();
	}
	
	public void addClient(Client client) {
		clients.add(client);
	}

	public void updateClient(int id, Client client) {
		for(int i = 0; i < clients.size(); i++) {
			Client c = clients.get(i);
			if(c.getId() == id) {
				clients.set(i, client);
				return;
			}
		}
	}

	public void deleteClient(int id) {
		clients.removeIf(t -> t.getId() == id);
	}

}
