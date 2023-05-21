package com.geekster.MusicStreaming.repository;

import com.geekster.MusicStreaming.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlaylistRepo extends JpaRepository<Playlist,Long> {


    List<Playlist> findByUserId(Long userId);
}
