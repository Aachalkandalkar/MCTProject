package com.geekster.MusicStreaming.controller;

import com.geekster.MusicStreaming.models.Playlist;
import com.geekster.MusicStreaming.models.User;
import com.geekster.MusicStreaming.service.PlaylistService;
import com.geekster.MusicStreaming.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")

public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private UserService userService;


    //GetMapping
    @GetMapping(value = "/{userId}")
    public List<Playlist> getAllPlaylists(@PathVariable("userId") Long userId){
        return playlistService.getAllPlaylists(userId);
    }

    //GetMapping
    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable("id") Long id) {
        return playlistService.getPlaylistById(id);
    }

    //PostMapping
    @PostMapping("/{userId}")
    public Playlist createPlaylist(@PathVariable("userId") Long userId, @RequestBody @Valid Playlist playlist) {
        User user = userService.getUserByUsername("admin"); // Assume the admin user is "admin"
        if (user == null) {
            return null;
        }

        if (playlist.getUser() == null) {
            playlist.setUser(user);
        } else {
            // Make sure the provided user is the owner of the playlist
            if (!playlist.getUser().getId().equals(user.getId())) {
                return null;
            }
        }

        return playlistService.savePlaylist(playlist);
    }


    //putMapping

    @PutMapping(value = "/{id}")
    public Playlist updatePlaylist(@PathVariable Long id , @Valid Playlist playlist){
        Playlist existingPlaylist = playlistService.getPlaylistById(id);

        if(existingPlaylist != null){
            existingPlaylist.setName(playlist.getName());
            return playlistService.savePlaylist(existingPlaylist);
        }
        return null;
    }

    //DeleteMapping

    @DeleteMapping(value = "/{id}")
    public void deletePlaylist(@PathVariable("id") Long id){
        playlistService.deletePlaylist(id);
    }


}
