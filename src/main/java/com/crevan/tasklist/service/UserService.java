package com.crevan.tasklist.service;

import com.crevan.tasklist.domain.user.User;

public interface UserService {

    User getById(final Long id);

    User getByUserName(final String userName);

    User create(final User user);

    User update(final User user);

    boolean isTaskOwner(final Long userId, final Long taskId);

    void delete(final Long id);
}
