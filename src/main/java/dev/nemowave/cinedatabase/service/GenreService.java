package dev.nemowave.cinedatabase.service;

import dev.nemowave.cinedatabase.dto.GenreDTO;
import dev.nemowave.cinedatabase.dto.mapper.GenreMapper;
import dev.nemowave.cinedatabase.dto.mapper.MovieMapper;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.model.Genre;
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
    private final MovieMapper movieMapper = MovieMapper.INSTANCE;

    public GenreDTO create(GenreDTO genreDTO) throws DataAlreadyRegisteredException {
        verifyIfALreadRegistered(genreDTO.getName());
        Genre genreToSave = genreMapper.toModel(genreDTO);
        Genre savedGenre = genreRepository.save(genreToSave);
        return genreMapper.toDTO(savedGenre);
    }

    public List<GenreDTO> findaAll() {
        return genreRepository.findAll()
                .stream().map(genreMapper::toDTO).collect(Collectors.toList());
    }

    public GenreDTO findaById(long id) throws RegisterNotFoundException {
        Genre find = genreRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException(id));

        return genreMapper.toDTO(find);
    }

    private void verifyIfALreadRegistered(String name) throws DataAlreadyRegisteredException {
        Optional<Genre> getSavedGenre = genreRepository.findByName(name);

        if (getSavedGenre.isPresent()) {
            throw new DataAlreadyRegisteredException(name);
        }
    }
}
