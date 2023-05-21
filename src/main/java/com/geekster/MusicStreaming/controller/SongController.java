package com.geekster.MusicStreaming.controller;

import com.geekster.MusicStreaming.models.Song;
import com.geekster.MusicStreaming.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SongController {

    @Autowired
    private SongService songService;

    //crud with songs

    // get mapping

    @GetMapping(value = "/songs")
    public List<Song> getAllSongs(){
        return songService.getAllSongs();
    }


    @GetMapping(value = "/{id}")
    public Song getSongById(@PathVariable("id") Long id){
       return  songService.getSongById(id);
    }


    //post mapping
    @PostMapping(value = "/create")
    public Song createSong(@RequestBody @Valid Song song){
       return songService.saveSong(song);
    }

    //put Mapping

    @PutMapping(value = "/{id}")
    public Song updateSong(@PathVariable("id")Long id, @RequestBody @Valid Song song){
        Song existingSong = songService.getSongById(id);
        if(existingSong != null){
            existingSong.setTitle(song.getTitle());
            existingSong.setArtist(song.getArtist());
            return songService.saveSong(existingSong);
        }
        return null;
    }

    //Delete mapping

    @DeleteMapping(value = "/{id}")
    public void deleteSong(@PathVariable("id") Long id){
        songService.deleteSong(id);
    }

}
