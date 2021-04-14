package com.casestudy.paymentservice.service;

import com.casestudy.paymentservice.model.Payment;
import com.casestudy.paymentservice.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }

    public Payment addPayment(Payment payment) {
        payment.setPayment_status(paymentProcessing());
        payment.setTransaction_id(UUID.randomUUID().toString());
        return paymentRepo.insert(payment);
    }

    public Payment updatePayment(Payment payment) {
        payment.setTransaction_id(UUID.randomUUID().toString());
        payment.setPayment_status(paymentProcessing());
        return paymentRepo.save( payment);
    }

    public void deletePayment(String id) {
        paymentRepo.deleteById(id);
    }

    public Optional<Payment> getPayment(@PathVariable String id) { return paymentRepo.findById(id); }

    public String paymentProcessing(){
        return new Random().nextBoolean()?"success":"faliure";
    }

}
