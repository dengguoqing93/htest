package org.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 * 初始化数据
 *
 * @author spiral
 * @date 2020/4/22
 * @copyright spiral
 * @since 1.0 Version
 */
@Configuration
public class InitialDate {
    /**
     * 构建Resource对象
     */
    @Value("classpath:hsqldb-schema.sql")
    private Resource businessScript;

    @Value("classpath:hsqldb-dataload.sql")
    private Resource dataLoadScript;

    /**
     * 自定义Bean实现业务的特殊需求
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        // 设置数据源
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(businessScript);
        populator.addScript(dataLoadScript);
        return populator;
    }

}
