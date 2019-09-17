package bean;

import java.util.Objects;
import java.util.StringJoiner;

public class Client {
    private int discount;
    private double freeMiles;
    private String login;
    private String pass;
    private String name;
    private String surname;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
                getId().equals(client.getId()) &&
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

    public Client(Client client) {
        this(client.discount, client.freeMiles, client.login, client.pass, client.name, client.surname, client.id);
    }

    public Client(int discount, double freeMiles, String login, String pass, String name, String surname, String id) {
        this.discount = discount;
        this.freeMiles = freeMiles;
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public Client() {
    }
}
