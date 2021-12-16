package com.romulomotta.checkpoint.rest;

import com.google.gson.Gson;
import com.romulomotta.checkpoint.model.dto.JikanDTO;
import com.romulomotta.checkpoint.model.entity.Jikan;
import com.romulomotta.checkpoint.model.entity.Top;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/jikan")
public class JikanController {

    @GetMapping
    public List<JikanDTO> getJikan() {

        RestTemplate restTemplate = new RestTemplate();
        String url
                = "https://api.jikan.moe/v3/top/anime";
        ResponseEntity<String> jikan
                = restTemplate.getForEntity(url, String.class);

        String strJikan = jikan.getBody();

        Gson gson = new Gson();
        Jikan objJikan = gson.fromJson(strJikan, Jikan.class);
        List<JikanDTO> dtoList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Top top = objJikan.getTop()[i];
            System.out.println(top.getTitle());
            System.out.println(top.getStart_date());
            JikanDTO dto = new JikanDTO();
            dto.setTitle(top.getTitle());
            dto.setStart_date(top.getStart_date());
            dtoList.add(dto);
        }

        System.out.println(objJikan.getTop().length);
        return dtoList;
    }
}
