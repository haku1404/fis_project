package org.example;

public class Transaction {
    private String type, message, date;
    private double amount, account;

    public Transaction() {
    }

    public Transaction(String type, double account, String message, String date, double amount) {
        this.type = type;
        this.account = account;
        this.message = message;
        this.date = date;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public String getMessage() {
        return message;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return String.format("%-20s %-15s %-15s %-35s %-15s", type, account, amount, message, date);
    }
}
