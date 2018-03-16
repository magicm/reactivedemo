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
                    .just(
                            Player.builder()
                                    .name("Rajon Rondo")
                                    .team("Celtics")
                                    .imageUrl("https://d2cwpp38twqe55.cloudfront.net/req/201803151/images/players/rondora01.jpg")
                                    .build(),
                            Player.builder()
                                    .name("Larry Bird")
                                    .team("Celtics")
                                    .imageUrl("https://d2cwpp38twqe55.cloudfront.net/req/201803151/images/players/birdla01.jpg")
                                    .build(),
                            Player.builder()
                                    .name("Bill Russell")
                                    .team("Celtics")
                                    .imageUrl("https://d2cwpp38twqe55.cloudfront.net/req/201803151/images/players/russebi01.jpg")
                                    .build(),
                            Player.builder()
                                    .name("Ray Allen")
                                    .team("Celtics")
                                    .imageUrl("https://d2cwpp38twqe55.cloudfront.net/req/201803151/images/players/allenra02.jpg")
                                    .build()
                    )
                    .flatMap(playerRepository::save)
            )
            .log()
            .subscribe(
                null,
                null,
                () -> log.info("Done players initialization...")
            );
    }

}
