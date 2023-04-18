package org.hibernate.practice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.practice.model.Merchant;
import org.hibernate.practice.util.ConnectionUtil;

import java.util.List;
import java.util.Objects;

public class MerchantDao {
    public void addMerchant(Merchant merchant) {
        Session session = ConnectionUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(merchant);
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
    public void updateMerchant(Merchant merchant) {
        Session session = ConnectionUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(merchant); // Update operation
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

    public List<Merchant> selectAll() {
        try (Session session = ConnectionUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Merchant", Merchant.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteMerchant(Merchant Merchant) {
        Transaction transaction = null;
        try (Session session = ConnectionUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(Merchant);
            transaction.commit();
        } catch (Exception ex) {
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public Merchant getMerchantByName(String merchantName){
        Session session = ConnectionUtil.getSessionFactory().openSession();
        try{
            return (Merchant) session.createQuery("from Merchant where name = :merchantName")
                    .setParameter("merchantName" , merchantName).uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
