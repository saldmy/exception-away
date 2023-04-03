package com.github.saldmy;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static com.github.saldmy.Helper.uncheck;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FunctionUncheckTest {
    private static String function(String value) throws InterruptedException {
        if ("success".equals(value)) {
            return value;
        } else {
            throw new InterruptedException();
        }
    }

    @Test
    public void testSuccess() {
        assertEquals(
                "success",
                Optional.of("success")
                           .map(uncheck(FunctionUncheckTest::function))
                           .get()
        );
    }

    @Test
    public void testFail() {
        assertThrows(InterruptedException.class,
                () -> Optional.of("fail")
                .map(uncheck(FunctionUncheckTest::function))
                .get()
        );
    }
}
