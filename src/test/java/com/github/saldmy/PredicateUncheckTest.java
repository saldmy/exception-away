package com.github.saldmy;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static com.github.saldmy.Helper.uncheck;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PredicateUncheckTest {
    private static boolean predicate(String value) throws InterruptedException {
        if (!"success".equals(value)) {
            throw new InterruptedException();
        }
        return true;
    }

    @Test
    public void testSuccess() {
        assertEquals("success",
                Optional.of("success")
                           .filter(uncheck(PredicateUncheckTest::predicate))
                           .get()
        );
    }

    @Test
    public void testFail() {
        assertThrows(
                InterruptedException.class,
                () -> Optional.of("fail")
                        .filter(uncheck(PredicateUncheckTest::predicate))
                        .get()
        );
    }
}
