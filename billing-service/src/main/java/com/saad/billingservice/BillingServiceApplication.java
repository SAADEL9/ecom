package com.saad.billingservice;

import com.saad.billingservice.entities.Bill;
import com.saad.billingservice.entities.ProductItem;
import com.saad.billingservice.model.Customer;
import com.saad.billingservice.model.Product;
import com.saad.billingservice.repository.BillRepository;
import com.saad.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository){

        return args -> {
            List<Long> customersIds = List.of(1L,2L,3L);
            List<Long> productsIds = List.of(1L,2L,3L);

            customersIds.forEach(clientId -> {
                Bill bill = new Bill();
                        bill.setBillingDate(new Date());
                        bill.setCustomerId(clientId);
                billRepository.save(bill);
                productsIds.forEach(productId -> {
                    ProductItem productItem = new ProductItem();
                    productItem.setPrice(1000*Math.random()*600);
                    productItem.setQuantity(1+new Random().nextInt(20));
                    productItem.setProductId(productId);
                    productItem.setBill(bill);

                    productItemRepository.save(productItem);
                });
            });
        };
    }

}