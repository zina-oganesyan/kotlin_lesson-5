package ru.netology

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WallServiceTests {

    @Test
    fun add() {
        val post = Post(
            0, 1, 1, 1, 1, "", 1, 1, true,
            Comments(1, true, true, true, true), Copyright(1, "", "", ""),
            Likes(1, true, true, true), Reposts(1, true), Views(1),
            "", 1, true, true, true, true, true, true,
            Donut(true, 1, Placeholder(""), true, ""), 1,
            arrayOf(GiftAttachment(), AudioAttachment())
        )
        val newPost = WallService.add(post)
        assertEquals(WallService.id, newPost.id)
    }

    @Test
    fun update() {
        val post = Post(
            0, 1, 1, 1, 1, "", null, null, true,
            null, null, Likes(1, true, true, true), null,
            Views(1), "1", null, true, true, true, true, true,
            true, Donut(true, 1, Placeholder(""), true, ""), 1,
            null
        )
        val newPost = WallService.add(post)
        assertTrue(WallService.update(newPost.copy(text = "test")))
    }

    @Test
    fun `update non-existent post`() {
        val post = Post(0, 1, 1, 1, 1, "", 1, 1, true,
            Comments(1, true, true, true, true), Copyright(1, "", "", ""),
            Likes(1, true, true, true), Reposts(1, true), Views(1),
            "", 1, true, true, true, true, true, true,
            Donut(true, 1, Placeholder(""), true, ""), 1,
            arrayOf(AudioAttachment())
        )
        assertFalse(WallService.update(post))
    }
}