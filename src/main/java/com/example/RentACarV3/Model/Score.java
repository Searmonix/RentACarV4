package com.example.RentACarV3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;;

@Entity
@Table(name = "Score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    
    private Integer stars;

    private String messageText;

    // Reservation
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    //  Integer idScore
    public Integer getIdScore() {
        return idScore;
    }
    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    //  Integer stars
    public Integer getStars() {
        return stars;
    }
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    //  String messageText
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    // Reservation reservation
    public Reservation getReservation() {
        return reservation;
    }
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
