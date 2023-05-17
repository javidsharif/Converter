package com.sharifaliyev.converter.repositories;

import com.sharifaliyev.converter.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository  extends JpaRepository<Currency, Long> {
    Optional<Currency> findByNumCode(String numCode);


}
