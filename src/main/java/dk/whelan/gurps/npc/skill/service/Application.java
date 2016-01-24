package dk.whelan.gurps.npc.skill.service;

import dk.whelan.gurps.npc.skill.service.model.skill.Skill;
import dk.whelan.gurps.npc.skill.service.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by lnorregaard on 31/12/15.
 */

@Controller
@EnableAutoConfiguration
@SpringBootApplication
@EnableMongoRepositories
@EnableSwagger2
public class Application {

    @Autowired
    private SkillRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket skillApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build()))
                ;
    }



//    @Override
//    public void run(String... args) throws Exception {
//
//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        System.out.println(repository.findAll()
//                .stream()
//                .filter(skill -> skill.getTechLevel() < 15)
//                .count());
////                .filter(skill -> !skill.getCategoryList().contains("Technical"))
////                .filter(skill -> skill.getCategoryList().contains("Combat/Weapon"))
////                .forEach(skill -> System.out.println(skill.getName() + " " + skill.getSpecialization() + " " + skill.getTechLevel()));
////        for (skill skill : repository.findAll()) {
////            System.out.println(skill);
////        }
////        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("--------------------------------");
//
////        repository.findByDifficulty("IQ/H")
////                .stream()
////                .filter(skill -> skill.getPrereqs() != null)
////                .forEach(System.out::println);
//
////        System.out.println("Customers found with findByLastName('Smith'):");
////        System.out.println("--------------------------------");
////        for (Skill skill : repository.findByBook("Action")) {
////            System.out.println(skill);
////        }
//
//    }
}
