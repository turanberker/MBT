package mbt.core.service.repository;

import mbt.core.service.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository  extends JpaRepository<StatusEntity,Long> {
}
