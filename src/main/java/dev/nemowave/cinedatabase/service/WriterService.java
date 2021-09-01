package dev.nemowave.cinedatabase.service;

import dev.nemowave.cinedatabase.dto.WriterDTO;
import dev.nemowave.cinedatabase.dto.mapper.WriterMapper;
import dev.nemowave.cinedatabase.exception.DataAlreadyRegisteredException;
import dev.nemowave.cinedatabase.exception.RegisterNotFoundException;
import dev.nemowave.cinedatabase.model.Writer;
import dev.nemowave.cinedatabase.repository.WriterRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class WriterService {

    private final WriterRepository writerRepository;
    private static final WriterMapper writerMapper = WriterMapper.INSTANCE;

    public WriterDTO create(WriterDTO writerDTO) throws DataAlreadyRegisteredException {
        verifyIfAlreadyRegistered(writerDTO.getName());
        Writer writerToSave = writerMapper.toModel(writerDTO);
        Writer savedWriter = writerRepository.save(writerToSave);
        return writerMapper.toDTO(savedWriter);
    }

    public WriterDTO update(long id, WriterDTO writerDTO) throws RegisterNotFoundException {
        verifyIfExists(id);
        Writer writerToUpdate = writerMapper.toModel(writerDTO);
        Writer updatedWriter = writerRepository.save(writerToUpdate);
        return writerMapper.toDTO(updatedWriter);
    }

    public List<WriterDTO> findAll() {
        return writerRepository.findAll()
                .stream().map(writerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(long id) throws RegisterNotFoundException {
        verifyIfExists(id);
        writerRepository.deleteById(id);
    }

    private void verifyIfAlreadyRegistered(String name) throws DataAlreadyRegisteredException {
        Optional<Writer> getSavedWriter = writerRepository.findByName(name);

        if (getSavedWriter.isPresent()) {
            throw new DataAlreadyRegisteredException(name);
        }
    }

    private Writer verifyIfExists(long id) throws RegisterNotFoundException {
        return writerRepository.findById(id)
                .orElseThrow(() -> new RegisterNotFoundException(id));
    }
}
