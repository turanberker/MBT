package mbt.core.service.repository;

import mbt.core.service.entity.BaseEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BaseQueryRepository<E extends BaseEntity> extends QuerydslPredicateExecutor<E> {
}
