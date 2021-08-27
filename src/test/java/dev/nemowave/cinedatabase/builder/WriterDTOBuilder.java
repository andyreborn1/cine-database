package dev.nemowave.cinedatabase.builder;

import lombok.Builder;

public class WriterDTOBuilder {
    @Builder.Default
    public long id = 1L;

    @Builder.Default
    public String name = "";
}
