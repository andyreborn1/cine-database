package dev.nemowave.cinedatabase.controller;

import dev.nemowave.cinedatabase.builder.MovieDTOBuilder;
import dev.nemowave.cinedatabase.dto.MovieDTO;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;

import static dev.nemowave.cinedatabase.utils.JsonConversionUtils.asJsonString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

    private static final String MOVIE_API_URL_PATH = "/api/v1/movie";
    private static final long VALID_MOVIE_ID = 1L;
    private static final long INVALID_MOVIE_ID = 2l;

    private MockMvc mockMvc;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(movieController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTItsCalledThenAMovieIsCreated() throws Exception {
        //given
        MovieDTO movieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        //when
        when(movieService.create(movieDTO)).thenReturn(movieDTO);

        //then
        mockMvc.perform(post(MOVIE_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movieDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is(movieDTO.getTitle())))
                ;
    }

    @Test
    void whenPOSTItsCalledWithoutARequiredFieldThenAErrorIsReturned() throws Exception {
        //given
        MovieDTO movieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        movieDTO.setTitle(null);

        //then
        mockMvc.perform(post(MOVIE_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movieDTO)))
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    void whenGETAMovieWithAValidTitleItsCalledThenReturnStatusCodeOK() throws Exception {
        //given
        MovieDTO movieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        //when
        when(movieService.findByName(movieDTO.getTitle())).thenReturn(movieDTO);

        //then
        mockMvc.perform(get(MOVIE_API_URL_PATH+"/"+movieDTO.getTitle())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movieDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(movieDTO.getTitle())))
        ;
    }

    @Test
    void whenGETAMovieThatsNotRegisteredThenReturnStatusCodeNotFound() throws Exception {
        //given
        MovieDTO movieDTO = MovieDTOBuilder.builder().build().toMovieDTO();

        //when
        when(movieService.findByName(movieDTO.getTitle())).thenThrow(new RegisterNotFoundException(movieDTO.getTitle()));

        //then
        mockMvc.perform(get(MOVIE_API_URL_PATH+"/"+movieDTO.getTitle())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movieDTO)))
                .andExpect(status().isNotFound())
        ;
    }

    @Test
    void whenGETAMovieListThenReturnStatusCodeOK() throws Exception {
        //given
        MovieDTO movieDTO = MovieDTOBuilder.builder().build().toMovieDTO();

        //when
        when(movieService.findAll()).thenReturn(Collections.singletonList(movieDTO));

        //then
        mockMvc.perform(get(MOVIE_API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        ;
    }

    @Test
    void whenDeleteARegisteredMovieThenReturnStatusCodeNoContent() throws Exception {
        //given
        MovieDTO movieDTO = MovieDTOBuilder.builder().build().toMovieDTO();
        //when
        doNothing().when(movieService).deleteById(movieDTO.getId());

        //then
        mockMvc.perform(delete(MOVIE_API_URL_PATH+"/"+movieDTO.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
        ;
    }

    @Test
    void whenDeleteANoRegisteredMovieThenReturnStatusCodeNotFound() throws Exception {

        //when
        doThrow(RegisterNotFoundException.class).when(movieService).deleteById(INVALID_MOVIE_ID);

        //then
        mockMvc.perform(delete(MOVIE_API_URL_PATH+"/"+INVALID_MOVIE_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
        ;
    }
}
