package com.biat.biat.Services.IServices;

import com.biat.biat.Entites.Agence;
import com.biat.biat.Entites.Agent;

import java.util.List;

public interface IAgenceServices {

     Agence AddAgence (Agence agence);
     List<Agence> agenceListe();
  Agence assignAgentsToAgence(Long agenceId, List<Long> agentIds);
}
