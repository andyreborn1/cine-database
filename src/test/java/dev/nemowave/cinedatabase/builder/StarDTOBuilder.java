package dev.nemowave.cinedatabase.builder;

import lombok.Builder;

@Builder
public class StarDTOBuilder {
    @Builder.Default
    public long id = 1L;

    @Builder.Default
    public String name = "";
}
