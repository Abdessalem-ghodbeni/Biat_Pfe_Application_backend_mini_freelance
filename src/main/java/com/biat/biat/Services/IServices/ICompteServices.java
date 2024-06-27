package com.biat.biat.Services.IServices;

import com.biat.biat.Entites.Compte;

import java.util.List;

public interface ICompteServices {
     List<Compte> getAllAcoutByAgence(Long idAgence);
    Compte ajouterCompte(Compte compte);
    List<Compte> getAllAcout();
}
