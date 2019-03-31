package xiaofeng.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * 配置内存认证，暂不使用，已迁移到DBSecurityConfig
 */
@Order(1)
public class MemorySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("apollo").password("123456").roles("admin").and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
