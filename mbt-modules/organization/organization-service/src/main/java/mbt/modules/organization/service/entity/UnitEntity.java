package mbt.modules.organization.service.entity;


import mbt.core.service.entity.BaseEntity;
import mbt.core.service.entity.StatusEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(schema = "ORGANIZATION", name = "UNIT")
public class UnitEntity extends BaseEntity {

    @NotBlank
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "UNIT_GROUP_ID", foreignKey = @ForeignKey(name = "FK_UNIT_GROUP0"))
    private UnitGrupEntity group;

    @ManyToOne
    @JoinColumn(name = "STATUS_ID", foreignKey = @ForeignKey(name = "FK_UNIT_STATUS0"))
    private StatusEntity status;

    @ManyToOne
    @JoinColumn(name = "PARENT_UNIT_ID", foreignKey = @ForeignKey(name = "FK_UNIT_UNIT0"))
    private UnitEntity parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitEntity getParent() {
        return parent;
    }

    public void setParent(UnitEntity parent) {
        this.parent = parent;
    }

    public UnitGrupEntity getGroup() {
        return group;
    }

    public void setGroup(UnitGrupEntity group) {
        this.group = group;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }
}
