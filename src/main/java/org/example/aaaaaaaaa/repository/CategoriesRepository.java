package org.example.aaaaaaaaa.repository;

import org.example.aaaaaaaaa.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {


}
