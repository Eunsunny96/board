package org.zerock.board.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString(exclude = "writer") //sql 할때 실행 x
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board { //이메일(PK)을 FK로 참조

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)//명시적으로 Lazy  로딩 지점
    private Member writer;//연관관계 지정
}
