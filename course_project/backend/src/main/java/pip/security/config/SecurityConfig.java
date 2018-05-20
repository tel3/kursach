package pip.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pip.database.UserRep;
import pip.security.JWTAuthenticationEntryPoint;
import pip.security.JWTAuthenticationFilter;
import pip.security.JWTLoginFilter;
import pip.security.service.AccountService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private UserRep userRep;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Disable CSRF protection since tokens are immune to it
                .csrf().disable()
                // If the user is not authenticated, returns 401
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                // This is a stateless application, disable sessions
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // Security policy
                .authorizeRequests()
                        // Allow anonymous access to "/" path
//                        .antMatchers("/", "/static/*").permitAll()
                        .antMatchers("/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
                        // Allow anonymous access to "/login" (only POST requests)
                        .antMatchers(HttpMethod.POST, "/login").permitAll()
                        // Any other request must be authenticated
                        .anyRequest().permitAll().and()
                // Custom filter for logging in users at "/login"
                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                // Custom filter for authenticating users using tokens
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                // Disable resource caching
                .headers().cacheControl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceBean());

        //auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new AccountService(userRep);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("moderator").password("123456").roles("MODERATOR");
    }
}
