package org.example.bankapi.security;

import org.example.bankapi.entity.Account;
import org.example.bankapi.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailService implements UserDetailsService {
    private final AccountsRepository accountsRepository;

    @Autowired
    public CustomerDetailService(AccountsRepository accountsRepository) {
        this.accountsRepository=accountsRepository;
    }

    public UserDetails loadUserByUsername(String username){
        long accountNumber=Long.parseLong(username);
        Account account=accountsRepository.findById(accountNumber).
                orElseThrow(()->new UsernameNotFoundException(username+" not found"));

        return User.builder().
                username(String.valueOf(account.getAccountNumber())).
                password(account.getPassword()).
                build();
    }

}
