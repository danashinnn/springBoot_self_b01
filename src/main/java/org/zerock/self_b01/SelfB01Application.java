package org.zerock.self_b01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // AuditingEntityListener를 활성화
public class SelfB01Application {

    public static void main(String[] args) {
        SpringApplication.run(SelfB01Application.class, args);
    }

}
