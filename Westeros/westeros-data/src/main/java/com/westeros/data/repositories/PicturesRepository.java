package com.westeros.data.repositories;

import com.westeros.data.model.Movie;
import com.westeros.data.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PicturesRepository extends JpaRepository<Picture, Long> {

    List<Picture> findByMovie(Movie movie);
}
