package com.mapper;


import com.entity.Account;
import com.entity.Transction;
import com.entity.dto.AccountResponse;
import com.entity.dto.TransactionResponse;
import com.entity.dto.UserResponse;

public class TransactionMapper {

    public static TransactionResponse toDTO(Transction t) {

        TransactionResponse dto = new TransactionResponse();

        dto.setId(t.getId());
        dto.setAmount(t.getAmount());
        dto.setType(t.getType());
        dto.setDate(t.getDate());

        if (t.getSenderAccount() != null) {
            dto.setSenderAccount(toAccountDTO(t.getSenderAccount()));
        }

        if (t.getReceiverAccount() != null) {
            dto.setReceiverAccount(toAccountDTO(t.getReceiverAccount()));
        }

        return dto;
    }

    private static AccountResponse toAccountDTO(Account account) {

        AccountResponse dto = new AccountResponse();

        dto.setAccountId(account.getAccount_id());
        dto.setBalance(account.getBalance());
        dto.setAccountType(account.getAccount_type());

        UserResponse userDTO = new UserResponse();
        userDTO.setId(account.getUser().getId());
        userDTO.setName(account.getUser().getName());
        userDTO.setEmail(account.getUser().getEmail());
        userDTO.setRole(account.getUser().getRole());

        dto.setUser(userDTO);

        return dto;
    }
}
