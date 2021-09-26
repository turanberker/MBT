package mbt.modules.organization.service.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sun.istack.NotNull;
import mbt.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "UNIT")
public class UnitEntity extends BaseEntity {

    @NotBlank
    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
