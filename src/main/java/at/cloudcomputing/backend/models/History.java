package at.cloudcomputing.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue
    @Column(name = "idhistory")
    int idhistory;
}