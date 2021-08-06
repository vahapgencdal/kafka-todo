package com.vahapgencdal.kafka_todo.kafka;

import com.vahapgencdal.kafka_todo.model.Todo;
import com.vahapgencdal.kafka_todo.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaProducerService
{
    private static final Logger logger =
            LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void saveTodo(Todo todo)
    {
        logger.info(String.format("Todo created -> %s", todo));
        this.kafkaTemplate.send(Constants.TOPIC_NAME_TODO_LOG, todo);
    }

    public void saveTodoList(List<Todo> todoList)
    {
        todoList.parallelStream().forEach(todo -> {
            logger.info(String.format("Todo created -> %s", todo));
            this.kafkaTemplate.send(Constants.TOPIC_NAME_TODO_LOG, todo);
        });
    }
}