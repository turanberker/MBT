package mbt.core.service.repository;

import mbt.core.service.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long>, BaseQueryRepository<E> {
}
