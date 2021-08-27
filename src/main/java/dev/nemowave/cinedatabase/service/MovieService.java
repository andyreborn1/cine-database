package dev.nemowave.cinedatabase.service;

import dev.nemowave.cinedatabase.dto.MovieDTO;
import dev.nemowave.cinedatabase.dto.mapper.MovieMapper;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.model.Movie;
import dev.nemowave.cinedatabase.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovieService {

    MovieRepository movieRepository;

    private final MovieMapper movieMapper = MovieMapper.INSTANCE;

    public MovieDTO create(MovieDTO movieDTO) throws DataAlreadyRegisteredException {
        verifyIfAlreadRegistered(movieDTO.getTitle());
        Movie movieToSave = movieMapper.toModel(movieDTO);
        Movie savedMovie = movieRepository.save(movieToSave);
        return movieMapper.toDTO(savedMovie);
    }

    public MovieDTO findById(long id) throws RegisterNotFoundException {
        Movie movie = verifyIfExistisById(id);
        return movieMapper.toDTO(movie);
    }

    public MovieDTO findByName(String name) throws RegisterNotFoundException {
        Movie foundMovie = movieRepository.findByTitle(name)
                .orElseThrow(() -> new RegisterNotFoundException(name));
        return movieMapper.toDTO(foundMovie);
    }

    public List<MovieDTO> findAll() {
        return movieRepository.findAll()
                .stream().map(movieMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(long id) throws RegisterNotFoundException {
        Movie movieToDelete = verifyIfExistisById(id);
        movieRepository.deleteById(id);
    }

    private void verifyIfAlreadRegistered(String name) throws DataAlreadyRegisteredException {
        Optional<Movie> optSavedMovie = movieRepository.findByTitle(name);
        if (optSavedMovie.isPresent()) {
            throw new DataAlreadyRegisteredException(name);
        }
    }


    private Movie verifyIfExistisById(long id) throws RegisterNotFoundException {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException(id));
    }
}
