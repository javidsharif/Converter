package com.sharifaliyev.converter.repositories;

import com.sharifaliyev.converter.entities.Conversion;
import com.sharifaliyev.converter.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ConversionRepository  extends JpaRepository<Conversion, Long> {
    List<Conversion> findByUserId(long id);

    List<Conversion> findByDateAndUserId(Date date, long userId);

//    List<Conversion> findByCurrencyFromAndUserId(Currency currency, Date date, long userId);
//

    List<Conversion> findByCurrencyFromAndUserId(Currency currency, int userId);
    List<Conversion> findByCurrencyToAndUserId(Currency currency, long userId);

    List<Conversion> findByCurrencyToAndDateAndUserId(Currency currency, Date date, long userId);

    List<Conversion> findByCurrencyFromAndCurrencyToAndUserId(Currency currencyFrom, Currency currencyTo, int userId);

    List<Conversion> findByCurrencyFromAndCurrencyToAndDateAndUserId(Currency currencyFrom, Currency currencyTo, Date date, int userId);
    List<Conversion> findByCurrencyFromAndDateAndUserId(Currency currency, Date date, int userId);
}
