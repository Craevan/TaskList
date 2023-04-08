package com.crevan.tasklist.repository.impl;

import com.crevan.tasklist.domain.task.Task;
import com.crevan.tasklist.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public Optional<Task> findById(final Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllByUserId(final Long userId) {
        return null;
    }

    @Override
    public void assignToUserById(final Long taskId, final Long userId) {

    }

    @Override
    public void update(final Task task) {

    }

    @Override
    public void create(final Task task) {

    }

    @Override
    public void delete(final Long id) {

    }
}
