package com.unstar.backend.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "board")
@Data
public class Board extends CommonVO implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;              // 고유번호

    @Column
    private String author; //작성자

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    private List<Comment> comments; //댓글

    @Column
    private String title; //제목

    @Column
    private String content; //내용

}
