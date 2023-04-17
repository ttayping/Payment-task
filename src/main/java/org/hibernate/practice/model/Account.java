package org.hibernate.practice.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "account_list")

@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "iban")
    private String iban;

    public Account(){}
    public Account(String name, String surname, String iban) {
        this.name = name;
        this.surname = surname;
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", iban='" + iban + '\'' +
                '}';
    }
}
