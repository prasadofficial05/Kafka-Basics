package com.UserRegistration.Repo;

import com.UserRegistration.Entity.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister, Long> {

}
