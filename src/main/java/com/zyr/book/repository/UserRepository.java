package com.zyr.book.repository;

import com.zyr.book.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.name =:newName where u.name =:originName")
    void updateName(@Param("originName") String originName, @Param("newName") String newName);
}
