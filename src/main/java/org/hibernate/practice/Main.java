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

    }
}