package com.example.demo.service;

import com.example.demo.model.dto.FieldOfInterestDTO;
import com.example.demo.model.entity.FieldOfInterestEntity;
import com.example.demo.repository.FieldOfInterestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FieldOfInterestService {
    private final FieldOfInterestRepository fieldOfInterestRepository;
    private final ObjectMapper objectMapper;

    public List<FieldOfInterestDTO> getAll() {
        return transformToDto(fieldOfInterestRepository.findAll());
    }

    public FieldOfInterestEntity findByField(String field) throws NoSuchElementException {
        return fieldOfInterestRepository.findByField(field).orElseThrow();
    }

    private List<FieldOfInterestDTO> transformToDto(List<FieldOfInterestEntity> fieldOfInterestEntities) {
        return fieldOfInterestEntities.stream()
                .map(fieldOfInterestEntity -> objectMapper.convertValue(fieldOfInterestEntity, FieldOfInterestDTO.class))
                .collect(Collectors.toList());
    }
}
