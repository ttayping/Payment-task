package org.hibernate.practice;

import org.hibernate.practice.dao.AccountDao;
import org.hibernate.practice.dao.CardDao;
import org.hibernate.practice.dao.MerchantDao;
import org.hibernate.practice.dao.OperationDao;
import org.hibernate.practice.model.Account;
import org.hibernate.practice.model.Card;
import org.hibernate.practice.model.Merchant;

import static org.hibernate.tool.schema.extract.internal.IndexInformationImpl.builder;

public class Main {
    public static void main(String[] args) {
        AccountDao accountDao = new AccountDao();
        CardDao cardDao = new CardDao();
        MerchantDao merchantDao = new MerchantDao();
        OperationDao operationDao = new OperationDao();

        Account account1 = Account.builder()
                .name("Tahir")
                .surname("Khan")
                .Iban("123456789")
                .build();

        Card card1 = Card.builder().panNumber(4169738818010425L).
                cardBalance(100D).accountIban("25634516").build();
        Merchant merchant1 = Merchant.builder().name("CoffeeMoffee")
                .balance(0D).url("logoCoffeeMoffee").build();

    }
}