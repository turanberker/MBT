package organization.common.dto;

import mbt.common.dto.BaseModel;
import mbt.common.validation.MbtValidator;

import javax.validation.constraints.NotBlank;

public class UnitModel extends BaseModel implements MbtValidator {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void validate() throws Exception {
        if (name.equalsIgnoreCase("test")) {
            throw new Exception("test adı olamaz");
        }
    }
}
