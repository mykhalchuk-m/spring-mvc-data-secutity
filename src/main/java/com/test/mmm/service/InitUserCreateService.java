package com.test.mmm.service;

import com.test.mmm.entity.User;
import com.test.mmm.entity.UserRole;
import com.test.mmm.repository.UserRepository;

/**
 * Created by Marian_Mykhalchuk on 9/9/2015.
 */
public class InitUserCreateService {
    public InitUserCreateService(UserRepository userRepository) {
        createAdmin(userRepository);
        createUser(userRepository);
    }

    private void createAdmin(UserRepository userRepository) {
        User admin = new User();
        admin.setFirstName("admin");
        admin.setFamilyName("family1");
        admin.setEmail("my1@mail.box");
        admin.setUserRole(UserRole.ROLE_ADMIN);
        userRepository.save(admin);
    }

    private void createUser(UserRepository userRepository) {
        User user = new User();
        user.setFirstName("user");
        user.setFamilyName("family2");
        user.setEmail("my2@mail.box");
        user.setUserRole(UserRole.ROLE_USER);
        userRepository.save(user);
    }
}
