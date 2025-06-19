package com.example.springBoot2.controllers;

import com.example.springBoot2.Repositories.AlbumRepository;
import com.example.springBoot2.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private AlbumRepository albumRepository;
}
