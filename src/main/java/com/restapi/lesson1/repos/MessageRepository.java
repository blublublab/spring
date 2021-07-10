package com.restapi.lesson1.repos;


import com.restapi.lesson1.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
public interface MessageRepository extends CrudRepository<Message, Integer> {
   List<Message> findByTag(String tag);

}