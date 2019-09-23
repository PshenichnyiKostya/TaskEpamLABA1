package bean;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * The type Client.
 */
public class Client {
    private int discount;
    private double freeMiles;
    private String login;
    private String pass;
    private String name;
    private String surname;
    private String id;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets discount.
     *
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Sets discount.
     *
     * @param discount the discount
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * Gets free miles.
     *
     * @return the free miles
     */
    public double getFreeMiles() {
        return freeMiles;
    }

    /**
     * Sets free miles.
     *
     * @param freeMiles the free miles
     */
    public void setFreeMiles(double freeMiles) {
        this.freeMiles = freeMiles;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets pass.
     *
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets pass.
     *
     * @param pass the pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass() ==this.getClass())) return false;
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

    /**
     * Instantiates a new Client.
     *
     * @param client the client
     */
    public Client(Client client) {
        this(client.discount, client.freeMiles, client.login, client.pass, client.name, client.surname, client.id);
    }

    /**
     * Instantiates a new Client.
     *
     * @param discount  the discount
     * @param freeMiles the free miles
     * @param login     the login
     * @param pass      the pass
     * @param name      the name
     * @param surname   the surname
     * @param id        the id
     */
    public Client(int discount, double freeMiles, String login, String pass, String name, String surname, String id) {
        this.discount = discount;
        this.freeMiles = freeMiles;
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    /**
     * Instantiates a new Client.
     */
    public Client() {
    }


}
