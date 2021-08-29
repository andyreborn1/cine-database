package dev.nemowave.cinedatabase.dto;

import dev.nemowave.cinedatabase.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WriterDTO {

    private long id;

    @NotEmpty
    private String name;
}
