package com.westeros.movies.mappers;

import com.westeros.data.model.Picture;
import com.westeros.moviesclient.contract.PictureDto;
import org.springframework.stereotype.Component;

@Component
public class PictureMapper {

    public Picture map(PictureDto pictureDto) {
        Picture picture = new Picture();
        picture.setFilePath(pictureDto.filePath());
        picture.setHeight(pictureDto.height());
        picture.setWidth(pictureDto.width());
        picture.setVoteAverage(pictureDto.voteAverage());
        picture.setVoteCount(pictureDto.voteCount());
        return picture;
    }

}
