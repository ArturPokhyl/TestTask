package core.data_models;

import core.ConfigReader;

import java.util.Objects;

public class Card {
    private final String cardNumber;
    private final String cardHolder;
    private final String expiryDate;
    private final String cvv;

    public Card(String cardNumber, String cardHolder, String expiryDate, String cvv) {
        this.cardNumber = Objects.requireNonNull(cardNumber, "Card number cannot be null.");
        this.cardHolder = Objects.requireNonNull(cardHolder, "Card holder name cannot be null.");
        this.expiryDate = Objects.requireNonNull(expiryDate, "Expiry date cannot be null.");
        this.cvv = Objects.requireNonNull(cvv, "CVV cannot be null.");
    }

    public String getNumber() {
        return cardNumber;
    }

    public String getHolder() {
        return cardHolder;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public static Card getDefaultCard() {
        return new Card(
                ConfigReader.getProperty("card.properties", "card.number"),
                ConfigReader.getProperty("card.properties", "card.holder"),
                ConfigReader.getProperty("card.properties", "card.expiry.date"),
                ConfigReader.getProperty("card.properties", "card.cvv")
        );
    }

    @Override
    public String toString() {
        return "CardDetails{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
