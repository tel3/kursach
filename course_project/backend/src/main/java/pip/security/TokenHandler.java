package pip.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetailsService;
import pip.database.User;
import pip.database.UserRep;
import pip.security.service.AccountService;

import java.util.Date;
import java.util.UUID;

public class TokenHandler {

    final long EXPIRATIONTIME = 15*60*1000; 		// 15 minutes
    final String SECRET = "ThisIsASecret";			// private key, better read it from an external file

    final public String TOKEN_PREFIX = "Bearer";			// the prefix of the token in the http header
    final public String HEADER_STRING = "Authorization";	// the http header containing the prexif + the token

    private UserDetailsService userDetailsService = new AccountService(new UserRep() {
        @Override
        public User findByEmail(String email) {
            return null;
        }

        @Override
        public <S extends User> S save(S s) {
            return null;
        }

        @Override
        public <S extends User> Iterable<S> save(Iterable<S> iterable) {
            return null;
        }

        @Override
        public User findOne(Long aLong) {
            return null;
        }

        @Override
        public boolean exists(Long aLong) {
            return false;
        }

        @Override
        public Iterable<User> findAll() {
            return null;
        }

        @Override
        public Iterable<User> findAll(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void delete(Long aLong) {

        }

        @Override
        public void delete(User user) {

        }

        @Override
        public void delete(Iterable<? extends User> iterable) {

        }

        @Override
        public void deleteAll() {

        }
    });

    /**
     * Generate a token from the username.
     *
     * @param username	The subject from which generate the token.
     *
     * @return			The generated token.
     */
    public String build(String username) {

        Date now = new Date();

        String JWT = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                //.compressWith(CompressionCodecs.DEFLATE) // uncomment to enable token compression
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        return JWT;

    }

    /**
     * Parse a token and extract the subject (username).
     *
     * @param token		A token to parse.
     *
     * @return			The subject (username) of the token.
     */
    public String parse(String token) {

        String username = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();

        return userDetailsService.loadUserByUsername(username).getUsername();

    }

}
