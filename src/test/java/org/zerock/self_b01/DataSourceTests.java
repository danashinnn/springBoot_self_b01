package org.zerock.self_b01;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Log4j2
public class DataSourceTests {

    @Autowired
    private DataSource dataSource; // application.properties에서 DataSource 설정을 통해 bean 생성

    @Test
    public void testConnection() throws SQLException {

        @Cleanup
        Connection con = dataSource.getConnection();

        log.info(con); // 로그를 남겨주는 lombok 어노테이션(@Log4j2)가 테스트 환경에서도 적용되는지 확인
        Assertions.assertNotNull(con); 
    }
}
