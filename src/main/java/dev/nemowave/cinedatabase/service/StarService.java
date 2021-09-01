package dev.nemowave.cinedatabase.service;

import dev.nemowave.cinedatabase.dto.StarDTO;
import dev.nemowave.cinedatabase.dto.mapper.StarMapper;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.model.Star;
import dev.nemowave.cinedatabase.repository.StarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StarService {

    private final StarRepository starRepository;
    private static final StarMapper starMapper = StarMapper.INSTANCE;

    public StarDTO create(StarDTO starDTO) throws DataAlreadyRegisteredException {
        verifyIfAlreadyRegistered(starDTO.getName());
        Star starToSave = starMapper.toModel(starDTO);
        Star savedStar = starRepository.save(starToSave);
        return starMapper.toDTO(savedStar);
    }

    public StarDTO update(long id, StarDTO starDTO) throws RegisterNotFoundException {
        verifyIfExists(id);
        Star starToUpdate = starMapper.toModel(starDTO);
        Star updatedStar = starRepository.save(starToUpdate);
        return starMapper.toDTO(updatedStar);
    }

    public List<StarDTO> findAll() {
        return starRepository.findAll()
                .stream().map(starMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(long id) throws RegisterNotFoundException {
        verifyIfExists(id);
        starRepository.deleteById(id);
    }

    private void verifyIfAlreadyRegistered(String name) throws DataAlreadyRegisteredException {
        Optional<Star> getSavedStar = starRepository.findByName(name);

        if (getSavedStar.isPresent()) {
            throw new DataAlreadyRegisteredException(name);
        }
    }

    private Star verifyIfExists(long id) throws RegisterNotFoundException {
        return starRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException(id));
    }
}
