package com.magicm.reactivedemo.repository;

import com.magicm.reactivedemo.model.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {
}
