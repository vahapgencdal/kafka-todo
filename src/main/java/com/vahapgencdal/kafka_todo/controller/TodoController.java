package com.vahapgencdal.kafka_todo.controller;

import com.vahapgencdal.kafka_todo.kafka.KafkaProducerService;
import com.vahapgencdal.kafka_todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoController {

    private final KafkaProducerService producer;

    @Autowired
    TodoController(KafkaProducerService producer) {
        this.producer = producer;
    }


    @PostMapping(value = "/save")
    public ResponseEntity<Object> sendMessageToKafkaTopic(@RequestBody Todo todo) {
        this.producer.saveTodo(todo);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/save/list")
    public ResponseEntity<Object> sendMessageToKafkaTopic(@RequestBody List<Todo> todoList) {
        this.producer.saveTodoList(todoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}