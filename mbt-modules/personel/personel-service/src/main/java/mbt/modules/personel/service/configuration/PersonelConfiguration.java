package mbt.modules.personel.service.configuration;

import mbt.core.service.configuration.CustomNamingStrategyFromBean;
import mbt.core.service.configuration.StatusEntityNamingBean;
import mbt.core.service.entity.StatusEntity;
import mbt.core.service.logic.StatusService;
import mbt.core.service.repository.StatusRepository;
import mbt.modules.personel.service.entity.PersonelEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {StatusEntity.class, PersonelEntity.class})
@ComponentScan(basePackageClasses = {
        CustomNamingStrategyFromBean.class,
        StatusService.class,
        StatusRepository.class})
@EnableJpaRepositories(basePackageClasses = {StatusRepository.class})
public class PersonelConfiguration {

    @Bean(name = "statusEntityNamingBean")
    public StatusEntityNamingBean getStatusEntityNamingBean(){
        return new StatusEntityNamingBean("PBS", "STATUS");
    }
}
