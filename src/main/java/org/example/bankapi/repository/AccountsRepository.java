package org.example.bankapi.repository;

import org.example.bankapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsRepository extends JpaRepository<Account, Long> {


}
