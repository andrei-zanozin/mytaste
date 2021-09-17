package com.zanozin.mytaste.repostory;

import com.zanozin.mytaste.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}