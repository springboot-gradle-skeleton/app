package com.skeleton.infrastructure.persistent.repository.impl;

import com.baomidou.mybatisplus.test.autoconfigure.AutoConfigureMybatisPlus;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import com.skeleton.infrastructure.persistent.config.EmbeddedMariaDbConfig;
import com.skeleton.infrastructure.persistent.config.MybatisPlusConfig;
import com.skeleton.infrastructure.persistent.config.TestEnvironmentExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

@DataJdbcTest
// @MybatisPlusTest
// Mybatis Plus自动配置
@AutoConfigureMybatisPlus
@ImportAutoConfiguration(classes = {
        EmbeddedMariaDbConfig.class,
        MybatisPlusConfig.class,
        PageHelperAutoConfiguration.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("unit-test")
@ExtendWith(TestEnvironmentExtension.class)
public class BaseRepositoryTest {
}
