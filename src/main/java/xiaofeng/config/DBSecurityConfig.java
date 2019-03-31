package xiaofeng.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DBSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().formLogin();
    }

    // 配置多个认证源
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //内存认证
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("apollo").password("123456").roles("admin");

        //数据库认证
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select Username,Password,Enabled from Users where Username=?")
                .authoritiesByUsernameQuery("select Username,Authority from `Authorities` where Username = ?")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
