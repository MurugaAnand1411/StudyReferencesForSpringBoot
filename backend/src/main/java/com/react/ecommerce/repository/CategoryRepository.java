package com.react.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.react.ecommerce.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

	Category findByCategoryId(long categoryId);

}
