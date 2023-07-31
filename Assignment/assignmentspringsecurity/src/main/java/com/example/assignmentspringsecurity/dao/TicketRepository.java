package com.example.assignmentspringsecurity.dao;

import com.example.assignmentspringsecurity.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    public List<Ticket> findAll();


}
