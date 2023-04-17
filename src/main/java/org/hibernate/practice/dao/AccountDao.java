package org.hibernate.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.practice.model.Account;
import org.hibernate.practice.util.ConnectionUtil;

import java.util.List;
import java.util.Objects;

public class AccountDao {
    public void addAccount(Account account) {
        Session session = ConnectionUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(account);
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

    public List<Account> selectAll() {
        try (Session session = ConnectionUtil.getSessionFactory().openSession()) {
            // HQL query to fetch all Persons
            return session.createQuery("FROM Account", Account.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteAccount(Account Account) {
        Transaction transaction = null;
        try (Session session = ConnectionUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(Account); // Delete Account
            transaction.commit();
        } catch (Exception ex) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }public Account getAccountByIban(String accountIban) {
        Session session = ConnectionUtil.getSessionFactory().openSession();
        Account account = null;
        try{
            return (Account) session.createQuery("from Account where iban = :accountIban")
                    .setParameter("accountIban" , accountIban).uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    public List<Account> getAccounts() {
        try {
            Session session = ConnectionUtil.getSessionFactory().openSession();
            return session.createQuery("FROM Account", Account.class).list();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
