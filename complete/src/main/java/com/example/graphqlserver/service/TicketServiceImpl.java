package com.example.graphqlserver.service;

import com.example.graphqlserver.dto.TicketDTO;
import com.example.graphqlserver.entity.Ticket;
import com.example.graphqlserver.exeption.TicketException;
import com.example.graphqlserver.repository.TicketRepository;
import com.example.graphqlserver.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.graphqlserver.util.Constant.*;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) throws TicketException {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            return ticket.get();
        } else {
            throw new TicketException(ERROR_TICKER_NOT_FOUND_ERROR);
        }
    }

    public Ticket saveTicket(TicketDTO ticketDTO) throws TicketException {

        Ticket ticket = new Ticket();
        ticket.setId(ticketDTO.getId());
        ticket.setUsuario(ticketDTO.getUsuario());
        ticket.setFechaActualizacion(ticketDTO.getFechaActualizacion());
        ticket.setFechaCreacion(ticketDTO.getFechaCreacion());
        ticket.setEstado(ticketDTO.getEstado());
        Ticket optTicket = ticketRepository.save(ticket);
        return optTicket;

    }

    public void deleteTicket(Long id) throws TicketException {
        try {
            ticketRepository.deleteById(id);
        }catch (Exception e){
            throw new TicketException(ERROR_DELETE_TICKET);
        }
    }

    public Ticket updateTicket(String estado, Long id) throws TicketException {

        if (ticketRepository.existsById(id)) {
            Ticket ticket = getTicketById(id);
            TicketDTO ticketDTO = TicketDTO.builder()
                    .id(ticket.getId())
                    .usuario(ticket.getUsuario())
                    .fechaCreacion(ticket.getFechaCreacion())
                    .fechaActualizacion(ticket.getFechaActualizacion())
                    .estado(estado)
                    .build();
            return saveTicket(ticketDTO);
        } else {
            throw new TicketException(ERROR_UPDATE_TICKET);
        }
    }
}
