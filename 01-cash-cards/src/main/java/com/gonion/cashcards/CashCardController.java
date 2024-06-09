package com.gonion.cashcards;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
class CashCardController {
  private final CashCardRepository cashCardRepository;

  private CashCardController(CashCardRepository cashCardRepository) {
    this.cashCardRepository = cashCardRepository;
  }

  @GetMapping("/{requestedId}")
  private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
    Optional<CashCard> cashCard = cashCardRepository.findById(requestedId);
    return cashCard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  private ResponseEntity<Void> create(@RequestBody CashCard cashCard, UriComponentsBuilder ucb) {
    CashCard savedCashCard = cashCardRepository.save(cashCard);
    URI locationOfNewCashCard = ucb
            .path("cashcards/{id}")
            .buildAndExpand(savedCashCard.id())
            .toUri();
    return ResponseEntity.created(locationOfNewCashCard).build();
  }
}
