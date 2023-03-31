package com.ubb.postuniv.domain;

public class ClientCard extends Entity{
    private String firstName;
    private String lastName;
    private int CNP;
    private String dateBorn;
    private String dateJoined;
    private int points;

    public ClientCard(int id, String firstName, String lastName, int CNP, String dateBorn, String dateJoined, int points) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CNP;
        this.dateBorn = dateBorn;
        this.dateJoined = dateJoined;
        this.points = points;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCNP() {
        return CNP;
    }

    public void setCNP(int CNP) {
        this.CNP = CNP;
    }

    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "ClientCard{" +
                "id="+ this.getId()+ '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CNP=" + CNP +
                ", dateBorn='" + dateBorn + '\'' +
                ", dateJoined='" + dateJoined + '\'' +
                ", points=" + points +
                '}';
    }
}
