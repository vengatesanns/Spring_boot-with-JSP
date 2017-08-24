package com.Event.Spring_Event.repository;

import org.springframework.stereotype.Repository;
import com.Event.Spring_Event.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AgendaRepository extends JpaRepository<Agenda,Integer>
{
    
}
