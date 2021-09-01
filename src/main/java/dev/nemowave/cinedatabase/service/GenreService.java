package dev.nemowave.cinedatabase.service;

import dev.nemowave.cinedatabase.dto.GenreDTO;
import dev.nemowave.cinedatabase.dto.mapper.GenreMapper;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.model.Genre;
import dev.nemowave.cinedatabase.model.Movie;
import dev.nemowave.cinedatabase.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GenreService {

    GenreRepository genreRepository;
    private final GenreMapper genreMapper = GenreMapper.INSTANCE;

    public GenreDTO create(GenreDTO genreDTO) throws DataAlreadyRegisteredException {
        verifyIfAlreadRegistered(genreDTO.getName());
        Genre genreToSave = genreMapper.toModel(genreDTO);
        Genre savedGenre = genreRepository.save(genreToSave);
        return genreMapper.toDTO(savedGenre);
    }

    public List<GenreDTO> findAll() {
        return genreRepository.findAll()
                .stream().map(genreMapper::toDTO).collect(Collectors.toList());
    }

    public void delete(long id) throws RegisterNotFoundException {
        verifyIfExistisById(id);
        genreRepository.deleteById(id);
    }

    private void verifyIfAlreadRegistered(String name) throws DataAlreadyRegisteredException {
        Optional<Genre> getSavedGenre = genreRepository.findByName(name);

        if (getSavedGenre.isPresent()) {
            throw new DataAlreadyRegisteredException(name);
        }
    }

    private Genre verifyIfExistisById(long id) throws RegisterNotFoundException {
        return genreRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException(id));
    }
}
