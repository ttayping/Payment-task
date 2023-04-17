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
//
//        accountDao.addAccount(new Account("Aghaselim",
//                "Piriyev","AZ2178132"));
//
//        accountDao.addAccount(new Account("Xeyreddin",
//                "Agalarov","AZ2131254"));
//
//        cardDao.addCard(new Card("AZ2131254",
//                "4169738892654387",100D));
//        cardDao.addCard(new Card("AZ2131254",
//                "4169738867463289",100D));
//        cardDao.addCard(new Card("AZ2178132",
//                "4169738822643890",100D));
//        Card card1 = new Card("AZ2178132",
//                "4169738822643890L",100D);
//        Merchant merchant1 = new Merchant("CoffeeShop",
//                "LogoCoffeeShop",0D);
      //  System.out.println(operationDao.getCardByPan("4169738822643890"));
//operationDao.getCardByPan("4169738822643890");
       // operationDao.getOperation(card1,merchant1,4D);

//        merchantDao.addMerchant(new Merchant("CoffeeShop",
//                "LogoCoffeeShop",0D));
//        merchantDao.addMerchant(new Merchant("FastGood",
//                "LogoFastFood",0D));
//        merchantDao.addMerchant(new Merchant("Supermarket",
//                "LogoMarket",0D));


    }
}