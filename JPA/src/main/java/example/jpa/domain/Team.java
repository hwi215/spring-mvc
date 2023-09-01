package example.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class Team {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_pk")
    @SequenceGenerator(name = "team_pk", allocationSize = 1, sequenceName = "team_pk")
    private Long id;
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String teamName;

    // 회원정보
    // mappedBy -> FK 반대, parivate Team team;
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER) // 즉시 조인  // 지연로딩
    private List<Member> memberList;

    public Team(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }
}
