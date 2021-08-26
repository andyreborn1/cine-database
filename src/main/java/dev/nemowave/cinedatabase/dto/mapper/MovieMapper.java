package dev.nemowave.cinedatabase.dto.mapper;

import dev.nemowave.cinedatabase.dto.MovieDTO;
import dev.nemowave.cinedatabase.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDTO toDTO(Movie movie);
    Movie toModel(MovieDTO movieDTO);
}
