package com.restapi.lesson1;
import com.restapi.lesson1.domain.Message;
import com.restapi.lesson1.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String,Object> model){
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
       model.put("messages", messageRepository.findAll());
       return "main";
    }


    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag , Map<String, Object> model){
        Message message = new Message(text, tag);
        messageRepository.save(message);
        model.put("messages", messageRepository.findAll());
        return "main";
    };

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        List<Message> messages  = messageRepository.findByTag(filter);
        if(filter == null|| !filter.isEmpty()){
           model.put("messages", messages);
       } else {
            model.put("messages", messageRepository.findAll());
        }
        return "main";
    }
}
