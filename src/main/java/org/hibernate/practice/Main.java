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

        accountDao.addAccount(new Account("Tahir",
                "Hasanov","AZ21901512"));

        cardDao.addCard(new Card("AZ21901512",
                4169738818140825L,100D));
        merchantDao.addMerchant(new Merchant("CoffeeShop",
                "LogoCoffeeShop",0D));

    }
}