package com.crevan.tasklist.repository;

import com.crevan.tasklist.domain.user.Role;
import com.crevan.tasklist.domain.user.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(final Long id);

    Optional<User> findByUserName(final String userName);

    void update(final User user);

    void create(final User user);

    void insertUserRole(final Long id, final Role role);

    boolean isTaskOwner(final Long userId, final Long taskId);

    void delete(final Long id);
}
