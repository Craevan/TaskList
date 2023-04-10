package com.crevan.tasklist.web.controller;

import com.crevan.tasklist.domain.task.Task;
import com.crevan.tasklist.service.TaskService;
import com.crevan.tasklist.web.dto.taks.TaskDto;
import com.crevan.tasklist.web.dto.validation.OnUpdate;
import com.crevan.tasklist.web.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/tasks")
@RequiredArgsConstructor
@Validated
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping(value = "/{id}")
    public TaskDto getById(@PathVariable final Long id) {
        Task task = taskService.getById(id);
        return taskMapper.toDto(task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Long id) {
        taskService.delete(id);
    }

    @PutMapping()
    public TaskDto update(@Validated(OnUpdate.class) @RequestBody final TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task updatedTask = taskService.update(task);
        return taskMapper.toDto(updatedTask);
    }
}
