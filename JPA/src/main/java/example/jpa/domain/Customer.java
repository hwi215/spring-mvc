package example.jpa.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // JPA가 관리하게 될 객체
public class Customer {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.AUTO) // 시퀀스 생성, AUTO: Hibernate 규칙 그대로 따름
    private Long id;

    private String userName;
    private int age;

    // LocalDate: 년월일, LocalDateTime 시간까지
    @CreationTimestamp // 생성시 자동으로 날짜 저장됨
    private LocalDateTime insertDate; // 등록일
    @CreationTimestamp // 수정시 자동으로 날짜 수정됨
    private LocalDateTime updateDate; // 수정일

    @Temporal(TemporalType.DATE) // TIMESTAMP: 날짜 + 시분초
    private Date birthDay;
}
