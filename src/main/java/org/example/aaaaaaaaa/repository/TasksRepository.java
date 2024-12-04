package org.example.aaaaaaaaa.repository;

import org.example.aaaaaaaaa.models.AppUser;
import org.example.aaaaaaaaa.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
     List<Tasks> findByAppUser(AppUser appUser);
}
