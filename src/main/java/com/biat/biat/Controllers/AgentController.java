package com.biat.biat.Controllers;

import com.biat.biat.Entites.Agent;
import com.biat.biat.Exception.RessourceNotFound;
import com.biat.biat.Services.IServices.IAgentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/agent")
@RequiredArgsConstructor
public class AgentController {

private final IAgentServices agentServices;
    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllAgent() {

        try {
            List<Agent> Agents = agentServices.GettAllAgent();
            if (Agents.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Liste est vide ");
            }
            return ResponseEntity.ok(Agents);
        } catch (RessourceNotFound exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("quelque chose mal passé"+exception.getMessage());
        }
    }

    @DeleteMapping(path = "/supprimer/{id}")
    public ResponseEntity<String> SupprimerAgent(@PathVariable("id") long agentId) {
        try {
            agentServices.removeAgent(agentId);
            return ResponseEntity.ok("agent deleted Successfuly");
        } catch (RessourceNotFound e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }


    }


}
