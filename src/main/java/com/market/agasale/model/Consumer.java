package com.market.agasale.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    @OneToOne(mappedBy = "consumer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("consumer")
    private Cart cart;

}
