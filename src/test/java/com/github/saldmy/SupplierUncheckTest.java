package com.github.saldmy;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static com.github.saldmy.Helper.uncheck;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SupplierUncheckTest {
    private static boolean throwException = false;

    private static String supplier() throws InterruptedException {
        if (throwException) {
            throw new InterruptedException();
        } else {
            return "success";
        }
    }

    @Test
    public void testSuccess() {
        throwException = false;

        assertEquals(
                "success",
                Optional.ofNullable(null)
                           .orElseGet(uncheck(SupplierUncheckTest::supplier))
        );
    }

    @Test
    public void testFail() {
        throwException = true;

        assertThrows(InterruptedException.class,
                () -> Optional.ofNullable(null)
                        .orElseGet(uncheck(SupplierUncheckTest::supplier))
        );
    }
}
