package moneyCalculator;

import model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class MoneyCalculator {
    private Money money;
    private ExchangeRate exchangeRate;
    private Currency currencyTo;
    private final CurrencyList currencyList;

    public static void main(String[] args) throws IOException {
        MoneyCalculator moneycalculator = new MoneyCalculator();
        moneycalculator.control();
    }

    public MoneyCalculator() {
        this.currencyList = new CurrencyList();
    }
    
    private void control() throws IOException {
        input();
        process();
        output();
    }

    private void input() {
        System.out.println("Introduce una cantidad: ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        
        System.out.println("Introduce una divisa inicial: ");
        Currency currencyFrom = currencyList.get(scanner.next().toUpperCase());
        
        money = new Money (currencyFrom, amount);
        
        System.out.println("Introduce una divisa final: ");
        currencyTo = currencyList.get(scanner.next().toUpperCase());
    }

    private void process() throws IOException {
        exchangeRate = getExchangeRate(money.getCurrency(), currencyTo);
    }

    private void output() {
        System.out.println(money.getAmount() + money.getCurrency().getSymbol() + " equivalen a " + money.getAmount() * exchangeRate.getRate() + currencyTo.getSymbol());
    }

    private static ExchangeRate getExchangeRate(Currency from, Currency to) throws IOException {
        URL url = 
            new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" +
                    from.getIsoCode() + "_" + to.getIsoCode() + "&compact=y");
        URLConnection connection = url.openConnection();
        try (BufferedReader reader = 
                new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(to.getIsoCode())+12, line.indexOf("}"));
            return new ExchangeRate(from,to, LocalDate.of(2018, Month.SEPTEMBER, 26),
                Double.parseDouble(line));
        }
    }
}

