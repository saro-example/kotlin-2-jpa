package jpa.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "board")
@Table(
        uniqueConstraints = [UniqueConstraint(columnNames = ["id"])]
)
data class Board (
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

       @Column(nullable = false, length = 2000)
        var content: String = "",

       @Column(nullable = false, length = 16)
        var name: String = "",

       @Column(nullable = false, length = 512)
        var password: String? = "",

       @Column(nullable = false, length = 40)
        var ip: String = "",

       @Column(nullable = false)
       var voteUp: Int = 0,

       @Column(nullable = false)
       var voteDown: Int = 0,

       var regDt: LocalDateTime = LocalDateTime.now()

//       @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
//       @JoinColumn(name = "id", nullable = false, insertable = false)
//       var replies: MutableList<FeedReply> = mutableListOf()
)