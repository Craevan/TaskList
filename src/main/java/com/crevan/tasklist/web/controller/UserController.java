package com.crevan.tasklist.web.controller;

import com.crevan.tasklist.domain.task.Task;
import com.crevan.tasklist.domain.user.User;
import com.crevan.tasklist.service.TaskService;
import com.crevan.tasklist.service.UserService;
import com.crevan.tasklist.web.dto.taks.TaskDto;
import com.crevan.tasklist.web.dto.user.UserDto;
import com.crevan.tasklist.web.dto.validation.OnCreate;
import com.crevan.tasklist.web.dto.validation.OnUpdate;
import com.crevan.tasklist.web.mapper.TaskMapper;
import com.crevan.tasklist.web.mapper.USerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final USerMapper uSerMapper;

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody final UserDto userDto) {
        User user = uSerMapper.toEntity(userDto);
        User updatedUser = userService.update(user);
        return uSerMapper.toDto(updatedUser);
    }

    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable final Long id) {
        User user = userService.getById(id);
        return uSerMapper.toDto(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable final Long id) {
        userService.delete(id);
    }

    @GetMapping(value = "/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable final Long id) {
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping(value = "/{id}/tasks")
    public TaskDto createTask(@PathVariable final Long id, @Validated(OnCreate.class) @RequestBody final TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }
}
