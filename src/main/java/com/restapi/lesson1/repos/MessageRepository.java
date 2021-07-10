package com.restapi.lesson1.repos;


import com.restapi.lesson1.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MessageRepository extends CrudRepository<Message, Integer> {
   List<Message> findByTag(String tag);

}