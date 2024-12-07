package org.example.aaaaaaaaa.repository;

import org.example.aaaaaaaaa.models.AppUser;
import org.example.aaaaaaaaa.models.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
     Page<Tasks> findByAppUser(AppUser appUser, Pageable pageable);
     @Query("SELECT t FROM Tasks t WHERE t.title LIKE %:title% AND t.appUser = :user")
     Page<Tasks> findByAppUser(@Param("user") AppUser appUser, String title, Pageable pageable);
}
