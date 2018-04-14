package pip.security.service;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pip.database.UserRep;

import static java.util.Collections.emptyList;

@Service("userDetailsService")
public class AccountService implements UserDetailsService {

    private UserRep userRep;
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    public AccountService(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // Fetch the account corresponding to the given username
        pip.database.User account = userRep.findByEmail(email);

        // If the account doesn't exist
        if (account == null) {
            throw new UsernameNotFoundException("User " + email + " not found");
        }

        // User(username, password, enabled, accountNonExpired, credentialsNotExpired, accountNonLocked, authorities)
        org.springframework.security.core.userdetails.User user =
                new org.springframework.security.core.userdetails.User(
                        account.getEmail(), account.getPassword(), account.isEnabled(), true, true, true, emptyList());

        detailsChecker.check(user);

        return user;
    }

}
