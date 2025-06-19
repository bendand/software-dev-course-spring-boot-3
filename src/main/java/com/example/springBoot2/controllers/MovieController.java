package com.example.springBoot2.controllers;

import com.example.springBoot2.Repositories.AlbumRepository;
import com.example.springBoot2.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private AlbumRepository albumRepository;
}
