package org.hibernate.practice.model;
//id logo name
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "merchants")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long merchantId;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "balance")
    private Double balance;

    public Merchant(String name, String url, Double balance) {
        this.name = name;
        this.url = url;
        this.balance = balance;
    }
}
