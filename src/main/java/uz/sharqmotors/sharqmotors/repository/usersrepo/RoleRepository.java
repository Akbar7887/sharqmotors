package uz.sharqmotors.sharqmotors.repository.usersrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sharqmotors.sharqmotors.models.auth.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
