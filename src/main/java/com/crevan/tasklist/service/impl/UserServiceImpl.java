package com.crevan.tasklist.service.impl;

import com.crevan.tasklist.domain.user.User;
import com.crevan.tasklist.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getById(final Long id) {
        return null;
    }

    @Override
    public User getByUserName(final String userName) {
        return null;
    }

    @Override
    public User create(final User user) {
        return null;
    }

    @Override
    public User update(final User user) {
        return null;
    }

    @Override
    public boolean isTaskOwner(final Long userId, final Long taskId) {
        return false;
    }

    @Override
    public void delete(final Long id) {

    }
}
