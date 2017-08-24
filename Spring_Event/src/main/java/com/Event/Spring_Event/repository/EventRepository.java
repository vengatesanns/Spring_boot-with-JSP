package com.Event.Spring_Event.repository;

import org.springframework.stereotype.Repository;
import com.Event.Spring_Event.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
@Repository
public interface EventRepository extends JpaRepository<Event,Integer>,CrudRepository<Event,Integer>
{
   // @Query("delete from Event e where e.id=:id")
   //    public void deleteById(@Param("id") Long id);
}
