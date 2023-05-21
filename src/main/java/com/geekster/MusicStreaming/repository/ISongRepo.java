package com.geekster.MusicStreaming.repository;

import com.geekster.MusicStreaming.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

import java.util.List;

@Repository
public interface ISongRepo extends JpaRepository<Song, Long> {

}
