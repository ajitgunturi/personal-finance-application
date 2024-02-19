package com.arcane.pfa.core.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user_details", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uuid;
    private String name;
    private String username;
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountDetails> accounts = new ArrayList<>();

    public void addAccount(AccountDetails account) {
        accounts.add(account);
        account.setUser(this);
    }

    public void removeAccount(AccountDetails account) {
        accounts.remove(account);
        account.setUser(null);
    }
}
