package com.biat.biat.Services.ServiceImpl;

import com.biat.biat.Entites.Agence;
import com.biat.biat.Entites.Agent;
import com.biat.biat.Entites.Client;
import com.biat.biat.Entites.Compte;
import com.biat.biat.Repository.IAgenceRepository;
import com.biat.biat.Repository.IAgentRepository;
import com.biat.biat.Repository.IClientRepository;
import com.biat.biat.Repository.ICompteRepository;
import com.biat.biat.Services.IServices.ICompteServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ICompteServicesImp implements ICompteServices {
    private final ICompteRepository compteRepository;
    private final IAgentRepository agentRepository;
    private final IAgenceRepository agenceRepository;
    private final IClientRepository clientRepository;

    @Override
    public List<Compte> getAllAcoutByAgence(Long idAgence) {
        return compteRepository.findByAgence_Id(idAgence);
    }

    @Override
    @Transactional
    public Compte ajouterCompte(Compte compte) {

        Optional<Client> clientOpt = clientRepository.findById(compte.getClient().getId());
        Optional<Agent> agentOpt = agentRepository.findById(compte.getAgent().getId());
        Optional<Agence> agenceOpt = agenceRepository.findById(compte.getAgence().getId());

        if (clientOpt.isPresent() && agentOpt.isPresent() && agenceOpt.isPresent()) {
            // Affecter le client, l'agent et l'agence au compte
            compte.setClient(clientOpt.get());
            compte.setAgent(agentOpt.get());
            compte.setAgence(agenceOpt.get());

            // Enregistrer le compte dans la base de données
            return compteRepository.save(compte);
        } else {
            throw new RuntimeException("Client, Agent, or Agence not found");
        }
    }

    @Override
    public List<Compte> getAllAcout() {
        return compteRepository.findAll();
    }
}
