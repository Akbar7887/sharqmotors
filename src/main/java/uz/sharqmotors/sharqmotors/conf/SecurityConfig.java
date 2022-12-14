package uz.sharqmotors.sharqmotors.conf;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.sharqmotors.sharqmotors.filter.CustomAuthenticationFilter;
import uz.sharqmotors.sharqmotors.filter.CustomAuthorizationFilter;

import static org.springframework.http.HttpMethod.*;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter((authenticationManagerBean()));
        customAuthenticationFilter.setFilterProcessesUrl("/sharq/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/sharq/login/token/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/sharq/**").permitAll();
        http.authorizeRequests().antMatchers(POST,"/sharq/customeradd", "/sharq/customerorderadd").permitAll();
        http.authorizeRequests().antMatchers(GET,"/sharq/customerget", "/custom/customerorderpost").hasAnyAuthority("ADMIN", "MENEGER");
        http.authorizeRequests().antMatchers(POST, "/sharq/**").hasAnyAuthority( "ADMIN", "MENEGER");
        http.authorizeRequests().antMatchers(PUT, "/sharq/**").hasAnyAuthority("ADMIN", "MENEGER");
        http.authorizeRequests().antMatchers(DELETE, "/sharq/**").hasAnyAuthority("ADMIN", "MENEGER");

//        http.authorizeRequests().antMatchers(POST, "/api/customeradd").hasAnyAuthority( "ADMIN", "MENEGER");

        http.authorizeRequests().antMatchers(POST, "/login/user/save/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}
