package dev.nemowave.cinedatabase.controller;

import dev.nemowave.cinedatabase.dto.DirectorDTO;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
    public List<DirectorDTO> findAll() {
        return directorService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DirectorDTO create(@RequestBody @Valid DirectorDTO directorDTO) throws DataAlreadyRegisteredException {
        return directorService.create(directorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws RegisterNotFoundException {
        directorService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DirectorDTO update(@PathVariable long id, @RequestBody DirectorDTO directorDTO) throws RegisterNotFoundException {
        return directorService.update(id, directorDTO);
    }
}
