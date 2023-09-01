package example.jpa.domain;

import com.sun.istack.Nullable;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * String: 기본 NULL, varchar2(255 char)
 * int: 기본 NOT NULL, number(19)
 *
 * @Id // PK
 * @GeneratedValue : 시퀀스 생성
 * @Column : NULL 여부, length, name(컬럼명) 설정 가능
 * @Transient : 컬럼 생성 제외
 * @CreationTimestamp : 생성시 자동으로 날짜 저장됨
 * @UpdateTimestamp : 수정시 자동으로 날짜 수정됨
 * @Temporal(TemporalType.DATE) : TIMESTAMP: 날짜 + 시분초
 */
@Entity // JPA가 관리하게 될 객체
@NoArgsConstructor // 생성자
@AllArgsConstructor
@Builder // lombok에 존재
@ToString // 주소값 나오지 않게
@Setter
public class Customer {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.AUTO) // 시퀀스 생성, AUTO: Hibernate 규칙 그대로 따름
    private Long id;

    @Column(nullable = false, length = 100, name = "user_name") // name: 컬럼병 변경
    private String userName;

    //@Transient // 테이블 생성 시, 컬럼으로 만들어지지 않음
    @Nullable
    private int age;

    // LocalDate: 년월일, LocalDateTime 시간까지
    @CreationTimestamp // 생성시 자동으로 날짜 저장됨
    private LocalDateTime insertDate; // 등록일
    @UpdateTimestamp // 수정시 자동으로 날짜 수정됨
    private LocalDateTime updateDate; // 수정일

    @Temporal(TemporalType.DATE) // TIMESTAMP: 날짜 + 시분초
    private Date birthDay;
}
