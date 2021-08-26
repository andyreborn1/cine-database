package dev.nemowave.cinedatabase.dto;

import dev.nemowave.cinedatabase.model.Director;
import dev.nemowave.cinedatabase.model.Genre;
import dev.nemowave.cinedatabase.model.Star;
import dev.nemowave.cinedatabase.model.Writer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private long id;

    @NotEmpty
    private String title;

    private String originalTitle;

    private String synopsis;

    private String imageLink;

    private String trailerLink;

    private long year;

    @Valid
    @NotEmpty
    private List<Writer> writer;

    @Valid
    @NotEmpty
    private List<Director> director;

    @Valid
    @NotEmpty
    private List<Star> star;

    @Valid
    @NotEmpty
    private List<Genre> genre;

    private String country;
}
