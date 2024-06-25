package com.biat.biat.Services.ServiceImpl;

import com.biat.biat.Entites.Agent;
import com.biat.biat.Exception.RessourceNotFound;
import com.biat.biat.Repository.IAgentRepository;
import com.biat.biat.Services.IServices.IAgentServices;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class IAgentServicesImpl implements IAgentServices {
    private final IAgentRepository agentRepository;
    @Override
    public List<Agent> GettAllAgent() {
       return agentRepository.findAll();
    }

    @Override
    public void removeAgent(long idAgent) {
        Optional<Agent> AgentToDeletedExisting = agentRepository.findById(idAgent);
        if (AgentToDeletedExisting.isPresent()) {
            agentRepository.deleteById(idAgent);
        } else {
            throw new RessourceNotFound("agent non trouve avec id " + idAgent);
        }

    }

    @Override
    public Agent updateAgent(Agent agent) {
        return null;
    }

    @Override
    @Transactional
    public Agent dassignAgentFromAgence(Long agentId) {
       Agent agent = agentRepository.findById(agentId).orElseThrow(() -> new EntityNotFoundException("Agent not found with id: " + agentId));
        agent.setAgence(null);
        return agentRepository.save(agent);
    }
}
