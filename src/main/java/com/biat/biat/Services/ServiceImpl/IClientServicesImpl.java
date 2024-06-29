package com.biat.biat.Services.ServiceImpl;

import com.biat.biat.Entites.Agence;
import com.biat.biat.Entites.Agent;
import com.biat.biat.Entites.Client;
import com.biat.biat.Exception.RessourceNotFound;
import com.biat.biat.Repository.IClientRepository;
import com.biat.biat.Services.IServices.IClientServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class IClientServicesImpl  implements IClientServices {
    private final IClientRepository clientRepository;

    @Override
    public Client getClientById(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> GetAllClient() {
        return clientRepository.findAll();
    }
    @Override
    public void removeClient(long id) {
        Optional<Client> AgentToDeletedExisting = clientRepository.findById(id);
        if (AgentToDeletedExisting.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new RessourceNotFound("agent non trouve avec id " + id);
        }
    }
    public Agent findAgentByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
        return client.getCompte().getAgent();
    }

    public Agence findAgenceByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id: " + clientId));
        return client.getCompte().getAgence();
    }

}
