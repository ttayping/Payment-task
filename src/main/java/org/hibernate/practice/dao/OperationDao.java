package org.hibernate.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.practice.model.Card;
import org.hibernate.practice.model.Merchant;
import org.hibernate.practice.model.Operation;
import org.hibernate.practice.util.ConnectionUtil;

import java.util.List;
import java.util.Objects;

public class OperationDao {
    MerchantDao merchantDao = new MerchantDao();
    CardDao cardDao = new CardDao();
    AccountDao accountDao = new AccountDao();

    private void addOperation(Operation operation) {
        Session session = ConnectionUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(operation);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void createOperation(String panNumber, String merchantName, Double amount) { // don't forget add currency
        Operation operation = new Operation(panNumber, merchantName, amount);
        try {
            balanceOperation(operation);
            addOperation(operation);
            showOperationInfo(operation);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void balanceOperation(Operation operation) {
        try {
            Merchant merchant = merchantDao.getMerchantByName(operation
                    .getMerchantName());

            Card card = cardDao.getCardByPan(operation.getCardPan());
            card.setCardBalance(card.getCardBalance() - operation.getAmount());
            merchant.setBalance(merchant.getBalance() + operation.getAmount());
            merchantDao.updateMerchant(merchant);
            cardDao.updateCard(card);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void showOperationInfo(Operation operation) {
        System.out.println("Merchant logo" + merchantDao.getMerchantByName(operation
                .getMerchantName()).getUrl());
        System.out.println(cardDao.hidePanNumbers(operation.getCardPan()));
        System.out.println(accountDao.getAccountByIban(cardDao
                .getCardByPan(operation.getCardPan()).getAccountIban()));
    }
}
