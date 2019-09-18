package bean;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * The type Pilot.
 */
public class Pilot {
    private double salary;
    private String name;
    private String surname;
    private int flying;

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
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

    /**
     * Gets flying.
     *
     * @return the flying
     */
    public int getFlying() {
        return flying;
    }

    /**
     * Sets flying.
     *
     * @param flying the flying
     */
    public void setFlying(int flying) {
        this.flying = flying;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pilot)) return false;
        Pilot pilot = (Pilot) o;
        return Double.compare(pilot.getSalary(), getSalary()) == 0 &&
                getFlying() == pilot.getFlying() &&
                Objects.equals(getName(), pilot.getName()) &&
                Objects.equals(getSurname(), pilot.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSalary(), getName(), getSurname(), getFlying());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Pilot.class.getSimpleName() + "[", "]")
                .add("salary=" + salary)
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("flying=" + flying)
                .toString();
    }
}
