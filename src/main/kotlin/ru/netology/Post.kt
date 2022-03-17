package ru.netology

data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int?,
    val replyPostId: Int?,
    val friendsOnly: Boolean,
    val comments: Comments?,
    val copyright: Copyright?,
    val likes: Likes,
    val reposts: Reposts?,
    val views: Views,
    val postType: String,
    val signerId: Int?,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut?,
    val postponedId: Int,
    var attachment: Array<Attachment>?
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Copyright(
    val id: Int,
    val link: String?,
    val name: String?,
    val type: String
)

data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

data class Reposts(
    val count: Int,
    val userReposted: Boolean
)

data class Views(
    val count: Int
)

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeholder: Placeholder?,
    val canPublishFreeCopy: Boolean,
    val editMode: String
)

data class Placeholder(
    val text: String
)

open class Attachment(open val type: String)

class GiftAttachment: Attachment("gift"){
    override val type = "gift"
    val gift: Gift = Gift()
}
class Gift(
    val id: Int=0,
    val thumb256: String = "",
    val thumb96: String = "",
    val thumb48: String = ""
)
class GraffitiAttachment: Attachment("giraffiti"){
    override val type = "giraffiti"
    val graffiti: GraffitiLink = GraffitiLink()
}
class GraffitiLink(
    val id: Int=0,
    val ownerId: Int=0,
    val url: String = "",
    val width: Int=0,
    val height: Int=0
)

class AudioAttachment: Attachment("audio"){
    override val type = "audio"
    val audio: Audio = Audio()
}
class Audio(
    val id: Int = 0,
    val owner_id: Int = 0,
    val artist: String = "",
    val title: String = "",
    val duration: Int = 0,
    val url: String = "",
    val lyrics_id: Int = 0,
    val album_id: Int = 0,
    val genre_id: Int = 0,
    val date: Int = 0,
    val no_search: Int = 0,
    val is_hq: Int = 0
)
class FileAttachment: Attachment("file"){
    override val type = "file"
    val file: File = File()
}
class File(
    val id: Int = 0,
    val owner_id: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = "",
    val url: String = "",
    val date: Int = 0,
    val type: Int = 0,
    val preview: Preview = Preview(),
    val no_search: Int = 0,
    val is_hq: Int = 0
)
data class Preview(
    val photo: Photo? = Photo(),
    val graffiti: Graffiti? = Graffiti(),
    val audioMessage: AudioMessage? = AudioMessage()
)
data class Photo(
    val size: Array<Int>? = null
)
data class Graffiti(
    val src: String = "",
    val width: Int = 0,
    val height: Int = 0
)
data class AudioMessage(
    val duration: Int = 0,
    val waveform: Array<Int>? = null,
    val linkOgg: String = "",
    val linkMp3: String = ""
)