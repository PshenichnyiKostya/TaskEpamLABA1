package main.java.bean;

import java.util.Objects;
import java.util.StringJoiner;

public class Client {
    private int discount;
    private double freeMiles;
    private String login;
    private String pass;
    private String name;
    private String surname;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getFreeMiles() {
        return freeMiles;
    }

    public void setFreeMiles(double freeMiles) {
        this.freeMiles = freeMiles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getDiscount() == client.getDiscount() &&
                Double.compare(client.getFreeMiles(), getFreeMiles()) == 0 &&
                getId() == client.getId() &&
                Objects.equals(getLogin(), client.getLogin()) &&
                Objects.equals(getPass(), client.getPass()) &&
                Objects.equals(getName(), client.getName()) &&
                Objects.equals(getSurname(), client.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiscount(), getFreeMiles(), getLogin(), getPass(), getName(), getSurname(), getId());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Client.class.getSimpleName() + "[", "]")
                .add("discount=" + discount)
                .add("freeMiles=" + freeMiles)
                .add("login='" + login + "'")
                .add("pass='" + pass + "'")
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("id=" + id)
                .toString();
    }
}
