package com.example.graphqlserver.service.impl;

import com.example.graphqlserver.dto.TotalCountDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface dataSourceService {
    void loadDataSource() throws JsonProcessingException;
    TotalCountDTO getDataUsuarios() throws JsonProcessingException;
}
