package com.skeleton.infrastructure.persistent.dao.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.skeleton.infrastructure.persistent.config.EmbeddedMariaDbConfig;
import com.skeleton.infrastructure.persistent.config.TestEnvironmentExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

@MybatisPlusTest
@ImportAutoConfiguration(classes = {EmbeddedMariaDbConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(TestEnvironmentExtension.class)
@ActiveProfiles("unit-test")
public class BaseMapperRepositoryTest {
}
