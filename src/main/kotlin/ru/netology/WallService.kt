package ru.netology

object WallService {
    val postsList = mutableListOf<Post>()
    var id = 0

    fun add(post: Post): Post {
        val newPost = post.copy(id = ++id)
        postsList.add(newPost)
        return newPost
    }

    fun update(post: Post): Boolean {
        val index = postsList.indexOfFirst { it.id == post.id }
        return if (index != -1) {
            postsList[index] = post.copy(fromId = postsList[index].fromId, date = postsList[index].date)
            true
        } else {
            false
        }
    }

}