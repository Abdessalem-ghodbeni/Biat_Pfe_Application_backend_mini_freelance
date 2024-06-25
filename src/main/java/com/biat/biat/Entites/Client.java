package com.biat.biat.Entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@Entity

@Table(name="Client")
public class Client extends User {

    @Column(name="cin")
    private long cin;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name="adresse")
    private String adresse;
    @Column(name="nationality")
    private String nationality;
    private String image;
}
