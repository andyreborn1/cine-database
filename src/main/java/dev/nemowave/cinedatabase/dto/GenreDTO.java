package dev.nemowave.cinedatabase.dto;

import dev.nemowave.cinedatabase.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDTO {

    private long id;

    @NotEmpty
    private String name;
}
