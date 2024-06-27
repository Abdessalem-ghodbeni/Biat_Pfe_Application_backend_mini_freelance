package com.biat.biat.Controllers;

import com.biat.biat.Entites.Client;
import com.biat.biat.Exception.RessourceNotFound;
import com.biat.biat.Services.IServices.IClientServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final IClientServices clientServices;
    @GetMapping(path = "/all")
    public ResponseEntity<?> getAll() {

        try {
            List<Client> comptes = clientServices.GetAllClient();
            if (comptes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Liste est vide ");
            }
            return ResponseEntity.ok(comptes);
        } catch (RessourceNotFound exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("quelque chose mal passé"+exception.getMessage());
        }
    }
}
