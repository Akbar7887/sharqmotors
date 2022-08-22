package uz.sharqmotors.sharqmotors.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.sharqmotors.sharqmotors.models.CustomerOrder;
import uz.sharqmotors.sharqmotors.service.CustomerOrderService;

import java.util.List;


@RequestMapping("/custom/")
@RequiredArgsConstructor
@RestController
public class CustomerOrderResource {

    final CustomerOrderService customerOrderService;

    @GetMapping("customerorderget")
    private ResponseEntity<List<CustomerOrder>> getall() {
        return ResponseEntity.ok().body(customerOrderService.getAll());
    }

    @PostMapping(value = "customerorderpost")
    private ResponseEntity<CustomerOrder> save(@RequestBody CustomerOrder customerOrder) {
        return ResponseEntity.ok().body(customerOrderService.save(customerOrder));
    }

    @PostMapping("customerorderremove")
    private ResponseEntity<CustomerOrder> remove(@RequestBody CustomerOrder customerOrder) {
        return ResponseEntity.ok().body(customerOrderService.remove(customerOrder));
    }

    @PostMapping(value = "customerorderadd")
    private ResponseEntity<CustomerOrder> add(@RequestBody CustomerOrder  customerOrder, @RequestParam("customer_id") String id) {
        return ResponseEntity.ok().body(customerOrderService.add(customerOrder, id));
    }
}
