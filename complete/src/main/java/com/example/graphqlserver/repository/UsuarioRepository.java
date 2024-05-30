package com.example.graphqlserver.repository;

import com.example.graphqlserver.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}