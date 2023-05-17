package com.sharifaliyev.converter.mappers;

import com.sharifaliyev.converter.dto.ConversionDTO;
import com.sharifaliyev.converter.entities.Conversion;

import java.sql.Date;

public class ConversionDtoMapper {
    private ConversionDtoMapper() {}

    public static ConversionDTO getMapping(Conversion conversion) {
        ConversionDTO result = new ConversionDTO();

        result.setCurrencyFromCode(conversion.getCurrencyFrom().getNumCode());
        result.setCurrencyToCode(conversion.getCurrencyTo().getNumCode());
        result.setAmount(conversion.getAmount());
        result.setResult(conversion.getResult());
        result.setDate(conversion.getDate());

        return result;
    }
}
