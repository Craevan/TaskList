package com.crevan.tasklist.repository.impl;

import com.crevan.tasklist.domain.user.Role;
import com.crevan.tasklist.domain.user.User;
import com.crevan.tasklist.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> findById(final Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUserName(final String userName) {
        return Optional.empty();
    }

    @Override
    public void update(final User user) {

    }

    @Override
    public void create(final User user) {

    }

    @Override
    public void insertUserRole(final Long id, final Role role) {

    }

    @Override
    public boolean isTaskOwner(final Long userId, final Long taskId) {
        return false;
    }

    @Override
    public void delete(final Long id) {

    }
}
