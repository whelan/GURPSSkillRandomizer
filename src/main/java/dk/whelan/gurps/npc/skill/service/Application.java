package dk.whelan.gurps.npc.skill.service;

import dk.whelan.gurps.npc.skill.service.model.skill.Skill;
import dk.whelan.gurps.npc.skill.service.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by lnorregaard on 31/12/15.
 */

@SpringBootApplication
@EnableMongoRepositories
public class Application implements CommandLineRunner {

    @Autowired
    private SkillRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        repository.findAll()
                .stream()
                .filter(skill -> skill.getPrereqs() != null)
                .filter(skill -> skill.getPrereqs().getTechLevel() != null)
//                .filter(skill -> !skill.getCategoryList().contains("Technical"))
//                .filter(skill -> skill.getCategoryList().contains("Combat/Weapon"))
                .forEach(skill -> System.out.println(skill.getName() + " " + skill.getSpecialization() + " " + skill.getPrereqs().getTechLevel()));
//        for (skill skill : repository.findAll()) {
//            System.out.println(skill);
//        }
//        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");

//        repository.findByDifficulty("IQ/H")
//                .stream()
//                .filter(skill -> skill.getPrereqs() != null)
//                .forEach(System.out::println);

//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (Skill skill : repository.findByBook("Action")) {
//            System.out.println(skill);
//        }

    }
}
