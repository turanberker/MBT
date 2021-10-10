package mbt.modules.organization.service.repository;

import mbt.modules.organization.service.entity.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<UnitEntity,Long> , QuerydslPredicateExecutor<UnitEntity> {
}
