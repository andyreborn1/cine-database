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

    private String imageLink;

    private String trailerLink;

    private long year;

    @Valid
    private List<Writer> writer;

    @Valid
    private List<Director> director;

    @Valid
    private List<Star> star;

    @Valid
    private List<Genre> genre;

    private String country;
}
