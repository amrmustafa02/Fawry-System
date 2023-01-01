package src.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import src.models.Database;
import src.models.ServiceData;
import src.models.Transaction;

import java.util.ArrayList;

@RestController
public class AdminCtrl {
    private Database db;

    public AdminCtrl(Database db) {
        this.db = db;
    }

    @GetMapping(value = "/showMyRefundAdmin")
    public ArrayList<Transaction> showRefundRequest() {
        return db.getRefundRequests();
    }

    @PostMapping(value = "/acceptedRefund")
    public String acceptedRefund(@RequestBody int tid) {
        // if tid not found
        ArrayList<Transaction> transactions = db.getRefundRequests();
        for (Transaction transaction : transactions) {
            if (transaction.getTid() == tid) {
                //set transaction
                transaction.setStatus("Accepted Refund");
                return "refund is done";
            }
        }
        return "this id is not found";
    }

    @PostMapping(value = "/rejectedRefund")
    public String rejectedRefund(@RequestBody int tid) {
        // if tid not found
        ArrayList<Transaction> transactions = db.getRefundRequests();
        for (Transaction transaction : transactions) {
            if (transaction.getTid() == tid) {
                //set transaction
                transaction.setStatus("Rejected Refund ");
                return "refund is done";
            }
        }
        return "this id is not found";
    }

    @GetMapping(value = "/showAllServices")
    public ArrayList<ServiceData> showServiceData() {
        return db.getServices();
    }

    @PostMapping(value = "/addOverallDiscount")
    public String addOverallDiscount(@RequestBody int discount) {
        db.addOverAllDiscount(discount);
        return "added successfully";
    }

    @PostMapping(value = "/addSpecialDiscount")
    public String addSpecialDiscount(@RequestBody ArrayList<Integer> data) {
        if (data.size() < 2)
            return "wrong input";

        int sid = data.get(0);
        int discount = data.get(1);
        return db.addSpecialDiscount(sid, discount);
    }

}
