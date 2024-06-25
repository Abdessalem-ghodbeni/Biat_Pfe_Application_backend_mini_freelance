package com.biat.biat.Services.ServiceImpl;

import com.biat.biat.Entites.Agence;
import com.biat.biat.Entites.Agent;
import com.biat.biat.Repository.IAgenceRepository;
import com.biat.biat.Repository.IAgentRepository;
import com.biat.biat.Services.IServices.IAgenceServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class IAgenceServiceImpl implements IAgenceServices {
private  final IAgenceRepository agenceRepository;
private final IAgentRepository agentRepository;
    @Override

    public Agence AddAgence(Agence agence) {

        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> agenceListe() {
      return agenceRepository.findAll();
    }

    @Override
    @Transactional
    public Agence assignAgentsToAgence(Long agenceId, List<Long> agentIds) throws EntityNotFoundException {
        Agence agence = agenceRepository.findById(agenceId).orElseThrow(() -> new EntityNotFoundException("Agence not found with id: " + agenceId));

        List<Agent> agents = new ArrayList<>();
        for (Long agentId : agentIds) {
            Agent agent = agentRepository.findById(agentId).orElseThrow(() -> new EntityNotFoundException("Agent not found with id: " + agentId));
            agent.setAgence(agence);
            agents.add(agent);
        }

        agence.setAgentList(agents);
        return agenceRepository.save(agence);
    }
}
