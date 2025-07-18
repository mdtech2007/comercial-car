package com.md.car.parameters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.md.car.parameters.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
