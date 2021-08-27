package dev.nemowave.cinedatabase.service;

import dev.nemowave.cinedatabase.dto.mapper.MovieMapper;
import dev.nemowave.cinedatabase.repository.MovieRepository;
import dev.nemowave.cinedatabase.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    private MovieMapper movieMapper = MovieMapper.INSTANCE;

    @InjectMocks
    private MovieService movieService;

    @Test
    void whenMovieInformedThenShouldBeCreated(){

    }
}
