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

    public void getOperation(Card card, Merchant merchant, Double amount) { // don't forget add currency


        System.out.println(merchant.getUrl());
        Session session = ConnectionUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            card.setCardBalance(card.getCardBalance() - amount);
            merchant.setBalance(merchant.getBalance() + amount);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public String hidePanNumbers(String panNumber) {
        return "*".repeat(12) + panNumber.substring(12);
    }

    public Card getCardByPrimaryKey(String panNumber) {
        Session session = ConnectionUtil.getSessionFactory().openSession();
        try {
            return session.get(Card.class, panNumber);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;}

    public Card getCardByPan(String panNumber){
        Session session=ConnectionUtil.getSessionFactory().openSession();
        try {
            return (Card) session.createQuery("FROM Card WHERE panNumber = :panNumber")
                    .setParameter("panNumber", panNumber).uniqueResult();
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
    return null;}


}
