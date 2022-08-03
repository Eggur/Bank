package com.example.bank.model;

import com.example.bank.appuser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "app_user", referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "card", referencedColumnName = "id")
    private CreditCard card;

    @ManyToOne
    @JoinColumn(name = "doc", referencedColumnName = "full_name")
    private Document document;

}
