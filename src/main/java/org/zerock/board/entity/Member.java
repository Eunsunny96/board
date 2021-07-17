package org.zerock.board.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member extends BaseEntity{
    @Id
    private String email; //email을 pk로 이용

    private String password;

    private String name;
}
