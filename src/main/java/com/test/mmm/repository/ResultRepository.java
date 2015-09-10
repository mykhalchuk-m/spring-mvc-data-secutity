package com.test.mmm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.test.mmm.entity.Result;

/**
 * Created by Marian_Mykhalchuk on 9/9/2015.
 */
@Component
public interface ResultRepository extends CrudRepository<Result, Long> {
}
