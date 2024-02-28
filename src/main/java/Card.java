public class Card {
    private String cardNumber;
    private String cardHolderName;
    private String bankName;
    private double balance;

    public Card(String cardNumber, String cardHolderName, String bankName, double balance) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.bankName = bankName;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card Number: " + cardNumber + ", Owner: " + cardHolderName + ", Bank: " + bankName + ", Balance: " + balance;
    }

}
