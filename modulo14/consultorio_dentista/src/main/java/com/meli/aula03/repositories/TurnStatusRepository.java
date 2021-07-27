package com.meli.aula03.repositories;

import com.meli.aula03.entities.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnStatusRepository extends JpaRepository<TurnStatus, Long> {
}