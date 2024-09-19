package com.kellyprojects.ob_hibernate_project;

import com.kellyprojects.ob_hibernate_project.entities.*;
import com.kellyprojects.ob_hibernate_project.repository.BillingInfoRepository;
import com.kellyprojects.ob_hibernate_project.repository.TagRepository;
import com.kellyprojects.ob_hibernate_project.repository.TaskRepository;
import com.kellyprojects.ob_hibernate_project.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ObHibernateProjectApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(ObHibernateProjectApplication.class, args);//Context es una especie de fàbrica que mantiene y gestiona los beans de la aplicaciòn. El mètodo run() inicia la aplicaciòn Spring Boot. Es el punto de entrada principal que pone en marcha todo el contexto de la aplicaciòn de Spring.

		//  BillingInfo y User===========================
		BillingInfoRepository billingInfoRepository=context.getBean(BillingInfoRepository.class);//Aquì estamos pidiendo al contenendor de Spring que nos devuelva una instancia del bean que implementa la interfaz BillingInfoReposotory. El mètodo context.getBean() se usa para obtener un bean de spring del contexto de la aplicaciòn. Spring crea y gestiona los objetos llamados beans, los cuales son instancias de clases anotadas con stereotipos de spring con @component, @service, @repository.
		UserRepository userRepository=context.getBean(UserRepository.class);

		BillingInfo billingInfo1=new BillingInfo(null, "ELM street", "266398", "Quesadilla", "Transilvania", "789456121", null);
		User user1=new User(null,"Fabiola","Perez","89632541", true, LocalDate.of(1970,05,30));

		billingInfoRepository.save(billingInfo1);

		user1.setBillingInfo(billingInfo1);
		userRepository.save(user1);

		//  Task and User=============================

		User user2=new User(null,"Anastacio","Martinez","489532541", false, LocalDate.of(1971,06,30));
		userRepository.save(user2);

		TaskRepository taskRepository=context.getBean(TaskRepository.class);
		Task task1= new Task(null, "Titulo1", "Descripciòn1", true, LocalDate.now(),user1);
		Task task2= new Task(null, "Titulo2", "Descripciòn2", true, LocalDate.now(),user1);
		Task task3= new Task(null, "Titulo3", "Descripciòn3", false, LocalDate.now(),user2);
		Task task4= new Task(null, "Titulo4", "Descripciòn4", true, LocalDate.now(),user2);
		taskRepository.save(task1);
		taskRepository.save(task2);
		taskRepository.save(task3);
		taskRepository.save(task4);

		//Task and Tags========================

		TagRepository tagRepository=context.getBean(TagRepository.class);

		Tag tagAzul=new Tag(null,"hib", TagColor.BLUE);
		Tag tagRed=new Tag(null, "dsa", TagColor.RED);
		Tag tagVerde=new Tag(null, "verde", TagColor.GREEN);
		tagRepository.saveAll(List.of(tagAzul,tagVerde,tagRed));

		task1.getTags().add(tagAzul);
		task2.getTags().add(tagVerde);
		task2.getTags().add(tagAzul);
		task3.getTags().add(tagVerde);
		taskRepository.saveAll(List.of(task1,task2,task3,task4));
	}

}
