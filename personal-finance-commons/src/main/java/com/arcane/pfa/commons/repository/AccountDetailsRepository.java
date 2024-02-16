package com.arcane.pfa.commons.repository;

import com.arcane.pfa.commons.domain.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
}
