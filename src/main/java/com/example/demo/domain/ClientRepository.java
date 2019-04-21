package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.id = ?1")
    Client findClient(long id);
}
