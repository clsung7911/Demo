package com.profiles.clsung;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.TimeZone;

@EnableAspectJAutoProxy
@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class ClsungApplication {

    @PostConstruct
    public void started() {
        String displayName = TimeZone.getDefault().getDisplayName();
        String id = TimeZone.getDefault().getID();
        log.info("== Application TimeZone :" + id + "   " + displayName + " ==");

    }

    public static void main(String[] args) {
        SpringApplication.run(ClsungApplication.class, args);
    }

}
