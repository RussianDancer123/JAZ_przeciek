package com.westeros.webapi.services.mappers;

import com.westeros.data.model.Picture;
import com.westeros.webapi.contract.PictureDto;
import org.springframework.stereotype.Component;

@Component
public class PictureMapper {

    public PictureDto toPictureDto(Picture picture) {
        PictureDto pictureDto = new PictureDto(picture.getId(),
                picture.getMovie().getSourceId(),
                picture.getWidth(),
                picture.getHeight(),
                picture.getFilePath(),
                picture.getVoteCount(),
                picture.getVoteAverage());
        return pictureDto;
    }

    public Picture toPicture(PictureDto pictureDto) {
        Picture picture = new Picture();
        picture.setVoteCount(pictureDto.vote_count());
        picture.setVoteAverage(pictureDto.vot_average());
        picture.setHeight(pictureDto.height());
        picture.setWidth(pictureDto.width());
        picture.setFilePath(pictureDto.file_path());
        return picture;
    }
}
