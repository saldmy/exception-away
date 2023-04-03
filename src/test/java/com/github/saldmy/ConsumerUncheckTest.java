package com.github.saldmy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.github.saldmy.Helper.uncheck;


public class ConsumerUncheckTest {
    private static void consumer(String value) throws InterruptedException {
        if (!"success".equals(value)) {
            throw new InterruptedException();
        }
        Assertions.assertEquals("success", value);
    }

    @Test
    public void testSuccess() {
        Optional.of("success").ifPresent(uncheck(ConsumerUncheckTest::consumer));
    }

    @Test
    public void testFail() {
        Assertions.assertThrows(
                InterruptedException.class,
                () -> Optional.of("fail")
                .ifPresent(uncheck(ConsumerUncheckTest::consumer))
        );
    }
}
