package net.hacklab.springbootkotlin

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSercurityConfig: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.csrf().disable().authorizeRequests().antMatchers("/web").permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder){
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("USER")
    }
}