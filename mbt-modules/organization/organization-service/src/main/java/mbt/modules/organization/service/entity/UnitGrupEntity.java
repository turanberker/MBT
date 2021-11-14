package mbt.modules.organization.service.entity;

import mbt.core.service.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "ORGANIZATION", name = "GROUP_T")
public class UnitGrupEntity extends BaseEntity {

    @Column(name = "GROUP_NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
