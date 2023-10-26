package com.unsa.cashcard.infrastructure;

import com.unsa.cashcard.domain.CashCard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> findById() {
        CashCard cashCard = new CashCard(1000L, 0.0);
        return ResponseEntity.ok(cashCard);
    }

}
