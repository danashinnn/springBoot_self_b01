package org.zerock.self_b01.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.self_b01.domain.Board;
import org.zerock.self_b01.repository.search.BoardSearch;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

//     쿼리 메소드란?
//     보통 SQL에서 사용하는 키워드와 칼럼들을 결합해서 구성하면 그 자체가 JPA에서 사용하는 쿼리가 되는 기능
//     일반적으로 메소드 이름은 'findBy..' 혹은 'get..'으로 시작하고 칼럼명과 키워드를 결합함
//     그러나 실제 사용하면 메소드가 너무 길고 복잡해지므로 실제 개발에서는 많이 사용되지 않음
//
//     그래서 쿼리 메소드와 유사하게 @Query의 value로 작성하는 JPQL을 이용할 수 있음
//     SQL과 유사하게 JPA에서 사용하는 쿼리 언어이며, 데이터베이스에 독립적으로 개발 가능
//
//    @Query("select b from Board b where b.title like concat('%', :keyword, '%')")
//    Page<Board> findKeyword(String keyword, Pageable pageable);
//
//     JPA나 JPQL을 이용하면 편리하지만 어노테이션을 이용해서 지정하기 때문에 고정된 형태라는 단점이 있음
//     복합적인 검색 조건이나, 여러 종류의 속성이 존재한다면 모든 경우의 수를 별도 메소드로 작성하기 어려움
//     JPQL이 정적으로 고정되기 때문에 이런 문제가 발생하므로, 이를 해결하기 위해 Querydsl이 사용됨
//     Querydsl은 자바 코드를 이용하기 때문에 타입의 안정성을 유지하며 원하는 쿼리를 작성할 수 있음
//     Q도메인은 Querydsl의 설정을 통해 기존의 엔티티 클래스를 Querydsl에서 쓰기 위해 별도의 코드로 생성하는 클래스임
//
//     Querydsl의 목적은 타입 기반으로 코드를 이용해서 JPQL 쿼리를 생성하고 실행하는 것

    @Query(value = "select now()", nativeQuery = true)// nativeQuery 속성값을 true로 지정하면 특정 데이터베이스에서 동작하는 SQL을 사용 가능
    String getTime();
}
