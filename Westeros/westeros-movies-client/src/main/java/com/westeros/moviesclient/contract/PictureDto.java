package com.westeros.moviesclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PictureDto(@JsonProperty("aspect_ratio")
                         double aspectRatio,
                         int height,
                         @JsonProperty("file_path")
                         String filePath,
                         @JsonProperty("vote_average")
                         double voteAverage,
                         @JsonProperty("vote_count")
                         int voteCount,
                         int width) {
}
