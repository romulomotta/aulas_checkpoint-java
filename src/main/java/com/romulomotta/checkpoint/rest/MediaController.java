package com.romulomotta.checkpoint.rest;

import com.google.gson.Gson;
import com.romulomotta.checkpoint.model.dto.MediaDTO;
import com.romulomotta.checkpoint.model.entity.Data;
import com.romulomotta.checkpoint.model.entity.Media;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    @GetMapping
    public List<MediaDTO> getMedia() {

        RestTemplate restTemplate = new RestTemplate();
        String url
                = "http://api.mediastack.com/v1/news?access_key=82010f78d80f6678b5d63465f5b94d2d&categories=entertainment&limit=10&languages=pt&keywords=anime";
        ResponseEntity<String> media
                = restTemplate.getForEntity(url, String.class);

        String strMedia = media.getBody();

        Gson gson = new Gson();
        Media objMedia = gson.fromJson(strMedia, Media.class);
        List<MediaDTO> dtoList = new ArrayList<>();

        for (int i = 0+1; i < 3+1; i++) {
            Data data = objMedia.getData()[i];
            System.out.println(data.getTitle());
            System.out.println(data.getUrl());
            MediaDTO dto = new MediaDTO();
            dto.setTitle(data.getTitle());
            dto.setUrl(data.getUrl());
            dtoList.add(dto);
        }

        System.out.println(objMedia.getData().length);
        return dtoList;
    }
}
