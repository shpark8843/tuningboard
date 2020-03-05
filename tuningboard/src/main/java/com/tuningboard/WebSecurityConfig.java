package com.tuningboard;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/res/**");
    }
    @Autowired
    private DataSource dataSource;
    
    private final String USERS_QUERY = "select email, password, active from userinfo where email=?";
    		
    private final String ROLES_QUERY = "select u.email, r.role from userinfo u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.jdbcAuthentication()
      .usersByUsernameQuery(USERS_QUERY)
      .authoritiesByUsernameQuery(ROLES_QUERY)
      .dataSource(dataSource)
      .passwordEncoder(bCryptPasswordEncoder);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.authorizeRequests()
//    	   .antMatchers("/user/**").access("ROLE_USER")
    	   .antMatchers("/").permitAll()
    	   .antMatchers("/login").permitAll()
    	   .antMatchers("/signup").permitAll()
    	   .antMatchers("/api").permitAll()
    	   .antMatchers("/api/svcinfos").permitAll()
//    	   .antMatchers("/home/**").hasAuthority("ADMIN").anyRequest()
    	   .anyRequest().authenticated();
    	 
    	 http.csrf().disable();
    	 
    	 http.formLogin()
    	   .loginPage("/login")
    	   .failureUrl("/login?error=true")
    	   .defaultSuccessUrl("/svcinfo/list")
    	   .usernameParameter("email")
    	   .passwordParameter("password");
    	   
    	 http.logout()
    	   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    	   .logoutSuccessUrl("/")
    	   .invalidateHttpSession(true)

    	   .and().rememberMe()
    	   .tokenRepository(persistentTokenRepository())
    	   .tokenValiditySeconds(60*60)
    	   .and().exceptionHandling().accessDeniedPage("/access_denied");
    	 
    	 }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
     JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
     db.setDataSource(dataSource);
     
     return db;
    }
}