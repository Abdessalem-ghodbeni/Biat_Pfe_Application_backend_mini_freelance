package com.biat.biat.Repository;

import com.biat.biat.Entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client,Long> {
}
