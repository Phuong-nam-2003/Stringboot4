package com.example.assignmentspringsecurity.service;

import com.example.assignmentspringsecurity.entity.Ticket;

import java.util.List;

public interface TicketService {
    public List<Ticket> findAll();
    public Ticket findById(int theId);
    public void save(Ticket theTicket);
    public void deleteById(int theId);

}
