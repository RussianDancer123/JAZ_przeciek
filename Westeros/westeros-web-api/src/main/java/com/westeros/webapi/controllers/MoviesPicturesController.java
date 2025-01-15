package com.westeros.webapi.controllers;

import com.westeros.webapi.contract.PictureDto;
import com.westeros.webapi.services.MoviesPicturesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/pictures")
public class MoviesPicturesController {
    private final MoviesPicturesService service;


    public MoviesPicturesController(MoviesPicturesService service) {
        this.service = service;
    }

//    http://localhost:8080/api/v1/pictures/710295
    @GetMapping("{movie_id}")
    public ResponseEntity<List<PictureDto>> getMoviePictures(@PathVariable("movie_id") long movieId) {
        return ResponseEntity.ok(service.getMoviePictures(movieId));
    }

//    http://localhost:8080/api/v1/pictures/710295

//{
//    "id": "99999999999",
//        "movie_id": 710295,
//        "width": 200,
//        "height": 222,
//        "file_path": "awd/path",
//        "vote_count": 666,
//        "vot_average": 999
//}
    @PostMapping("{movie_id}")
    public ResponseEntity<PictureDto> postMoviePictures(@RequestBody PictureDto picture, @PathVariable long movie_id) {
        service.saveMoviePicture(picture, movie_id);
        return ResponseEntity.ok(picture);
    }

}
