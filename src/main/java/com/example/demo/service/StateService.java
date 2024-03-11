package com.example.demo.service;

import com.example.demo.model.dto.StateDTO;
import com.example.demo.model.entity.StateEntity;
import com.example.demo.repository.StateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateService {
    private final StateRepository stateRepository;
    private final ObjectMapper objectMapper;

    public List<StateDTO> getAll() {
        return transformToDto(stateRepository.findAll());
    }

    private List<StateDTO> transformToDto(List<StateEntity> stateEntities) {

        return stateEntities.stream()
                .map(stateEntity -> objectMapper.convertValue(stateEntity, StateDTO.class )).collect(Collectors.toList());
    }

    public Optional<StateEntity> findStateByName(String name) {
        return stateRepository.findByName(name);
    }
}
