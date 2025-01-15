package com.westeros.webapi.services;

import com.westeros.data.model.Movie;
import com.westeros.data.model.Picture;
import com.westeros.data.repositories.ICatalogData;
import com.westeros.data.repositories.MoviesRepository;
import com.westeros.data.repositories.PicturesRepository;
import com.westeros.webapi.contract.PictureDto;
import com.westeros.webapi.services.mappers.PictureMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesPicturesService {
    private final MoviesRepository moviesRepository;
    private final PicturesRepository picturesRepository;
    private final PictureMapper mapper;

    public MoviesPicturesService(MoviesRepository moviesRepository, PicturesRepository picturesRepository, PictureMapper mapper) {
        this.moviesRepository = moviesRepository;
        this.picturesRepository = picturesRepository;
        this.mapper = mapper;
    }


    public List<PictureDto> getMoviePictures(long movieId) {
        Movie movie = moviesRepository.findBySourceId(movieId).orElse(null);
        List<Picture> pictures = picturesRepository.findByMovie(movie);

        List<PictureDto> pictureDtos = pictures.stream().map(mapper::toPictureDto).toList();

        return pictureDtos;
    }

    public void saveMoviePicture(PictureDto pictureDto, long movieId) {
        Movie movie = moviesRepository.findBySourceId(movieId).orElse(null);

        Picture picture = mapper.toPicture(pictureDto);
        picture.setMovie(movie);
        picturesRepository.save(picture);
    }
}
