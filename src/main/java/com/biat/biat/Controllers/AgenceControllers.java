package com.biat.biat.Controllers;

import com.biat.biat.Entites.Agence;
import com.biat.biat.Entites.Agent;
import com.biat.biat.Exception.RessourceNotFound;
import com.biat.biat.Services.IServices.IAgenceServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/agence")
@RequiredArgsConstructor
public class AgenceControllers {

    private final IAgenceServices agenceServices;

    @GetMapping(path = "/all")
    public ResponseEntity<?> getAllAgences() {

        try {
            List<Agence> agences = agenceServices.agenceListe();
            if (agences.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Liste est vide ");
            }
            return ResponseEntity.ok(agences);
        } catch (RessourceNotFound exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("quelque chose mal passé"+exception.getMessage());
        }}

    @PostMapping(path = "/add")
    public ResponseEntity<?> AjouterNouvelleChambre(@RequestBody Agence agence) {
        try {
            Agence newAgence = agenceServices.AddAgence(agence);
            return new ResponseEntity<>(newAgence, HttpStatus.CREATED);
        } catch (RessourceNotFound exception) {
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{agenceId}/assign-agents")
    public ResponseEntity<?> assignAgentsToAgence(@PathVariable Long agenceId, @RequestBody List<Long> agentIds) {
        try {
            return new ResponseEntity<>(agenceServices.assignAgentsToAgence(agenceId,agentIds),HttpStatus.OK);
        } catch (RessourceNotFound exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{agenceId}/deassign-agents")
    public ResponseEntity<?> dssignAgentsToAgence(@PathVariable Long agenceId, @RequestBody List<Long> agentIds) {
        try {
            return new ResponseEntity<>(agenceServices.dassignAgentsToAgence(agenceId,agentIds),HttpStatus.OK);
        } catch (RessourceNotFound exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("{id}")
    public Agence getAgenceByAgentId(@PathVariable Long id) {
        return agenceServices.getAgenceByAgentId(id);
    }
}
