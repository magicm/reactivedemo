package com.magicm.reactivedemo;

import com.magicm.reactivedemo.model.Player;
import com.magicm.reactivedemo.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;


@Component
@Slf4j
@RequiredArgsConstructor
class DataInitializer {

    private final PlayerRepository playerRepository;

    @EventListener(value = ContextRefreshedEvent.class)
    public void init() {
        createPlayers();
    }

    private void createPlayers() {
        log.info("Start inserting sample players data  ...");
        this.playerRepository
            .deleteAll()
            .thenMany(
                Flux
                    .just("Rajon Rondo", "Larry Bird", "Bill Russell")
                    .flatMap(
                        playerName -> playerRepository.save(
                                Player.builder()
                                        .name(playerName)
                                        .team("Celtics")
                                        .build()
                        )
                    )
            )
            .log()
            .subscribe(
                null,
                null,
                () -> log.info("Done players initialization...")
            );
    }

}
