package com.westeros.movies.updater;

import com.westeros.data.model.Movie;
import com.westeros.data.model.Picture;
import com.westeros.data.repositories.MoviesRepository;
import com.westeros.data.repositories.PicturesRepository;
import com.westeros.movies.mappers.PictureMapper;
import com.westeros.moviesclient.MoviesPicturesClient;
import com.westeros.moviesclient.contract.PictureDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PicturesUpdater implements IUpdatePictures {
    private final PicturesRepository picturesRepository;
    private final MoviesPicturesClient picturesClient;
    private final MoviesRepository moviesRepository;
    private final PictureMapper pictureMapper;

    public PicturesUpdater(PicturesRepository repository, MoviesPicturesClient picturesClient, MoviesRepository moviesRepository, PictureMapper pictureMapper) {
        this.picturesRepository = repository;
        this.picturesClient = picturesClient;
        this.moviesRepository = moviesRepository;
        this.pictureMapper = pictureMapper;
    }

    @Override
    public void updatePictures() {
        List<Movie> movies = moviesRepository.findAll();
        List<Picture> pictures = new ArrayList<Picture>();
        for (Movie movie : movies) {
            List<PictureDto> picturesDto = picturesClient.geetPictures((int) movie.getSourceId());
            System.out.println("dziala");
            for (PictureDto pictureDto : picturesDto) {
                Picture picture = pictureMapper.map(pictureDto);
                picture.setMovie(movie);
                pictures.add(picture);
            }
        }
        picturesRepository.saveAll(pictures);
    }
}
