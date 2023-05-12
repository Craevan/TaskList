package com.crevan.tasklist.repository.mapper;

import com.crevan.tasklist.domain.task.Status;
import com.crevan.tasklist.domain.task.Task;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskRowMapper {

    @SneakyThrows
    public static Task mapRow(final ResultSet resultSet) {
        if (resultSet.next()) {
            Task task = new Task();
            task.setId(resultSet.getLong("task_id"));
            setData(resultSet, task);
            return task;
        }
        return null;
    }

    @SneakyThrows
    public static List<Task> mapRows(final ResultSet resultSet) {
        List<Task> tasks = new ArrayList<>();
        while (resultSet.next()) {
            Task task = new Task();
            task.setId(resultSet.getLong("task_id"));
            if (!resultSet.wasNull()) {
                setData(resultSet, task);
                tasks.add(task);
            }
        }
        return tasks;
    }

    private static void setData(final ResultSet resultSet, final Task task) throws SQLException {
        task.setTitle(resultSet.getString("task_title"));
        task.setDescription(resultSet.getString("task_description"));
        task.setStatus(Status.valueOf(resultSet.getString("task_status")));
        Timestamp timestamp = resultSet.getTimestamp("task_expiration_date");
        if (timestamp != null) {
            task.setExpirationDate(timestamp.toLocalDateTime());
        }
    }
}
