package com.olnester.cats.repository;

import com.olnester.cats.entity.CatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<CatEntity, Long> {
}
