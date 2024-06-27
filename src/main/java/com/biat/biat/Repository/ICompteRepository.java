package com.biat.biat.Repository;

import com.biat.biat.Entites.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICompteRepository extends JpaRepository<Compte,Long> {
    List<Compte> findByAgence_Id(Long idAgence);
}