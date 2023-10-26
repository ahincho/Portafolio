package com.unsa.cashcard.infrastructure;

import org.springframework.http.ResponseEntity;

public class CashCardController {

    public ResponseEntity<String> findById() {
        return ResponseEntity.ok("{}");
    }

}
