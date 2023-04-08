package com.crevan.tasklist.service.impl;

import com.crevan.tasklist.domain.task.Task;
import com.crevan.tasklist.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public Task getById(final Long id) {
        return null;
    }

    @Override
    public List<Task> getAllByUserId(final Long userId) {
        return null;
    }

    @Override
    public Task update(final Task task) {
        return null;
    }

    @Override
    public Task create(final Task task) {
        return null;
    }

    @Override
    public void delete(final Long id) {

    }
}
