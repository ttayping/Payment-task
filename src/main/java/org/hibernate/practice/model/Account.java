package org.hibernate.practice.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "account_list")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "surname")
    private String surname;
    @NotNull
    @Column(name = "iban",unique = true)
    private String iban;

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
