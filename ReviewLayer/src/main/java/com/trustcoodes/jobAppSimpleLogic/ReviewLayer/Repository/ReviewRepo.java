package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Repository;

import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findByCompanyId(Long id);
}
