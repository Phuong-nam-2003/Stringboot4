package com.example.assignmentspringsecurity.controller;

import com.example.assignmentspringsecurity.entity.Ticket;
import com.example.assignmentspringsecurity.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService theTicketService){
        ticketService = theTicketService;
    }

    @GetMapping("/list")
    public String listTicket(Model theModel){
        List<Ticket> theTickets = ticketService.findAll();

        theModel.addAttribute("tickets",theTickets);
        return "/tickets/list-tickets";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        // create model attribute to bind form data
        Ticket theTicket = new Ticket();

        theModel.addAttribute("ticket",theTicket);

        return "/tickets/ticket-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("ticketId") int theId, Model theModel){
        //get the employee from the service
        Ticket theTicket = ticketService.findById(theId);

        //set employee as a model attribute ro pre-populate the form
        theModel.addAttribute("ticket",theTicket);
        return "/tickets/ticket-form";
    }

    @PostMapping("/save")
    public String saveTicket(@ModelAttribute("ticket")Ticket theTicket) {

        // save the ticket
        ticketService.save(theTicket);

        //use a redirect to prevent duplicate submissions
        return "redirect:/tickets/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("ticketId")int theId) {


        ticketService.deleteById(theId);


        return "redirect:/tickets/list";
    }

}
