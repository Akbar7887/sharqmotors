package uz.sharqmotors.sharqmotors.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.sharqmotors.sharqmotors.models.ACTIVE;
import uz.sharqmotors.sharqmotors.models.Customer;
import uz.sharqmotors.sharqmotors.models.CustomerOrder;
import uz.sharqmotors.sharqmotors.repository.CustomerOrderRepo;
import uz.sharqmotors.sharqmotors.repository.CustomerRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerOrderService {

    @Autowired
    final CustomerOrderRepo customerOrderRepo;
    final CustomerRepo customerRepo;

    public List<CustomerOrder> getAll() {
        return customerOrderRepo.findAll();
    }

    public CustomerOrder save(CustomerOrder customerOrder) {
        return customerOrderRepo.save(customerOrder);
    }

    public CustomerOrder remove(CustomerOrder customerOrder) {

        if (customerOrder.getActive() == ACTIVE.ACTIVE) {
            customerOrder.setActive(ACTIVE.NOACTIVE);
        } else {
            customerOrder.setActive(ACTIVE.ACTIVE);
        }
        return customerOrderRepo.save(customerOrder);
    }

    public CustomerOrder add(CustomerOrder customerOrder, String id) {

        Customer customer = customerRepo.getById(Long.parseLong(id));
        customerOrder.setCustomer(customer);
        return customerOrderRepo.save(customerOrder);
    }
}
