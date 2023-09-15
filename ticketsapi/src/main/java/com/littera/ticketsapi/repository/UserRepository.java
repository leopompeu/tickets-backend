package com.littera.ticketsapi.repository;

import com.littera.ticketsapi.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
}
