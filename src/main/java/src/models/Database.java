package src.models;

import src.abstractFactory.FactoryProviders.*;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class Database {

    private final ArrayList<User> users;
    private final ArrayList<ServiceData> services;
    private User curUser;
    private int overAllDiscounts;
    private HashMap<Integer, Integer> specialDiscounts;
    private ArrayList<Transaction> refundRequests;


    public Database() {
        this.users = new ArrayList<>();
        this.services = new ArrayList<>();
        this.specialDiscounts = new HashMap<>();
        refundRequests = new ArrayList<>();

        // add services data
        services.add(new ServiceData("we internet", new WeFactory()));
        services.add(new ServiceData("we mobile", new WeFactory()));
        services.add(new ServiceData("orange internet", new OrangeFactory()));
        services.add(new ServiceData("orange mobile", new OrangeFactory()));
        services.add(new ServiceData("vodafone internet", new VodafoneFactory()));
        services.add(new ServiceData("vodafone mobile", new VodafoneFactory()));
        services.add(new ServiceData("Etisalat internet", new EtisalatFactory()));
        services.add(new ServiceData("Etisalat mobile", new EtisalatFactory()));
        services.add(new ServiceData("Monthly receipt", new LandlineFactory()));
        services.add(new ServiceData("Quarter receipt", new LandlineFactory()));
        services.add(new ServiceData("Cancer Hospital(Donation)", new DonationsFactory()));
        services.add(new ServiceData("Schools(Donation)", new DonationsFactory()));
        services.add(new ServiceData("NGOs (Non profitable organizations)(Donation)", new DonationsFactory()));

    }

    public String addNewUser(@RequestBody User newUser) {
        for (User user : users)
            if (user.getEmail().equals(newUser.getEmail()))
                return "user is exist";

        users.add(newUser);

        return "Sign ip successfully";

    }

    public String CheckUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                curUser = user;
                return "Sign in successfully, and your username is: " + user.getUserName();
            }
        }
        return "please sign up first";
    }

    public ArrayList<ServiceData> getServices() {
        return services;
    }

    public ArrayList<String> getForm(int id) {
        for (ServiceData serviceData : services) {
            if (serviceData.getId() == id) {
                return serviceData.getForm();
            }
        }
        return null;
    }

    public ServiceProvider getProvider(int id) {

        for (ServiceData serviceData : services)
            if (serviceData.getId() == id)
                return serviceData.serviceProvider();
        return null;
    }

    public User getCurUser() {
        return curUser;
    }

    public int getOverAllDiscounts() {
        return this.overAllDiscounts;
    }

    public String getNameOfService(int id) {
        for (ServiceData serviceData : services) {
            if (serviceData.getId() == id) {
                return serviceData.getName();
            }
        }
        return "no such service";
    }

    public String addSpecialDiscount(int id, int discount) {

        for (ServiceData serviceData : services) {
            if (serviceData.getId() == id) {
                serviceData.setDiscount(discount);
                return "add discount";
            }
        }
        return "no such service with this id";

    }

    public ArrayList<Transaction> getRefundRequests() {

        return refundRequests;
    }

    public void addRefundRequest(Transaction t) {
        refundRequests.add(t);
    }

    public void addOverAllDiscount(int discount) {
        this.overAllDiscounts = discount;
    }

    public int getSpecialDiscount(int sid) {
        for (ServiceData serviceData : services) {
            if (serviceData.getId() == sid)
                return serviceData.getDiscount();
        }
        return 0;
    }
}

