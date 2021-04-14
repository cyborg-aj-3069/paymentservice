package com.casestudy.paymentservice.repository;

import com.casestudy.paymentservice.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepo extends MongoRepository<Payment,Integer> {
    Optional<Payment> findById(String id);

    void deleteById(String id);
}
