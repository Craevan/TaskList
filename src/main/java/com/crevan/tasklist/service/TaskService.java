package com.crevan.tasklist.service;

import com.crevan.tasklist.domain.task.Task;

import java.util.List;

public interface TaskService {

    Task getById(final Long id);

    List<Task> getAllByUserId(final Long userId);

    Task update(final Task task);

    Task create(final Task task, final Long id);

    void delete(final Long id);
}
