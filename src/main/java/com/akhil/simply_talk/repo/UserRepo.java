package com.akhil.simply_talk.repo;

import com.akhil.simply_talk.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public Boolean existsByUserName(String userName);
    public Boolean existsByEmail(String email);
}
