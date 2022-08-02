package com.example.bank.model;

import com.example.bank.appuser.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private String birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String adress;

    @Column(name = "phone")
    private String phone;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "gender")
    private String gender;

    @Column(name = "debt_amount")
    private String debtAmount;

    @ManyToOne
    @JoinColumn(name = "document", referencedColumnName = "doc_id")
    private Document document;

    @ManyToOne
    @JoinColumn(name = "card", referencedColumnName = "card_id")
    private CreditCard card;


}
