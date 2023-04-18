package org.hibernate.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.practice.model.Card;
import org.hibernate.practice.model.Merchant;
import org.hibernate.practice.util.ConnectionUtil;

import java.util.List;
import java.util.Objects;

public class CardDao {
    public void addCard(Card card) {
        Session session = ConnectionUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(card);
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

    public List<Card> selectAll() {
        try (Session session = ConnectionUtil.getSessionFactory().openSession()) {
            // HQL query to fetch all Persons
            return session.createQuery("FROM Card", Card.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCard(Card Card) {
        Transaction transaction = null;
        try (Session session = ConnectionUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(Card); // Delete Card
            transaction.commit();
        } catch (Exception ex) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }



    public void updateCard(Card card) {
        Session session = ConnectionUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(card);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Card getCardByPan(String panNumber) {
        Session session = ConnectionUtil.getSessionFactory().openSession();

        try {
            return (Card) session.createQuery("FROM Card WHERE panNumber = :panNumber")
                    .setParameter("panNumber", panNumber).uniqueResult();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    public String hidePanNumbers(String panNumber) {
        return "*".repeat(12) + panNumber.substring(12);
    }
}
