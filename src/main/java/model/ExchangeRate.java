package model;

import model.Currency;
import java.time.LocalDate;
import java.util.Date;

public class ExchangeRate {
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final LocalDate date;
    private final double rate;

    public ExchangeRate(Currency fromCurrency, Currency toCurrency, LocalDate date, double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
        this.rate = rate;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getRate() {
        return rate;
    }
    
    
}
