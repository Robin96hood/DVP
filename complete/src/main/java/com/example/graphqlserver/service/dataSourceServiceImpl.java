package com.example.graphqlserver.service;
import com.example.graphqlserver.dto.TotalCountDTO;
import com.example.graphqlserver.entity.Usuario;
import com.example.graphqlserver.repository.UsuarioRepository;
import com.example.graphqlserver.service.impl.dataSourceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableScheduling
@Service
public class dataSourceServiceImpl implements dataSourceService {

    private final String API_URL = "https://api.github.com/search/users?q=YOUR_NAME";
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuariosRepository;

    @Scheduled(initialDelay = 1)
    @Override
    public void loadDataSource() throws JsonProcessingException {
        System.out.println("Ejecutando tarea");
        TotalCountDTO dataUsuarios = getDataUsuarios();
        List<Usuario> usuariosEntidadList = dataUsuarios.getItems().stream()
                .map(usuarioDto -> {
                    Usuario usuarioEntidad = new Usuario();
                    usuarioEntidad.setId(usuarioDto.getId());
                    usuarioEntidad.setLogin(usuarioDto.getLogin());
                    usuarioEntidad.setNodeId(usuarioDto.getNodeId());
                    usuarioEntidad.setAvatarUrl(usuarioDto.getAvatarUrl());
                    usuarioEntidad.setGravatarId(usuarioDto.getGravatarId());
                    usuarioEntidad.setUrl(usuarioDto.getUrl());
                    usuarioEntidad.setHtmlUrl(usuarioDto.getHtmlUrl());
                    usuarioEntidad.setFollowersUrl(usuarioDto.getFollowersUrl());
                    usuarioEntidad.setFollowingUrl(usuarioDto.getFollowingUrl());
                    usuarioEntidad.setGistsUrl(usuarioDto.getGistsUrl());
                    usuarioEntidad.setStarredUrl(usuarioDto.getStarredUrl());
                    usuarioEntidad.setSubscriptionsUrl(usuarioDto.getSubscriptionsUrl());
                    usuarioEntidad.setOrganizationsUrl(usuarioDto.getOrganizationsUrl());
                    usuarioEntidad.setReposUrl(usuarioDto.getReposUrl());
                    usuarioEntidad.setEventsUrl(usuarioDto.getEventsUrl());
                    usuarioEntidad.setReceivedEventsUrl(usuarioDto.getReceivedEventsUrl());
                    usuarioEntidad.setType(usuarioDto.getType());
                    usuarioEntidad.setSiteAdmin(usuarioDto.isSiteAdmin());
                    usuarioEntidad.setScore(usuarioDto.getScore());
                    return usuarioEntidad;
                })
                .toList();
        usuariosEntidadList.forEach(usuarioEntidad -> usuariosRepository.save(usuarioEntidad));
    }

    public TotalCountDTO getDataUsuarios() throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class);
        TotalCountDTO dataUsuarios = this.objectMapper.readValue(response.getBody(), TotalCountDTO.class);
        return dataUsuarios;
    }

}
