package mbt.helper.elastic.service.repository;

import mbt.helper.elastic.service.document.LogDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends ElasticsearchRepository<LogDocument, String> {

    Page<LogDocument> findByLogType(String logType, Pageable pageable);
}
