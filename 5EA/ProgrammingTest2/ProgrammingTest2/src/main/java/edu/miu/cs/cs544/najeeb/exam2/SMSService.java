package edu.miu.cs.cs544.najeeb.exam2;

public class SMSService {

    Verizon phoneServiceProvider;

    public SMSService(Verizon phoneServiceProvider) {
        this.phoneServiceProvider = phoneServiceProvider;
    }

    void sendMessage(String message, String phoneNumber) {
        if (null != phoneServiceProvider) {
            if (phoneServiceProvider.hasSufficientBalance() && phoneServiceProvider.isAuthorized()) {
                if (phoneServiceProvider.openService()) {
                    System.out.println("Sending message "+message+ " to number "+ phoneNumber);
                }
            } else {
                System.out.println("Insufficient balance in phone service account.");
            }
        } else {
            System.out.println("Cannot send message not phone service provider exists.");
        }
    }
}
