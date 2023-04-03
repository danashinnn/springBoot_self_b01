package org.zerock.self_b01.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.self_b01.domain.Board;
import org.zerock.self_b01.domain.QBoard;

import java.util.List;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {
        QBoard board = QBoard.board;
        // JPQLQuery는 @Query로 작성했던 JPQL을 코드를 통해 생성할 수 있게 함
        JPQLQuery<Board> query = from(board); // select.. from board

        query.where(board.title.contains("1")); // where title like...
        // paging
        this.getQuerydsl().applyPagination(pageable, query); // Querydsl로 Pageable 처리하기
        List<Board> list = query.fetch(); // fetch()를 사용해 JPQLQuery 실행
        long count = query.fetchCount(); // fetchCount()를 사용해 count 쿼리 실행
        return null;
    }

    @Override
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        if((types != null && types.length >0) && keyword != null) { // 검색 조건과 키워드가 있다면
            // Querydsl을 이용할 때 ()가 필요하면 BooleanBuilder를 이용
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type : types) {
                switch (type) {
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder);
        }

        // bno > 0
        query.where(board.bno.gt(0L));

        // paging
        this.getQuerydsl().applyPagination(pageable, query);
        List<Board> list = query.fetch();
        long count = query.fetchCount();

        // PageImpl 클래스를 통해 페이징 처리의 최종 결과(Page<T>) 반환
        // 파라미터 3개 : List<T>(실제 목록 데이터), Pageable(페이지 관련 정보를 가진 객체), long(전체 개수)
        return new PageImpl<>(list, pageable, count);
    }
}
