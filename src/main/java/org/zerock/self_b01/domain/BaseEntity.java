package org.zerock.self_b01.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 공통으로 사용되는 칼럼들을 지정하고, 이 클래스를 상속해서 손쉽게 처리
@EntityListeners(value = {AuditingEntityListener.class}) // 엔티티가 데이터베이스에 추가/변경될 때 자동으로 시간 값을 지정
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
