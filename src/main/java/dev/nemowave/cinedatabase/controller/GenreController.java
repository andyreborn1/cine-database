package dev.nemowave.cinedatabase.controller;

import dev.nemowave.cinedatabase.dto.GenreDTO;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genre")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GenreController {

    GenreService genreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenreDTO create(@RequestBody GenreDTO genreDTO) throws DataAlreadyRegisteredException {
        return genreService.create(genreDTO);
    }

    @GetMapping
    public List<GenreDTO> findAll(){
        return genreService.findaAll();
    }


}
