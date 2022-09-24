package uz.sharqmotors.sharqmotors.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sharqmotors.sharqmotors.models.Customer;
import uz.sharqmotors.sharqmotors.repository.CustomerRepo;


import java.io.Serializable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements Serializable {


    @Autowired
    final CustomerRepo customerRepo;
    final ModelService modelService;

    public List<Customer> getAll(){
        return customerRepo.findAll();
    }

    public Customer add(Customer customer){

        Customer findCustomer = customerRepo.findByPhone(customer.getPhone());
        if(findCustomer == null){
            findCustomer = new Customer();
        }
        findCustomer.setEmail(customer.getEmail());
        findCustomer.setName(customer.getName());
        findCustomer.setPhone(customer.getPhone());

        return customerRepo.save(findCustomer);

    }
}
