package by.skopinau.rescue.hr.config;

import by.skopinau.rescue.hr.service.impl.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new AuthSuccessHandler();
    }

    /*@Bean
    public AuthFailureHandler failureHandler() {
        return new AuthFailureHandler();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();

        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);
        http.authorizeRequests()
                .mvcMatchers("/login", "/registration", "/static/**").permitAll()
                .mvcMatchers("/users/**").hasAuthority("ADMIN")
                .mvcMatchers("/**").hasAnyAuthority("ADMIN", "USER")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(successHandler())
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and()
                .csrf().disable(); // todo: NOT PRODUCTION

        http.userDetailsService(userDetailsService);
    }
}