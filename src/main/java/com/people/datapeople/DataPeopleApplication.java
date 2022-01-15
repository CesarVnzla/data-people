package com.people.datapeople;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.people.datapeople.utility.Constants.*;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = INFO_API_TITLE, version = INFO_API_VERSION, description = INFO_API_DESCRIPTION))
public class DataPeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataPeopleApplication.class, args);
	}

}
