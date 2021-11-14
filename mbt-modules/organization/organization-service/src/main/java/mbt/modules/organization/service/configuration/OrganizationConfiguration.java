package mbt.modules.organization.service.configuration;

import mbt.core.service.configuration.MySpringPhysicalNamingStrateg;
import mbt.core.service.entity.StatusEntity;
import mbt.modules.organization.service.controller.UnitRestController;
import mbt.modules.organization.service.entity.UnitEntity;
import mbt.modules.organization.service.logic.UnitService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackageClasses = {StatusEntity.class, UnitEntity.class})
@ComponentScan(basePackageClasses = {UnitRestController.class, UnitService.class, MySpringPhysicalNamingStrateg.class})
public class OrganizationConfiguration {


}
