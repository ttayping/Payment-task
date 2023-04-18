package org.hibernate.practice;

import org.hibernate.practice.dao.AccountDao;
import org.hibernate.practice.dao.CardDao;
import org.hibernate.practice.dao.MerchantDao;
import org.hibernate.practice.dao.OperationDao;
import org.hibernate.practice.model.Account;
import org.hibernate.practice.model.Card;
import org.hibernate.practice.model.Merchant;

public class Main {
    public static void main(String[] args) {
        AccountDao accountDao = new AccountDao();
        CardDao cardDao = new CardDao();
        MerchantDao merchantDao = new MerchantDao();
        OperationDao operationDao = new OperationDao();
//        Card card = Card.builder().cardBalance(100.00)
//                .accountIban("jhn5546554")
//                .panNumber("1234567891236547").build();
//        cardDao.addCard(card);
//        Account account = Account.builder().iban("jhn5546554")
//                .name("Agalar").surname("Mirmemmedli")
//                .build();
//        accountDao.addAccount(account);
//        Merchant merchant = Merchant.builder().url("gdkjhsiu")
//                .balance(10000.0).name("Starbucks").build();
//merchantDao.addMerchant(merchant);
//        Card card2 = Card.builder().cardBalance(100.00)
//                .accountIban("az41236491")
//                .panNumber("1234567891239966").build();
//        cardDao.addCard(card2);
//        Account account2 = Account.builder().iban("az41236491")
//                .name("Sexavet").surname("Garayev")
//                .build();
//        accountDao.addAccount(account2);
//        Merchant merchant2 = Merchant.builder().url("logoCoffee")
//                .balance(0.0).name("CoffeeShop").build();
//        merchantDao.addMerchant(merchant2);


        operationDao.createOperation("1234567891239966","CoffeeShop",10D);
    }



}

