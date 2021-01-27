package net.hacklab.springbootkotlin

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class ApiSecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity){
        http.csrf().disable().authorizeRequests().antMatchers("/greeting").authenticated().and().httpBasic()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("USER")
    }

}