public class Cash {
    private int nominal;
    private int banyakLembar;
    private String currency;

    public Cash(int nominal, int banyakLembar, String currency) {
        this.nominal = nominal;
        this.banyakLembar = banyakLembar;
        this.currency = currency;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getBanyakLembar() {
        return banyakLembar;
    }

    public void setBanyakLembar(int banyakLembar) {
        this.banyakLembar = banyakLembar;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Nominal: " + nominal + ", Number of Bills: " + banyakLembar + ", Currency: " + currency;
    }
}
