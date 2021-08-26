package dev.nemowave.cinedatabase.dto;

import dev.nemowave.cinedatabase.enums.GenreType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDTO {

    private long id;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    private GenreType type;
}
