package org.hibernate.practice.model;

import com.sun.istack.NotNull;
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
    @NotNull
    @Column(name = "name",unique = true)
    private String name;
    @NotNull
    @Column(name = "url",unique = true)
    private String url;
    @NotNull
    @Column(name = "balance")
    private Double balance;

    @Override
    public String toString() {
        return "Merchant{" +
                "merchantId=" + merchantId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", balance=" + balance +
                '}';
    }
}
