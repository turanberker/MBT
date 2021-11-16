package mbt.modules.organization.service.configuration;

import mbt.core.service.configuration.CustomNamingStrategyFromBean;
import mbt.core.service.configuration.StatusEntityNamingBean;
import mbt.core.service.entity.StatusEntity;
import mbt.core.service.logic.StatusService;
import mbt.core.service.repository.StatusRepository;
import mbt.modules.organization.service.controller.UnitRestController;
import mbt.modules.organization.service.entity.UnitEntity;
import mbt.modules.organization.service.logic.UnitService;
import mbt.modules.organization.service.repository.UnitRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {StatusEntity.class, UnitEntity.class})
@ComponentScan(basePackageClasses = {UnitRestController.class,
        UnitService.class,
        CustomNamingStrategyFromBean.class,
        StatusService.class})
@EnableJpaRepositories(basePackageClasses = {StatusRepository.class, UnitRepository.class})
public class OrganizationConfiguration {

    @Bean(name = "statusEntityNamingBean")
    public StatusEntityNamingBean getStatusEntityNamingBean() {
        return new StatusEntityNamingBean("ORGANIZATION", "STATUS");
    }
}
