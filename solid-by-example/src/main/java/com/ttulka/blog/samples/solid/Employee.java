package com.ttulka.blog.samples.solid;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Employee {

    private final static Map<String, Employee> registry = new HashMap<>();

    protected final String personalId;
    protected final String firstName;
    protected final String lastName;

    /**
     * @param personalId the personal ID
     * @param firstName the first name
     * @param lastName the last name
     */
    public Employee(String personalId, String firstName, String lastName) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the full name of the employee.
     * @return the full name of the employee
     */
    public String fullName() {
        return String.format("%s %s", firstName, lastName);
    }

    /**
     * Registers the employee.
     */
    public void register() {
        registry.put(personalId, this);
    }

    /**
     * Is the employee registered?
     * @return true if the employee is registered, false otherwise
     */
    public boolean isRegistered() {
        return registry.containsKey(personalId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return personalId.equals(employee.personalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalId);
    }
}