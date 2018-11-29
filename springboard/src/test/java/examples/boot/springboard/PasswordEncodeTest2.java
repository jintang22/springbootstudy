package examples.boot.springboard;

import org.junit.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeTest2 {

    @Test
    public void encoding() throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String encode = passwordEncoder.encode("1234");

        System.out.println(encode);

        String encodeStr = "{bcrypt}$2a$10$iZInwMMpG3bQ4mw24WeHteeDLhV8GkQWLk3PAuhE.ej3KBjT.mFji";

        System.out.println( passwordEncoder.matches("1234", encodeStr) );
    }
}
