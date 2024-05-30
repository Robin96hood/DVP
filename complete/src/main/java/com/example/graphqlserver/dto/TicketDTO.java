package com.example.graphqlserver.dto;

import com.example.graphqlserver.entity.Usuario;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDTO {
    private Long id;
    private Usuario usuario;
    private String fechaCreacion;
    private String fechaActualizacion;
    private String estado;
}
