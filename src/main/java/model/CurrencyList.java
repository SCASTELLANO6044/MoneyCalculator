package model;

import model.Currency;
import java.util.*;

public class CurrencyList {
    private final Map<String,Currency> currencies = new HashMap<>();

    public CurrencyList() {
        currencies.put("USD", new Currency("USD", "Dólar americano", "$"));
        currencies.put("EUR", new Currency("EUR", "Euros", "€"));
        currencies.put("GBP", new Currency("GBP", "Libras Esterlinas", "£"));
    }
    
    void add(Currency currency){
        currencies.put(currency.getIsoCode(), currency);
    }
    
    public Currency get (String isoCode){
        return currencies.get(isoCode.toUpperCase());
    }
}
