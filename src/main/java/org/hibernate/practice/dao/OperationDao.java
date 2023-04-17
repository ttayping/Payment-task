package org.hibernate.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.practice.model.Account;
import org.hibernate.practice.model.Card;
import org.hibernate.practice.model.Merchant;
import org.hibernate.practice.model.Operation;
import org.hibernate.practice.util.ConnectionUtil;
import org.hibernate.query.Query;

import java.util.Currency;
import java.util.List;
import java.util.Objects;

public class OperationDao {

    public void getOperation(Card card, Merchant merchant, Double amount) {      // don't forger add currency

        System.out.println( card.getAccountIban());
        System.out.println(merchant.getUrl());
        Session session = ConnectionUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
        card.setCardBalance(card.getCardBalance()-amount);
        merchant.setBalance(merchant.getBalance()+amount);
            transaction.commit();}
        catch (Exception exception){
            if (transaction!=null){
                transaction.rollback();
            }exception.printStackTrace();
        }
    }

    public String hidePanNumbers(String panNumber) {
        return "*".repeat(12) + panNumber.substring(12);
    }

//    public Account getAccountByIban(String accountIban) {
//        List<Account> accountList = getAccounts();
//        accountList.forEach(account -> {
//            if (account.getIban() == accountIban) {
//                return account;
//            }
//        });
//        return null;
//    }

    public List<Account> getAccounts() {
        try {
            Session session = ConnectionUtil.getSessionFactory().openSession();
            return session.createQuery("FROM Account", Account.class).list();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }


    public void addOperation(Operation operation) {
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

    public List<Operation> selectAll() {
        try (Session session = ConnectionUtil.getSessionFactory().openSession()) {
            // HQL query to fetch all Persons
            return session.createQuery("FROM Operation", Operation.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteOperation(Operation Operation) {
        Transaction transaction = null;
        try (Session session = ConnectionUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(Operation); // Delete operation
            transaction.commit();
        } catch (Exception ex) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
