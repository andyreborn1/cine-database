package dev.nemowave.cinedatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    private String originalTitle;

    private String synopsis;

    private String imageLink;

    private String trailerLink;

    private String country;

    private long year;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JsonIgnore
    private Set<Writer> writer;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JsonIgnore
    private Set<Director> director;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JsonIgnore
    private Set<Star> star;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JsonIgnore
    private Set<Genre> genre;

}
