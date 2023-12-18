package com.example.SchoolSystem;

import com.example.SchoolSystem.entity.Student;
import com.example.SchoolSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SchoolSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {


	}
}
