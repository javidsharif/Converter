package com.sharifaliyev.converter.controllers;

import com.sharifaliyev.converter.dto.HistoryEntry;
import com.sharifaliyev.converter.dto.HistoryFilter;
import com.sharifaliyev.converter.entities.Currency;
import com.sharifaliyev.converter.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    private CurrencyService currencyService;

    @ModelAttribute("filter")
    public HistoryFilter historyFilter() {
        return new HistoryFilter();
    }

    @GetMapping("/history")
    public String showHistory(Model model) {
        List<Currency> currencyList = currencyService.getCurrenciesList();
        List<HistoryEntry> conversionList = currencyService.getHistory();
        model.addAttribute("conversions", conversionList);
        model.addAttribute("currenciesList", currencyList);
        return "history";
    }

    @PostMapping("/history")
    public String searchHistory(@ModelAttribute("filter") HistoryFilter filter, Model model) throws ParseException {
        List<Currency> currencyList = currencyService.getCurrenciesList();
        List<HistoryEntry> conversionList = currencyService.getHistory(filter);
        model.addAttribute("conversions", conversionList);
        model.addAttribute("currenciesList", currencyList);
        return "history";
    }
}
