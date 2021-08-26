package dev.nemowave.cinedatabase.dto.mapper;

import dev.nemowave.cinedatabase.dto.WriterDTO;
import dev.nemowave.cinedatabase.model.Writer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WriterMapper {

    WriterMapper INSTANCE = Mappers.getMapper(WriterMapper.class);

    Writer toModel(WriterDTO writerDTO);
    WriterDTO toDTO(Writer writer);
}
