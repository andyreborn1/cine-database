package dev.nemowave.cinedatabase.controller;

import dev.nemowave.cinedatabase.dto.MovieDTO;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController {

    MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO createMovie(@RequestBody @Valid MovieDTO movieDTO) throws DataAlreadyRegisteredException {
        return movieService.create(movieDTO);
    }

    @GetMapping("/{name}")
    public MovieDTO findByName(@PathVariable String name) throws RegisterNotFoundException {
        return movieService.findByName(name);
    }

    @GetMapping
    public List<MovieDTO> findAll(){
        return  movieService.findAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) throws RegisterNotFoundException {
        movieService.deleteById(id);
    }
}
