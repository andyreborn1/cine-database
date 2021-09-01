package dev.nemowave.cinedatabase.service;

import dev.nemowave.cinedatabase.dto.DirectorDTO;
import dev.nemowave.cinedatabase.dto.mapper.DirectorMapper;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.model.Director;
import dev.nemowave.cinedatabase.repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DirectorService {
    private final DirectorRepository directorRepository;
    private static final DirectorMapper directorMapper = DirectorMapper.INSTANCE;

    public DirectorDTO create(DirectorDTO directorDTO) throws DataAlreadyRegisteredException {
        verifyIfAlreadyRegistered(directorDTO.getName());
        Director directorToSave = directorMapper.toModel(directorDTO);
        Director savedDirector = directorRepository.save(directorToSave);
        return directorMapper.toDTO(savedDirector);
    }

    public List<DirectorDTO> findAll() {
        return directorRepository.findAll()
                .stream().map(directorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(long id) throws RegisterNotFoundException {
        verifyIfExistsById(id);
        directorRepository.deleteById(id);
    }

    public DirectorDTO update(long id, DirectorDTO directorDTO) throws RegisterNotFoundException {
        verifyIfExistsById(id);
        Director directorToUpdate = directorMapper.toModel(directorDTO);
        Director updatedDirector = directorRepository.save(directorToUpdate);
        return directorMapper.toDTO(updatedDirector);
    }

    private void verifyIfAlreadyRegistered(String name) throws DataAlreadyRegisteredException {
        Optional<Director> getSavedDirector = directorRepository.findByName(name);

        if (getSavedDirector.isPresent()) {
            throw new DataAlreadyRegisteredException(name);
        }
    }

    private Director verifyIfExistsById(long id) throws RegisterNotFoundException {
        return directorRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException(id));
    }
}
