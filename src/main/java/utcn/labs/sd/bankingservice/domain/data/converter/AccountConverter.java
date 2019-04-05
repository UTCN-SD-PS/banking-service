package utcn.labs.sd.bankingservice.domain.data.converter;


import utcn.labs.sd.bankingservice.domain.data.entity.Account;
import utcn.labs.sd.bankingservice.domain.dto.AccountDTO;

import java.util.ArrayList;
import java.util.List;


public class AccountConverter {

    private AccountConverter() {
    }

    public static AccountDTO toDto(Account entity) {
        AccountDTO dto = null;
        if (entity != null) {
            dto = new AccountDTO(entity.getAccountId(), entity.getAccountType(), entity.getCreationDate(), entity.getBalance());
        }
        return dto;
    }


    public static List<AccountDTO> toDto(List<Account> entityList) {
        List<AccountDTO> accountDtos = new ArrayList<>();
        if ((entityList != null) && (!entityList.isEmpty())) {
            for (Account model : entityList) {
                accountDtos.add(toDto(model));
            }
        }
        return accountDtos;
    }
}
