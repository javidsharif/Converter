package com.sharifaliyev.converter.controllers;

import com.sharifaliyev.converter.dto.ConversionDTO;
import com.sharifaliyev.converter.entities.Currency;
import com.sharifaliyev.converter.services.CurrencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Controller
public class ConversionController {
    @Autowired
    private CurrencyService currencyService;

    @ModelAttribute("conversion")
    public ConversionDTO conversionDTO() {
        return new ConversionDTO();
    }

    @GetMapping("/")
    public String showConversionForm(Model model) {
        List<Currency> currencyList = currencyService.getCurrenciesList();
        model.addAttribute("currenciesList", currencyList);
        return "index";
    }

    @PostMapping("/")
    public String convert(@ModelAttribute("conversion") @Valid ConversionDTO conversionDTO, BindingResult result, Model model) throws IOException, ParserConfigurationException, SAXException {
        List<Currency> currencyList = currencyService.getCurrenciesList();
        ConversionDTO convert = currencyService.convert(conversionDTO);
        model.addAttribute("currenciesList", currencyList);
        model.addAttribute("conversion", convert);
        if(result.hasErrors()) {
            return "index";
        }
        return "index";
    }
}
