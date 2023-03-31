package com.ubb.postuniv.domain;

public class Reservation extends Entity{
    private int idFilm;
    private int idClientCard;
    private String dateTime;

    public Reservation(int id, int idFilm, int idClientCard, String dateTime) {
        super(id);
        this.idFilm = idFilm;
        this.idClientCard = idClientCard;
        this.dateTime = dateTime;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdClientCard() {
        return idClientCard;
    }

    public void setIdClientCard(int idClientCard) {
        this.idClientCard = idClientCard;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Reservation{" + ' ' +
                "id="+ this.getId()+ ' ' +
                "idFilm=" + idFilm + ' ' +
                ", idClientCard=" + idClientCard + ' ' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
