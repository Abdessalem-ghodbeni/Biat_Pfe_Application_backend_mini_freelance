package com.biat.biat.Services.IServices;

import com.biat.biat.Entites.Agent;

import java.util.List;

public interface IAgentServices {

    List<Agent>GettAllAgent();
    void removeAgent(long idAgent);
    Agent updateAgent(Agent agent);
}
