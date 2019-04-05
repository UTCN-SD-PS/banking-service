package utcn.labs.sd.bankingservice.domain.service;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utcn.labs.sd.bankingservice.domain.data.converter.AccountConverter;
import utcn.labs.sd.bankingservice.domain.data.entity.Account;
import utcn.labs.sd.bankingservice.domain.data.repository.AccountRepository;
import utcn.labs.sd.bankingservice.domain.dto.AccountDTO;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<AccountDTO> getAllAccounts() {
        return AccountConverter.toDto(accountRepository.findAll());
    }

    public AccountDTO getAccountById(Integer accountId) throws Exception {
        Account account = accountRepository.findById(accountId).orElse(null);
        if (account == null) throw new NotFoundException("No account found with that accountId");
        return AccountConverter.toDto(account);
    }

    public AccountDTO createAccount(AccountDTO accountDto) throws Exception {
        Timestamp currentTimestamp = new Timestamp(Instant.now().toEpochMilli());
        if (accountDto.getBalance() < 0) {
            throw new Exception("Impossible to have a negative balance");
        }
        Account account = new Account(accountDto.getAccountId(), accountDto.getAccountType(), currentTimestamp.toString(), accountDto.getBalance());
        Account newAccount = accountRepository.save(account);
        return AccountConverter.toDto(newAccount);
    }


    public AccountDTO updateAccount(Integer accountId, AccountDTO accountDto) throws Exception {
        Account account = accountRepository.findById(accountId).orElse(null);
        if (account == null) {
            throw new NotFoundException("No account found with that id");
        }

        if (accountDto.getBalance() != null) {
            account.setBalance(accountDto.getBalance());
        }
        if (accountDto.getAccountType() != null) {
            account.setAccountType(accountDto.getAccountType());
        }
        return AccountConverter.toDto(accountRepository.save(account));
    }


    public void deleteAccount(Integer accountId) throws Exception {
        Account account = accountRepository.findById(accountId).orElse(null);
        if (account == null) {
            throw new NotFoundException("No account with that accountId");
        }
        accountRepository.delete(account);
    }


}
