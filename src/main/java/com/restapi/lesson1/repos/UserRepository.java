package com.restapi.lesson1.repos;

import com.restapi.lesson1.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
