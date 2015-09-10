package com.test.mmm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.test.mmm.entity.User;

/**
 * Created by Marian_Mykhalchuk on 9/9/2015.
 */
@Component
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstName);
}
