package com.example.graphqlserver.controller;
import com.example.graphqlserver.dto.TicketDTO;
import com.example.graphqlserver.entity.Ticket;
import com.example.graphqlserver.exeption.TicketException;
import com.example.graphqlserver.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dvp/ticket")
public class TicketRestController {
    @Autowired
    private  TicketService ticketService;

    @Autowired
    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public HttpEntity<Object> getTicketById(@PathVariable Long id) {
        try {
            return new HttpEntity(ticketService.getTicketById(id));

        } catch (Exception e) {
            return new HttpEntity("error ticker no encontrado");
        }
    }

    @PostMapping("/new")
    public Ticket saveTicket(@RequestBody TicketDTO ticketDTO) throws TicketException {
        return ticketService.saveTicket(ticketDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) throws TicketException {
        ticketService.deleteTicket(id);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> actualizarRecursoCompleto(@RequestBody String estado, @PathVariable Long id) {
        try{
            return new HttpEntity<>(ticketService.updateTicket(estado, id));
        }catch (Exception e){
            return new HttpEntity<>("error al actualziar") ;
        }
    }
}
