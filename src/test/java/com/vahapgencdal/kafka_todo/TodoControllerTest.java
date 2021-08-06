package com.vahapgencdal.kafka_todo;

import com.vahapgencdal.kafka_todo.model.Todo;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void saveTodo() throws Exception {

        Todo todo = new Todo();
        todo.setTodoId(1);
        todo.setSubject("subject");
        todo.setMessage("message");

        assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/api/todo/save", todo, ResponseEntity.class).getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    public void saveTodoList() throws Exception {

        Todo todo = new Todo();
        todo.setTodoId(1);
        todo.setSubject("subject 1");
        todo.setMessage("message 1");

        Todo todo2 = new Todo();
        todo2.setTodoId(2);
        todo2.setSubject("subject 2");
        todo2.setMessage("message 2");

        List<Todo> todoList = new ArrayList<>();
        todoList.add(todo);
        todoList.add(todo2);

        assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/api/todo/save/list", todoList, ResponseEntity.class).getStatusCode().equals(HttpStatus.OK));
    }
}