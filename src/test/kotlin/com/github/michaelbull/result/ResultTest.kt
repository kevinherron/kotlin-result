package com.github.michaelbull.result

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

internal class ResultTest {
    internal class `of` {
        @Test
        internal fun returnsOkIfInvocationSuccessful() {
            val callback = { "example" }

            assertEquals(
                expected = "example",
                actual = Result.of(callback).get()
            )
        }

        @Test
        internal fun returnsErrIfInvocationFails() {
            val throwable = IllegalArgumentException("throw me")
            val callback = { throw throwable }
            val error = Result.of(callback).getError()!!

            assertSame(
                expected = throwable,
                actual = error
            )
        }
    }
}
