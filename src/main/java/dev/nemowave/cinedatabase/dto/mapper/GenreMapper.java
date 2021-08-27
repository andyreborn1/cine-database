package dev.nemowave.cinedatabase.dto.mapper;

import dev.nemowave.cinedatabase.dto.GenreDTO;
import dev.nemowave.cinedatabase.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    Genre toModel(GenreDTO genreDTO);
    GenreDTO toDTO(Genre genre);
}
