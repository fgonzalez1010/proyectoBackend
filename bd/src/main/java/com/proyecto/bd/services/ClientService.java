package com.proyecto.bd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.bd.entities.Sale;
import com.proyecto.bd.entities.UserClient;
import com.proyecto.bd.repository.ClientRepository;
import com.proyecto.bd.repository.SaleRepository;

@Service
public class ClientService {

     private final ClientRepository clientRepository;
     private final SaleRepository saleRepository;

    public ClientService(ClientRepository clientRepository, SaleRepository saleRepository) {
        this.clientRepository = clientRepository;
        this.saleRepository = saleRepository;
    }

    public List<UserClient> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<UserClient> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Sale> getSalesByClientId(Long clientId) {
        return saleRepository.findByUserClient_ClientId(clientId);
    }
    public UserClient createClient(UserClient client) {
        return clientRepository.save(client);
    }

    public UserClient updateClient(Long id, UserClient updatedClient) {
        return clientRepository.findById(id)
                .map(existingClient -> {
                    existingClient.setName(updatedClient.getName());
                    existingClient.setEmail(updatedClient.getEmail());
                    existingClient.setPassword(updatedClient.getPassword());
                    existingClient.setAddress(updatedClient.getAddress());
                    return clientRepository.save(existingClient);
                }).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }

    public void deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Brand not found with id: " + id);
        }
    }
}
