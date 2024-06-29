package com.biat.biat.Controllers;

import com.biat.biat.Entites.Agence;
import com.biat.biat.Entites.Agent;
import com.biat.biat.Entites.Compte;
import com.biat.biat.Entites.TypeCompte;
import com.biat.biat.Exception.RessourceNotFound;
import com.biat.biat.Services.IServices.ICompteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/compte")
@RequiredArgsConstructor
public class CompteController {
private final ICompteServices compteServices;

    @GetMapping(path = "/all/{idAgence}")
    public ResponseEntity<?> getAllAgentByAgence(@PathVariable("idAgence")Long idAgence) {

        try {
            List<Compte> comptes = compteServices.getAllAcoutByAgence(idAgence);
            if (comptes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Liste est vide ");
            }
            return ResponseEntity.ok(comptes);
        } catch (RessourceNotFound exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("quelque chose mal passé"+exception.getMessage());
        }
    }
    @PostMapping(path = "/add")
    public ResponseEntity<?> AjouterCompte(@RequestBody Compte compte) {
        try {
            return new ResponseEntity<>(compteServices.ajouterCompte(compte), HttpStatus.CREATED);
        } catch (RessourceNotFound exception) {
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path = "/all")
    public ResponseEntity<?> getAll() {

        try {
            List<Compte> comptes = compteServices.getAllAcout();
            if (comptes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Liste est vide ");
            }
            return ResponseEntity.ok(comptes);
        } catch (RessourceNotFound exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("quelque chose mal passé"+exception.getMessage());
        }
    }

    @GetMapping("/type/{clientId}")
    public ResponseEntity<TypeCompte> getTypeCompteByClientId(@PathVariable Long clientId) {
        try {
            TypeCompte typeCompte = compteServices.getTypeCompteByClientId(clientId);
            return ResponseEntity.ok(typeCompte);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

}
