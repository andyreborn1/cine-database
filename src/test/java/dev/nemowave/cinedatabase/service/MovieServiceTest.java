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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    private final MovieMapper movieMapper = MovieMapper.INSTANCE;

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
    void whenNoRegisteredMovieNameIsGivendThenThrownAnException() {
        //given
        MovieDTO expectedMovieDTO = MovieDTOBuilder.builder().build().toMovieDTO();

        //when
        when(movieRepository.findByTitle(expectedMovieDTO.getTitle())).thenReturn(Optional.empty());

        //then

        assertThrows(RegisterNotFoundException.class, () -> movieService.findByName(expectedMovieDTO.getTitle()));
    }

    @Test
    void whenListMovieIsCalledThenReturnAListOfMovies() {
        //given
        MovieDTO expectedMovieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        Movie expectedFoundMovie = movieMapper.toModel(expectedMovieDTO);

        //when
        when(movieRepository.findAll()).thenReturn(Collections.singletonList(expectedFoundMovie));

        //then
        List<Movie> foundMovieDTO = movieRepository.findAll();

        assertThat(foundMovieDTO, is(not(empty())));
        assertThat(foundMovieDTO.get(0), is(equalTo(expectedFoundMovie)));
    }

    @Test
    void whenListMovieIsCalledThenReturnAnEmptyList() {
        //when
        when(movieRepository.findAll()).thenReturn(Collections.EMPTY_LIST);

        //then
        List<Movie> foundMovieDTO = movieRepository.findAll();

        assertThat(foundMovieDTO, is(empty()));
    }

    @Test
    void whenExclusionWithAValidIdIsCalledThenAMovieShouldBeRemoved() throws RegisterNotFoundException {
        //given
        MovieDTO expectedMovieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        Movie expectedFoundMovie = movieMapper.toModel(expectedMovieDTO);

        //when
        when(movieRepository.findById(expectedMovieDTO.getId())).thenReturn(Optional.of(expectedFoundMovie));
        doNothing().when(movieRepository).deleteById(expectedMovieDTO.getId());

        //then
        movieService.deleteById(expectedMovieDTO.getId());

        verify(movieRepository, times(1)).findById(expectedMovieDTO.getId());
        verify(movieRepository, times(1)).deleteById(expectedMovieDTO.getId());
    }

    @Test
    void whenExclusionWithoutAValidIdIsCalledThenAErrorShouldBeThrown() throws RegisterNotFoundException {
        //given
        MovieDTO expectedMovieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        Movie expectedFoundMovie = movieMapper.toModel(expectedMovieDTO);

        //when
        when(movieRepository.findById(expectedMovieDTO.getId())).thenReturn(Optional.empty());

        //then
        assertThrows(RegisterNotFoundException.class, () -> movieService.deleteById(expectedFoundMovie.getId()));
    }
}
