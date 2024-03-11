package com.example.demo.service;

import com.example.demo.model.dto.CityDTO;
import com.example.demo.model.entity.CityEntity;
import com.example.demo.model.entity.StateEntity;
import com.example.demo.repository.CityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final StateService stateService;
    private final ObjectMapper objectMapper;

    public List<CityDTO> findAllByStateName(String name) throws NoSuchElementException {
        Optional<StateEntity> stateEntity = stateService.findStateByName(name);
        return transformToDto(cityRepository.findAllByStateEntity(stateEntity.orElseThrow()));
    }

    public CityEntity findByName(String name) throws NoSuchElementException {
        return cityRepository.findByName(name).orElseThrow();
    }

    private List<CityDTO> transformToDto(Optional<List<CityEntity>> cityEntities) throws NoSuchElementException {
        return cityEntities.orElseThrow().stream().map(cityEntity -> objectMapper.convertValue(cityEntity, CityDTO.class)).collect(Collectors.toList());
    }
}
