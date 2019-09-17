package main.java.bean;

import java.util.Objects;
import java.util.StringJoiner;

public class Pilot {
    private double salary;
    private String name;
    private String surname;
    private int flying;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public int getFlying() {
        return flying;
    }

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
