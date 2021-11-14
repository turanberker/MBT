package mbt.core.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "#{statusConfig.schemaName}", name = "#{statusConfig.tableName}")
public class StatusEntity extends BaseEntity {

    @Column(name = "STATUS_NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
