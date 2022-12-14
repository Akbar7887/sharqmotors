package uz.sharqmotors.sharqmotors.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.sharqmotors.sharqmotors.models.Customer;
import uz.sharqmotors.sharqmotors.service.CustomerService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/sharq/")
public class CustomerResource {

    final CustomerService customerService;

    @GetMapping("customerget")
    private ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok().body(customerService.getAll());
    }

    @PostMapping("customeradd")
    private ResponseEntity<Customer> add(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(customerService.add(customer));
    }

}
