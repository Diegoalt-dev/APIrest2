package com.empresa.prueba;

import com.empresa.prueba.recep_models.RecPersona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class PruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}


}


@Configuration
@EnableScheduling
@ConditionalOnProperty (name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration{

}