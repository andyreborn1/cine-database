package dev.nemowave.cinedatabase.builder;


import dev.nemowave.cinedatabase.dto.MovieDTO;
import dev.nemowave.cinedatabase.model.Director;
import dev.nemowave.cinedatabase.model.Genre;
import dev.nemowave.cinedatabase.model.Star;
import dev.nemowave.cinedatabase.model.Writer;

import java.util.ArrayList;
import java.util.List;

public class MovieDTOBuilder {

    private long id = 1L;

    private String title = "Agente Secreto";

    private String originalTitle = "Secret Agent";

    private String synopsis = "Durante a Segunda Guerra, soldado britânico descobre que uma agência do governo forjou sua morte e trocou seu nome. Agora ele será enviado para uma operação especial: viajar para a Suíça e matar um agente alemão. Para levar a cabo a missão, ele é ajudado por uma agente novata e um assassino profissional.";

    private String imageLink = "https://media.fstatic.com/lIoYQYSWtOhvAn8LO4wJ9pOXySk=/210x312/smart/media/movies/covers/2010/06/87d442ad736c198a30dc64a96b42dae1.jpg";

    private String trailerLink = "https://dai.ly/x5vfhzt";

    private long year = 1936L;

    private List<Writer> writer = new ArrayList<>();

    private List<Director> director = new ArrayList<>();

    private List<Star> star = new ArrayList<>();

    private List<Genre> genre = new ArrayList<>();

    private String country = "Inglaterra";

