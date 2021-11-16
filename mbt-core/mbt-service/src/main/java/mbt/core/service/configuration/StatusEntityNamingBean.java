package mbt.core.service.configuration;

public class StatusEntityNamingBean {

    private final String schemaName;

    private final String tableName;

    public StatusEntityNamingBean(String schemaName, String tableName) {
        this.schemaName = schemaName;
        this.tableName = tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getTableName() {
        return tableName;
    }
}
