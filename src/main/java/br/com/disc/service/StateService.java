package br.com.disc.service;

import br.com.disc.model.dto.StateDTO;
import br.com.disc.model.entity.IBGEState;
import br.com.disc.model.entity.StateEntity;
import br.com.disc.repository.StateRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateService {
    private static final String IBGE_STATES_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
    private final StateRepository stateRepository;
    private final ObjectMapper objectMapper;

    public List<StateDTO> getAll() {
        return transformToDto(stateRepository.findAll());
    }

    public void updateDataBase() {
        RestTemplate restTemplate = new RestTemplate();

        List<IBGEState> ibgeStatesResponse = restTemplate.exchange(
                IBGE_STATES_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<IBGEState>>() {}).getBody();

        List<StateEntity> stateEntities = ibgeStatesResponse
                .stream()
                .sorted(Comparator.comparing(IBGEState::getId))
                .map(ibgeState -> StateEntity
                        .builder()
                        .ibgeId(ibgeState.getId())
                        .name(ibgeState.getName())
                        .build())
                .collect(Collectors.toList());

        stateRepository.saveAll(stateEntities);
    }

    public List<StateEntity> getAllStatesEntities() {
        return stateRepository.findAll();
    }

    private List<StateDTO> transformToDto(List<StateEntity> stateEntities) {

        return stateEntities.stream()
                .map(stateEntity -> objectMapper.convertValue(stateEntity, StateDTO.class )).collect(Collectors.toList());
    }

    public Optional<StateEntity> findStateByName(String name) {
        return stateRepository.findByName(name);
    }
}
