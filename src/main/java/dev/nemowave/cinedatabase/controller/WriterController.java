package dev.nemowave.cinedatabase.controller;

import dev.nemowave.cinedatabase.dto.WriterDTO;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.service.WriterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/writer")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WriterController {

    private final WriterService writerService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public WriterDTO create(WriterDTO writerDTO) throws DataAlreadyRegisteredException {
        return writerService.create(writerDTO);
    }

    @GetMapping
    public List<WriterDTO> findAll() {
        return writerService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) throws RegisterNotFoundException {
        writerService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WriterDTO update(long id, WriterDTO writerDTO) throws RegisterNotFoundException {
        return writerService.update(id, writerDTO);
    }
}
