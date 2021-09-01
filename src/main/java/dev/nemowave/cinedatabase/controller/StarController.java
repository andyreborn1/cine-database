package dev.nemowave.cinedatabase.controller;

import dev.nemowave.cinedatabase.dto.StarDTO;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.service.StarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/star")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StarController {

    private final StarService starService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StarDTO create(@RequestBody StarDTO starDTO) throws DataAlreadyRegisteredException {
        return starService.create(starDTO);
    }

    @GetMapping
    public List<StarDTO> findAll() {
        return starService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws RegisterNotFoundException {
        starService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StarDTO update(@PathVariable long id, @RequestBody @Valid StarDTO starDTO) throws RegisterNotFoundException {
        return starService.update(id, starDTO);
    }
}
