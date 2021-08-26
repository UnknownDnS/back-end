package com.unstar.backend.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "comment")
@Data
public class Comment extends CommonVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;                                        // 고유번호

    //@Column("board_id")
    private Integer boardId;

    @Column
    private String userName; //글쓴이

    @Column
    private String content; //댓글 내용

    @Column
    private String title;

}
