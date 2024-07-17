package br.com.disc.service;

import br.com.disc.model.dto.EducationLevelDTO;
import br.com.disc.model.entity.EducationLevelEntity;
import br.com.disc.repository.EducationLevelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationLevelService {
    private final EducationLevelRepository educationLevelRepository;
    private final ObjectMapper objectMapper;

    public List<EducationLevelDTO> findAll() {
        return transformToDto(educationLevelRepository.findAll());
    }

    public EducationLevelEntity findByEducationLevel(String educationLevel) throws NoSuchElementException {
        return educationLevelRepository.findByEducationLevel(educationLevel).orElseThrow();
    }

    private List<EducationLevelDTO> transformToDto(List<EducationLevelEntity> educationLevelEntities) {
        return educationLevelEntities.stream()
                .map(educationLevelEntity -> objectMapper.convertValue(educationLevelEntity, EducationLevelDTO.class))
                .collect(Collectors.toList());
    }
}
