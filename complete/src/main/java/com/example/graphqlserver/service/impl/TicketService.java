package com.example.graphqlserver.service.impl;

import com.example.graphqlserver.dto.TicketDTO;
import com.example.graphqlserver.entity.Ticket;
import com.example.graphqlserver.exeption.TicketException;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id) throws TicketException;
    Ticket saveTicket(TicketDTO ticketDTO) throws TicketException;
    void deleteTicket(Long id) throws TicketException;
    Ticket updateTicket(String estado, Long id) throws TicketException;
}
