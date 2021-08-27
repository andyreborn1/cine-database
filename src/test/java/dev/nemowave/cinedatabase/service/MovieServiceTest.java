package dev.nemowave.cinedatabase.service;

import dev.nemowave.cinedatabase.builder.MovieDTOBuilder;
import dev.nemowave.cinedatabase.dto.MovieDTO;
import dev.nemowave.cinedatabase.dto.mapper.MovieMapper;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.model.Movie;
import dev.nemowave.cinedatabase.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    private MovieMapper movieMapper = MovieMapper.INSTANCE;

    @InjectMocks
    private MovieService movieService;

    @Test
    void whenMovieInformedThenShouldBeCreated() throws DataAlreadyRegisteredException {

        //given
        MovieDTO movieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        Movie expectedSavedMovie = movieMapper.toModel(movieDTO);

        //when
        when(movieRepository.findByTitle(movieDTO.getTitle())).thenReturn(Optional.empty());
        when(movieRepository.save(expectedSavedMovie)).thenReturn(expectedSavedMovie);

        //then
        MovieDTO createdMovieDTO = movieService.create(movieDTO);

        assertEquals(movieDTO.getId(),createdMovieDTO.getId());
        assertEquals(movieDTO.getTitle(), createdMovieDTO.getTitle());
    }
}
