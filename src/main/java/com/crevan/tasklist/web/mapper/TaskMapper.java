package com.crevan.tasklist.web.mapper;

import com.crevan.tasklist.domain.task.Task;
import com.crevan.tasklist.web.dto.taks.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(final Task task);

    List<TaskDto> toDto(final List<Task> tasks);

    Task toEntity(final TaskDto taskDto);
}
