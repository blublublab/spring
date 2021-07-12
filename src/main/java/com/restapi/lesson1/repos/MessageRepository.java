package com.restapi.lesson1.repos;


import com.restapi.lesson1.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
   List<Message> findByTag(String tag);

}