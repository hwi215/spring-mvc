package example.jpa.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.nio.file.FileStore;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "team")
public class Member {
    /**
     * member가 하나의 팀에만 소속된다.
     * 팀의 입장에서도 하나의 member만
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_pk")
    @SequenceGenerator(name = "member_pk", allocationSize = 1, sequenceName = "member_pk")
    // generator와 name이 같아야 함
    private Long memberId;
    private String name;
    private int age;

    //@ManyToOne // 1: 다
    @JoinColumn(name = "tid")
    @ManyToOne(fetch = FetchType.LAZY) //: 지연로딩
    private Team team;

}
