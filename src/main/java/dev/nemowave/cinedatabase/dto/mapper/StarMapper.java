package dev.nemowave.cinedatabase.dto.mapper;

import dev.nemowave.cinedatabase.dto.StarDTO;
import dev.nemowave.cinedatabase.model.Star;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StarMapper {

    StarMapper INSTANCE = Mappers.getMapper(StarMapper.class);

    Star toModel(StarDTO starDTO);

    StarDTO toDTO(Star star);
}
