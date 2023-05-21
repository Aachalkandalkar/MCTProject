package com.geekster.MusicStreaming.service;

import com.geekster.MusicStreaming.models.Playlist;
import com.geekster.MusicStreaming.repository.IPlaylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    IPlaylistRepo iPlaylistRepo;

    public List<Playlist> getAllPlaylists(Long userId) {
        return iPlaylistRepo.findByUserId(userId);
    }

    public Playlist getPlaylistById(Long id) {
        return iPlaylistRepo.findById(id).orElse(null);
    }

    public Playlist savePlaylist(Playlist playlist) {
        return iPlaylistRepo.save(playlist);
    }


    public void deletePlaylist(Long id) {
        iPlaylistRepo.deleteById(id);
    }

    public boolean isUserPlaylistOwner(Long playlistId, Long userId) {
        Playlist playlist = iPlaylistRepo.findById(playlistId).orElse(null);
        return playlist != null && playlist.getUser().getId().equals(userId);
    }
}
