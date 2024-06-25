package com.biat.biat.Entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="Agent")
public class Agent extends User {


    @Column(name="cin")
    private long cin;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
//    @Lob
//    @Column(length = 1000000)
    private String image;


}