    MovieDTOBuilder(long id, String title, String originalTitle, String synopsis, String imageLink, String trailerLink, long year, List<Writer> writer, List<Director> director, List<Star> star, List<Genre> genre, String country) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.synopsis = synopsis;
        this.imageLink = imageLink;
        this.trailerLink = trailerLink;
        this.year = year;
        this.writer = writer;
        this.director = director;
        this.star = star;
        this.genre = genre;
        this.country = country;
    }

    private static long $default$id() {
        return 1L;
    }

    private static String $default$title() {
        return "Agente Secreto";
    }

    private static String $default$originalTitle() {
        return "Secret Agent";
    }

    private static String $default$synopsis() {
        return "Durante a Segunda Guerra, soldado britânico descobre que uma agência do governo forjou sua morte e trocou seu nome. Agora ele será enviado para uma operação especial: viajar para a Suíça e matar um agente alemão. Para levar a cabo a missão, ele é ajudado por uma agente novata e um assassino profissional.";
    }

    private static String $default$imageLink() {
        return "https://media.fstatic.com/lIoYQYSWtOhvAn8LO4wJ9pOXySk=/210x312/smart/media/movies/covers/2010/06/87d442ad736c198a30dc64a96b42dae1.jpg";
    }

    private static String $default$trailerLink() {
        return "https://dai.ly/x5vfhzt";
    }

    private static long $default$year() {
        return 1936L;
    }

    private static List<Writer> $default$writer() {
        return new ArrayList<>();
    }

    private static List<Director> $default$director() {
        return new ArrayList<>();
    }

    private static List<Star> $default$star() {
        return new ArrayList<>();
    }

    private static List<Genre> $default$genre() {
        return new ArrayList<>();
    }

    private static String $default$country() {
        return "Inglaterra";
    }

    public static MovieDTOBuilderBuilder builder() {
        return new MovieDTOBuilderBuilder();
    }

    public MovieDTO toMovieDTO() {
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

    public static class MovieDTOBuilderBuilder {
        private long id$value;
        private boolean id$set;
        private String title$value;
        private boolean title$set;
        private String originalTitle$value;
        private boolean originalTitle$set;
        private String synopsis$value;
        private boolean synopsis$set;
        private String imageLink$value;
        private boolean imageLink$set;
        private String trailerLink$value;
        private boolean trailerLink$set;
        private long year$value;
        private boolean year$set;
        private List<Writer> writer$value;
        private boolean writer$set;
        private List<Director> director$value;
        private boolean director$set;
        private List<Star> star$value;
        private boolean star$set;
        private List<Genre> genre$value;
        private boolean genre$set;
        private String country$value;
        private boolean country$set;

        MovieDTOBuilderBuilder() {
        }

        public MovieDTOBuilderBuilder id(long id) {
            this.id$value = id;
            this.id$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder title(String title) {
            this.title$value = title;
            this.title$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder originalTitle(String originalTitle) {
            this.originalTitle$value = originalTitle;
            this.originalTitle$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder synopsis(String synopsis) {
            this.synopsis$value = synopsis;
            this.synopsis$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder imageLink(String imageLink) {
            this.imageLink$value = imageLink;
            this.imageLink$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder trailerLink(String trailerLink) {
            this.trailerLink$value = trailerLink;
            this.trailerLink$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder year(long year) {
            this.year$value = year;
            this.year$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder writer(List<Writer> writer) {
            this.writer$value = writer;
            this.writer$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder director(List<Director> director) {
            this.director$value = director;
            this.director$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder star(List<Star> star) {
            this.star$value = star;
            this.star$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder genre(List<Genre> genre) {
            this.genre$value = genre;
            this.genre$set = true;
            return this;
        }

        public MovieDTOBuilderBuilder country(String country) {
            this.country$value = country;
            this.country$set = true;
            return this;
        }

        public MovieDTOBuilder build() {
            long id$value = this.id$value;
            if (!this.id$set) {
                id$value = MovieDTOBuilder.$default$id();
            }
            String title$value = this.title$value;
            if (!this.title$set) {
                title$value = MovieDTOBuilder.$default$title();
            }
            String originalTitle$value = this.originalTitle$value;
            if (!this.originalTitle$set) {
                originalTitle$value = MovieDTOBuilder.$default$originalTitle();
            }
            String synopsis$value = this.synopsis$value;
            if (!this.synopsis$set) {
                synopsis$value = MovieDTOBuilder.$default$synopsis();
            }
            String imageLink$value = this.imageLink$value;
            if (!this.imageLink$set) {
                imageLink$value = MovieDTOBuilder.$default$imageLink();
            }
            String trailerLink$value = this.trailerLink$value;
            if (!this.trailerLink$set) {
                trailerLink$value = MovieDTOBuilder.$default$trailerLink();
            }
            long year$value = this.year$value;
            if (!this.year$set) {
                year$value = MovieDTOBuilder.$default$year();
            }
            List<Writer> writer$value = this.writer$value;
            if (!this.writer$set) {
                writer$value = MovieDTOBuilder.$default$writer();
            }
            List<Director> director$value = this.director$value;
            if (!this.director$set) {
                director$value = MovieDTOBuilder.$default$director();
            }
            List<Star> star$value = this.star$value;
            if (!this.star$set) {
                star$value = MovieDTOBuilder.$default$star();
            }
            List<Genre> genre$value = this.genre$value;
            if (!this.genre$set) {
                genre$value = MovieDTOBuilder.$default$genre();
            }
            String country$value = this.country$value;
            if (!this.country$set) {
                country$value = MovieDTOBuilder.$default$country();
            }
            return new MovieDTOBuilder(id$value, title$value, originalTitle$value, synopsis$value, imageLink$value, trailerLink$value, year$value, writer$value, director$value, star$value, genre$value, country$value);
        }

        public String toString() {
            return "MovieDTOBuilder.MovieDTOBuilderBuilder(id$value=" + this.id$value + ", title$value=" + this.title$value + ", originalTitle$value=" + this.originalTitle$value + ", synopsis$value=" + this.synopsis$value + ", imageLink$value=" + this.imageLink$value + ", trailerLink$value=" + this.trailerLink$value + ", year$value=" + this.year$value + ", writer$value=" + this.writer$value + ", director$value=" + this.director$value + ", star$value=" + this.star$value + ", genre$value=" + this.genre$value + ", country$value=" + this.country$value + ")";
        }
    }
}
