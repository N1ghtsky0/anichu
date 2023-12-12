package io.anichu.anichu.repository;

import io.anichu.anichu.entity.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCompanyRepo extends JpaRepository<ProductionCompany, Long> {
}
