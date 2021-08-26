package dev.nemowave.cinedatabase.dto.mapper;

import dev.nemowave.cinedatabase.dto.DirectorDTO;
import dev.nemowave.cinedatabase.model.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DirectorMapper {

    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    Director toModel(DirectorDTO dto);

    DirectorDTO toDTO(Director director);
}
