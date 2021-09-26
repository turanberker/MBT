package organization.common.dto;

import mbt.common.dto.BaseModel;

import javax.validation.constraints.NotBlank;

public class UnitModel extends BaseModel {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
