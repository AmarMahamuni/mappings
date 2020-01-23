package com.room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<UserModel, Long> {

}
