package dev.nemowave.cinedatabase.builder;


import dev.nemowave.cinedatabase.dto.MovieDTO;
import dev.nemowave.cinedatabase.model.Director;
import dev.nemowave.cinedatabase.model.Genre;
import dev.nemowave.cinedatabase.model.Star;
import dev.nemowave.cinedatabase.model.Writer;
import lombok.Builder;

import java.util.List;

@Builder
public class MovieDTOBuilder {

    @Builder.Default
    private long id = 1L;

    @Builder.Default
    private String title = "Agente Secreto";

    @Builder.Default
    private String originalTitle = "Secret Agent";

    @Builder.Default
    private String synopsis = "Durante a Segunda Guerra, soldado britânico descobre que uma agência do governo forjou sua morte e trocou seu nome. Agora ele será enviado para uma operação especial: viajar para a Suíça e matar um agente alemão. Para levar a cabo a missão, ele é ajudado por uma agente novata e um assassino profissional.";

    @Builder.Default
    private String imageLink = "https://media.fstatic.com/lIoYQYSWtOhvAn8LO4wJ9pOXySk=/210x312/smart/media/movies/covers/2010/06/87d442ad736c198a30dc64a96b42dae1.jpg";

    @Builder.Default
    private String trailerLink = "https://dai.ly/x5vfhzt";

    @Builder.Default
    private long year = 1936L;

    @Builder.Default
    private List<Writer> writer;

    @Builder.Default
    private List<Director> director;

    @Builder.Default
    private List<Star> star;

    @Builder.Default
    private List<Genre> genre;

    @Builder.Default
    private String country = "Inglaterra";

    public MovieDTO toMovieDTO(){
        return new MovieDTO(
                id,
                title,
                originalTitle,
                synopsis,
                imageLink,
                trailerLink,
                year,
                writer,
                director,
                star,
                genre,
                country
        );
    }

}
