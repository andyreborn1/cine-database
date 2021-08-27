package dev.nemowave.cinedatabase.builder;

import lombok.Builder;

public class DirectorDTOBuilder {
    @Builder.Default
    public long id = 1L;

    @Builder.Default
    public String name = "";
}
