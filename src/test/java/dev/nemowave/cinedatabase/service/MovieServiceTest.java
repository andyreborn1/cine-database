package dev.nemowave.cinedatabase.service;

import dev.nemowave.cinedatabase.builder.MovieDTOBuilder;
import dev.nemowave.cinedatabase.dto.MovieDTO;
import dev.nemowave.cinedatabase.dto.mapper.MovieMapper;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.model.Movie;
import dev.nemowave.cinedatabase.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
        MovieDTO expectedMovieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        Movie expectedSavedMovie = movieMapper.toModel(expectedMovieDTO);

        //when
        when(movieRepository.findByTitle(expectedMovieDTO.getTitle())).thenReturn(Optional.empty());
        when(movieRepository.save(expectedSavedMovie)).thenReturn(expectedSavedMovie);

        //then
        MovieDTO createdMovieDTO = movieService.create(expectedMovieDTO);

        assertThat(createdMovieDTO.getId(), is(equalTo(expectedMovieDTO.getId())));
        assertThat(createdMovieDTO.getTitle(), is(equalTo(expectedMovieDTO.getTitle())));
    }

    @Test
    void whenAlreadRegisteredMovieInformedShoulThrownException() {
        //given
        MovieDTO expectedMovieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        Movie registeredMovie = movieMapper.toModel(expectedMovieDTO);

        //when
        when(movieRepository.findByTitle(expectedMovieDTO.getTitle())).thenReturn(Optional.of(registeredMovie));

        assertThrows(DataAlreadyRegisteredException.class, () -> movieService.create(expectedMovieDTO));
    }

    @Test
    void whenAValidMovieNameIsGivenThenReturnAMovie() throws RegisterNotFoundException {
        //given
        MovieDTO expectedMovieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        Movie expectedFoundMovie = movieMapper.toModel(expectedMovieDTO);

        //when
        when(movieRepository.findByTitle(expectedMovieDTO.getTitle())).thenReturn(Optional.of(expectedFoundMovie));

        //then
        MovieDTO foundMovieDTO = movieService.findByName(expectedMovieDTO.getTitle());

        assertThat(foundMovieDTO, is(equalTo(expectedMovieDTO)));
    }

    @Test
    void whenNoRegisteredMovieNameRegisteredThenThrownAnException() throws RegisterNotFoundException {
        //given
        MovieDTO expectedMovieDTO = MovieDTOBuilder.builder().build().toMovieDTO();

        //when
        when(movieRepository.findByTitle(expectedMovieDTO.getTitle())).thenReturn(Optional.empty());

        //then

        assertThrows(RegisterNotFoundException.class, () -> movieService.findByName(expectedMovieDTO.getTitle()));
    }



}
