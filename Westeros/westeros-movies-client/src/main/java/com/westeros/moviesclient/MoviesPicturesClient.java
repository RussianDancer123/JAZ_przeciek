package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.PictureDto;
import com.westeros.moviesclient.contract.PictureResultDto;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MoviesPicturesClient implements IMoviesPicturesClient {

    private final IMoviesClientUriBuilderProvider provider;
    private final RestTemplate restTemplate = new RestTemplate();

    public MoviesPicturesClient(IMoviesClientUriBuilderProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<PictureDto> geetPictures(int movieId) {
        var uri = provider.builder().pathSegment("movie")
                .pathSegment(String.valueOf(movieId))
                .pathSegment("images")
                .toUriString();
        System.out.println(uri);
        PictureResultDto pictureResultDto = restTemplate.getForEntity(uri, PictureResultDto.class).getBody();

        List<PictureDto> pictureDto = pictureResultDto.backdrops();
        pictureDto.addAll(pictureResultDto.logos());
        pictureDto.addAll(pictureResultDto.posters());

//        List<PictureDto> pictureDto = Stream.of(result.backdrops(), result.logos(), result.posters())
//                .flatMap(Collection::stream)
//                .toList();

        return pictureDto;
    }
}
