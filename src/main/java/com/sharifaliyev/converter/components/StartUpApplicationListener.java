package com.sharifaliyev.converter.components;

import com.sharifaliyev.converter.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StartUpApplicationListener {
    @Autowired
    private CurrencyService currencyService;

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws IOException, ParserConfigurationException, SAXException {
        currencyService.getCourses(format.format(new Date()));
    }
}
