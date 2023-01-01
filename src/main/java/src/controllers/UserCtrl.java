package src.controllers;


import javafx.util.Pair;
import src.abstractFactory.FactoryProviders.ServiceProvider;

import src.abstractFactory.Products.IHandler;
import src.decorter.OverallDiscounts;
import src.decorter.SpecialDiscount;
import src.models.Database;
import src.models.ServiceData;
import src.models.Transaction;
import src.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

import src.payment.Cash;
import src.payment.CreditCard;
import src.payment.IPaymentMethod;
import src.payment.Wallet;

@RestController
public class UserCtrl {

    private Database db;

    public UserCtrl(Database db) {
        this.db = db;
    }

    @PostMapping(value = "/signUp")
    public String signUp(@RequestBody User user) {
        return db.addNewUser(user);
    }

    @PostMapping(value = "/signIn")
    public String signIn(@RequestBody ArrayList<String> data) {
        if (data.size() != 2) {
            return "Missed value (email or password) and put email in first param and password in second param";
        }
        return db.CheckUser(data.get(0), data.get(1));
    }

    @GetMapping(value = "/profile")
    public User getCurUser() {
        return db.getCurUser();
    }

    private boolean isMatching(String base, String serviceName) {
        int firstChar = base.charAt(0);

        for (int i = 0; i < serviceName.length(); i++) {

            if (serviceName.charAt(i) == firstChar) {
                int j = i;  // 4
                int sum = 0; // count number of matching char

                for (int baseIndex = 0; baseIndex < base.length() && j < serviceName.length(); baseIndex++, j++) {
                    if (base.charAt(baseIndex) == serviceName.charAt(j)) sum++;
                    else break;
                }

                if (sum == base.length())
                    return true;
            }
        }

        return false;
    }

    @GetMapping(value = "/serviceSearch/{serviceName}")
    public ArrayList<ServiceData> getMatchingServices(@PathVariable("serviceName") String serviceName) {

        ArrayList<ServiceData> outPut = new ArrayList<>();

        for (ServiceData serviceData : db.getServices()) {

            if (isMatching(serviceName.toLowerCase(), serviceData.getName().toLowerCase()))
                outPut.add(serviceData);

        }

        return outPut;
    }










    @GetMapping(value = "/service/{serviceId}")
    public ArrayList<String> getServiceForm(@PathVariable("serviceId") int id) {
        return db.getForm(id);
    }


    @PostMapping(value = "/payService")
    public String payService(@RequestBody ArrayList<String> inputs) {
        // handle if array is small
        if (inputs.size() < 1)
            return "Wrong data";

        // start new transaction
        Transaction newTransaction = new Transaction();

        /*
        convert id to int and send it to database ti get provider to this service
         */
        ServiceProvider provider;
        try {

            int id2 = Integer.parseInt(inputs.get(0));
            provider = db.getProvider(id2);

            // if now provider with this id
            if (provider == null)
                return "No provider for this id,please check about id";

            // set name of service in transaction and sid
            newTransaction.setService(db.getNameOfService(id2));
            newTransaction.setSid(id2);

        } catch (Exception e) {
            return "please check about id is int";
        }

        // get handler from factory
        IHandler handler = provider.getHandler();

        String check = handler.handleForm(inputs, newTransaction);

        // if all data is non-correct
        if (!check.equals("ok"))
            return check;


        // handle payment method
        IPaymentMethod paymentMethod = null;


        try {
            String pay = inputs.get(3);
            int pay2 = Integer.parseInt(pay);
            if (pay2 == 1)
                paymentMethod = new Cash();
            if (pay2 == 2)
                paymentMethod = new CreditCard();
            if (pay2 == 3)
                paymentMethod = new Wallet();

        } catch (Exception e) {
            return "Please check payment method input ,please enter integer and must be in position 3 in inputs";
        }


        // check if payment is correct
        if (paymentMethod == null)
            return "please enter integer in payment method between 1 and 3";


        try {
            newTransaction = paymentMethod.Pay(newTransaction, db);
            if (newTransaction == null) {
                return "no amount money in wallet(Note:this amount before apply discounts)";
            }
            // add over all discount
            paymentMethod = new OverallDiscounts(paymentMethod, db);
            newTransaction = paymentMethod.Pay(newTransaction, db);

            // add special discount
            paymentMethod = new SpecialDiscount(paymentMethod, db);
            newTransaction = paymentMethod.Pay(newTransaction, db);

        } catch (Exception e) {
            return "Error";
        }

        // add cur transaction to cur user
        db.getCurUser().addTransaction(newTransaction);
        newTransaction.setId();


        return "Transaction successfully, id of transaction is:  " + newTransaction.getTid();
    }










    @PostMapping(value = "/addToWallet")
    String addToWallet(@RequestBody float amount) {
        if (db.getCurUser() == null) {
            return "please sign in first";
        }

        db.getCurUser().addToWallet(amount);
        return "add to wallet successfully";
    }

    @PostMapping(value = "/refundRequest")
    public String addRefundRequest(@RequestBody int id) {


        // check if user not sign in
        if (db.getCurUser() == null) {
            return "please sign in first";
        }

        ArrayList<Transaction> userTransactions = db.getCurUser().getTransactions();

        // search on id in user transaction
        for (Transaction transaction : userTransactions) {
            if (transaction.getTid() == id) {
                // search if this id is not in refund request before
                ArrayList<Transaction> refundRequests = db.getRefundRequests();

                for (Transaction refund : refundRequests) {
                    if (refund.getTid() == id) {
                        return "this refund is exist";
                    }
                }
                // set stat is waiting
                transaction.setStatus("waiting");

                // ada refund in list to show to admin
                db.addRefundRequest(transaction);

                // remove from normal transaction and add it in refund transaction
                db.getCurUser().removeFromTransaction(id);

                return "send refund to admin successfully";

            }
        }

        return "this transaction not found in your transaction";

    }

    @GetMapping(value = "/showMyRefund")
    public ArrayList<Transaction> showMyRefundTransactions() {
        if (db.getCurUser() == null)
            return new ArrayList<>();
        return db.getCurUser().getRefundTransactions();
    }

}
