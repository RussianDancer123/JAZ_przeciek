package com.westeros.webapi.contract;

public record PictureDto(long id,
                         long movie_id,
                         int width,
                         int height,
                         String file_path,
                         int vote_count,
                         double vot_average) {
}
