package com.unsa.cashcard.application;

import com.unsa.cashcard.domain.CashCard;
import org.springframework.data.repository.CrudRepository;

public interface CashCardRepository extends CrudRepository<CashCard, Long> {

}
