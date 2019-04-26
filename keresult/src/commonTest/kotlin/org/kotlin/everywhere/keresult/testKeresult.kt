package org.kotlin.everywhere.keresult

import kotlin.test.Test
import kotlin.test.assertEquals

class TestKeresult {
    @Test
    fun testMap() {
        // check apply map only when success
        assertEquals(Ok(2), Ok(1).map { it * 2 })
        assertEquals(Err("Error"), (Err("Error") as Result<String, Int>).map { it * 2 })

        // check map change type
        assertEquals(Ok("1"), Ok(1).map { "$it" })
        assertEquals(Err("Error"), (Err("Error") as Result<String, Int>).map { "$it" })
    }

    @Test
    fun testMapError() {
        // mapError 는 Err 에서만 동작하는 것 확인
        assertEquals(Err(2), Err(1).mapError { it * 2 })
        assertEquals(Ok("Success"), (Ok("Success") as Result<Int, String>).mapError { it * 2 })

        // mapError 는 타입 변경 확인
        assertEquals(Err("1"), Err(1).mapError { "$it" })
        assertEquals(Ok("Success"), (Ok("Success") as Result<Int, String>).mapError { "$it" })
    }
}