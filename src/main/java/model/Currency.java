package model;

/**
 *
 * @author scast
 */
public class Currency {
    private String isoCode;
    private String symbol;
    private String name;

    public Currency(String isoCode, String simbol, String name) {
        this.isoCode = isoCode;
        this.symbol = simbol;
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
    
}
