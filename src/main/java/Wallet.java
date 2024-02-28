import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private Owner owner;
    private List<Card> cards;
    private List<Cash> cashList;

    public Wallet() {
        cards = new ArrayList<>();
        cashList = new ArrayList<>();
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
        System.out.println("Owner successfully set: " + owner.toString());
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Cash> getCashList() {
        return cashList;
    }

    public void setCashList(List<Cash> cashList) {
        this.cashList = cashList;
    }

    public void addCard(Card card) {
        cards.add(card);
        System.out.println("Card successfully added to wallet: " + card.toString());
    }

    public void removeCard(Card card) {
        cards.remove(card);
        System.out.println("Card successfully removed from wallet: " + card.toString());
    }

    public void addCash(Cash cash) {
        cashList.add(cash);
        System.out.println("Cash successfully added to wallet: " + cash.toString());
    }

    public void withdrawCash(Cash cash) {
        try {
            if (!cash.getCurrency().equals("IDR")) {
                throw new IllegalArgumentException("Invalid currency provided: " + cash.getCurrency());
            }
            cashList.remove(cash);
            System.out.println("Successfully withdrew " + cash.getNominal() + " " + cash.getCurrency() + " from wallet.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public double getTotalCash() {
        double totalCash = 0;
        for (Cash cash : cashList) {
            totalCash += cash.getNominal() * cash.getBanyakLembar();
        }
        System.out.println("Total cash in wallet: " + totalCash + " IDR");
        return totalCash;
    }
}
