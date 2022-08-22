package uz.sharqmotors.sharqmotors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.sharqmotors.sharqmotors.models.CustomerOrder;

@Repository
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, Long> {

//    @Query("select c from customer_order c where c.active = :active")
//    List<CustomerOrder> getAllActive(ACTIVE active);
}
