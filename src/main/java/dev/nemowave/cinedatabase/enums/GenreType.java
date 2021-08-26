package dev.nemowave.cinedatabase.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenreType {

    ACTION("Ação"),
    ANIMATION("Animações"),
    ADVENTURE("Aventura"),
    BIOGRAPHY("Biografia"),
    MUDO("Cinema Mudo"),
    COMEDY("Comédia"),
    SHORT("Curta-Metragem"),
    DOC("Documentário"),
    DRAMA("Drama"),
    FANTASY("Fantasia"),
    WESTERN("Faroeste"),
    SCYFI("Ficção Científica"),
    GRINDHOUSE("Grindhouse"),
    WAR("Guerra"),
    EPIC("Histórico/Épico"),
    MUSICAL("Musical"),
    NOIR("Noir"),
    CRIME("Policial/Crime"),
    ROMANCE("Romance"),
    THRILLER("Suspense"),
    HORROR("Terror");

    private final String description;
}
