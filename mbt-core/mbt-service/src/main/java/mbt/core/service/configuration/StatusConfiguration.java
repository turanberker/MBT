package mbt.core.service.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("statusConfig")
public class StatusConfiguration {

    @Value("${status.schemaName}")
    private String schemaName;

    @Value("${status.tableName}")
    private String tableName;


    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
