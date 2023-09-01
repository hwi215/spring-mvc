package example.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_pk")
    @SequenceGenerator(name = "team_pk", allocationSize = 1, sequenceName = "team_pk")
    private Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String teamName;



}
