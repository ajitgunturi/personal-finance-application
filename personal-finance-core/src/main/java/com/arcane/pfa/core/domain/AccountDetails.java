package com.arcane.pfa.core.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="account_details")
public class AccountDetails {

    @Id
    private long accountNumber;
    private String ifscCode;
    private String name;
    private String accountType;
    private double accountBalance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserDetails user;
}
