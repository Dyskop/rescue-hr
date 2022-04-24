package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.dao.impl.BaseDaoImpl;
import by.skopinau.rescue.hr.model.BaseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config {
    @Bean
    public BaseDaoImpl<BaseEntity> baseDaoImpl() {
        return new BaseDaoImpl<>(BaseEntity.class);
    }
}