package com.example.bank.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "document")
@AllArgsConstructor
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "series", length = 10)
    private String series;

    @Column(name = "numeral", length = 30)
    private String numeral;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "full_name")
    private String fullName;

    @JoinColumn(name = "type_code", referencedColumnName = "code", foreignKey = @ForeignKey(name = "type_code_key"))
    @ManyToOne
    private PersonDocType typeCode;


    public Document(String title, String series, String numeral) {
        this.title = title;
        this.series = series;
        this.numeral = numeral;
    }

    public Document() {

    }

}