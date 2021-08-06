package com.vahapgencdal.kafka_todo.kafka;

import com.vahapgencdal.kafka_todo.model.Todo;
import com.vahapgencdal.kafka_todo.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService
{
    private final Logger logger
            = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = Constants.TOPIC_NAME_TODO_LOG, groupId = Constants.GROUP_ID)
    public void consume(Todo todo) {
        logger.info(String.format("Todo created -> %s", todo));
    }
}