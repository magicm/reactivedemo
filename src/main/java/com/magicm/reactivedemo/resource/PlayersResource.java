package com.magicm.reactivedemo.resource;

import com.magicm.reactivedemo.model.Player;
import com.magicm.reactivedemo.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController()
@RequestMapping(value = "/players")
@RequiredArgsConstructor
class PlayersResource {

    private final PlayerRepository playerRepository;

    @GetMapping("")
    public Flux<Player> all(@RequestParam(value = "q", required = false) String q,
                            @RequestParam(value = "page", defaultValue = "0") long page,
                            @RequestParam(value = "size", defaultValue = "10") long size) {
        return filterPlayers(q)
            .sort(comparing(Player::getCreatedDate).reversed())
            .skip(page * size).take(size);
    }

    private Flux<Player> filterPlayers(String q) {
        return playerRepository.findAll()
                .filter(
                        p -> Optional.ofNullable(q)
                                .map(key -> p.getName().contains(key))
                                .orElse(true)
                );
    }
}
