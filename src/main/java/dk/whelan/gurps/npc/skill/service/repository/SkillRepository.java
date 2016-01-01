package dk.whelan.gurps.npc.skill.service.repository;

import dk.whelan.gurps.npc.skill.service.model.skill.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by lnorregaard on 31/12/15.
 */
public interface SkillRepository extends MongoRepository<Skill, String> {

    List<Skill> findByDifficulty(String difficulty);
    List<Skill> findByBook(String book);

}
