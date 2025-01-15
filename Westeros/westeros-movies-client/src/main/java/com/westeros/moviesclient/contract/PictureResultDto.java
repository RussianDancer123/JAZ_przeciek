package com.westeros.moviesclient.contract;

import java.util.List;

public record PictureResultDto(List<PictureDto> backdrops, List<PictureDto> logos, List<PictureDto> posters) {

}