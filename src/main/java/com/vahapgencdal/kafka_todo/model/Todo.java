package com.vahapgencdal.kafka_todo.model;

public class Todo {
    private long todoId;
    private String subject;
    private String message;

    public long getTodoId() {
        return todoId;
    }

    public void setTodoId(long todoId) {
        this.todoId = todoId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Todo [todoId=" + todoId + ", subject="
                + subject + ", message=" + message + "]";
    }
}
