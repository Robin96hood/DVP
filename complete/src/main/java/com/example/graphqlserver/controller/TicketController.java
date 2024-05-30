package com.example.graphqlserver.controller;

import com.example.graphqlserver.dto.TicketDTO;
import com.example.graphqlserver.entity.Ticket;
import com.example.graphqlserver.entity.Usuario;
import com.example.graphqlserver.exeption.TicketException;
import com.example.graphqlserver.repository.UsuarioRepository;
import com.example.graphqlserver.repository.TicketRepository;
import com.example.graphqlserver.service.impl.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TicketService ticketService;

    public TicketController(TicketRepository ticketRepository, UsuarioRepository usuarioRepository) {
        this.ticketRepository = ticketRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @QueryMapping
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @QueryMapping
    public Ticket getTicketById(@Argument Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    @SchemaMapping
    public Usuario usuario(Ticket ticket) {
        Long usuarioId = ticket.getUsuario().getId();
        Optional<Usuario> usuarioOptional;
        usuarioOptional = usuarioRepository.findById(usuarioId);
        Usuario usuario = new Usuario();
        usuario.setId(usuarioOptional.get().getId());
        usuario.setLogin(usuarioOptional.get().getLogin());
        usuario.setNodeId(usuarioOptional.get().getNodeId());
        usuario.setAvatarUrl(usuarioOptional.get().getAvatarUrl());
        usuario.setGravatarId(usuarioOptional.get().getGravatarId());
        usuario.setUrl(usuarioOptional.get().getUrl());
        usuario.setHtmlUrl(usuarioOptional.get().getHtmlUrl());
        usuario.setFollowersUrl(usuarioOptional.get().getFollowersUrl());
        usuario.setFollowingUrl(usuarioOptional.get().getFollowingUrl());
        usuario.setSubscriptionsUrl(usuarioOptional.get().getSubscriptionsUrl());
        usuario.setOrganizationsUrl(usuarioOptional.get().getOrganizationsUrl());
        usuario.setGistsUrl(usuarioOptional.get().getGistsUrl());
        usuario.setStarredUrl(usuarioOptional.get().getStarredUrl());
        usuario.setReposUrl(usuarioOptional.get().getReposUrl());
        usuario.setEventsUrl(usuarioOptional.get().getEventsUrl());
        usuario.setReceivedEventsUrl(usuarioOptional.get().getReceivedEventsUrl());
        usuario.setType(usuarioOptional.get().getType());
        usuario.setSiteAdmin(usuarioOptional.get().isSiteAdmin());
        usuario.setScore(usuarioOptional.get().getScore());
        return usuario;
    }

    @MutationMapping
    public Ticket addTicket(@Argument TicketDTO ticketDTO) throws TicketException {
        return ticketService.saveTicket(ticketDTO);
    }

    @MutationMapping
    public void deleteTicket(@Argument Long id) throws TicketException {
        ticketService.deleteTicket(id);
    }
    @MutationMapping
    public Ticket updateTicket(@Argument String estado, @Argument Long id) throws TicketException {
        Ticket ticket = ticketService.updateTicket(estado,id);
       return ticket;
    }
}
