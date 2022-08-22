package uz.sharqmotors.sharqmotors.service.usersservice;


import uz.sharqmotors.sharqmotors.models.auth.AppUser;
import uz.sharqmotors.sharqmotors.models.auth.Role;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);

    AppUser getUser(String username);

    List<AppUser> getUser();


    void delete(AppUser appUser1);
}
