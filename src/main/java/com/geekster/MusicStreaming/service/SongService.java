package com.geekster.MusicStreaming.service;

import com.geekster.MusicStreaming.models.Song;
import com.geekster.MusicStreaming.repository.ISongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class SongService {

    @Autowired
    ISongRepo iSongRepo;

    public List<Song> getAllSongs() {
        return iSongRepo.findAll();
    }

    public Song getSongById(Long id) {
        return iSongRepo.findById(id).orElse(null);
    }

    public Song saveSong(Song song) {
        return iSongRepo.save(song);
    }

    public void deleteSong(Long id) {
         iSongRepo.deleteById(id);
    }
}
