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
import java.util.Set;

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

    private String country;

    private long year;

    @Valid
    private Set<Writer> writer;

    @Valid
    private Set<Director> director;

    @Valid
    private Set<Star> star;

    @Valid
    private Set<Genre> genre;


}
