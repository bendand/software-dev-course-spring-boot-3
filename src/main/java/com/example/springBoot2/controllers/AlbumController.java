package com.example.springBoot2.controllers;

import com.example.springBoot2.Repositories.AlbumRepository;
import com.example.springBoot2.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping("")
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public Album getAlbum(@PathVariable(value="id") int albumId) {
        return albumRepository.findById(albumId).orElse(null);
    }

    @PostMapping("")
    public Album addAlbum(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @PutMapping("/{id}")
    public Album updateAlbum(@PathVariable(value="id") int albumId, @RequestBody Album album) {
        album.setId(albumId);
        return albumRepository.save(album);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable(value="id") int id) {
        albumRepository.findById(id).ifPresent(currAlbum -> albumRepository.deleteById(id));
    }
}
