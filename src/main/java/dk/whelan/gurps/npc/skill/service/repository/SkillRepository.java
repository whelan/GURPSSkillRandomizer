package dk.whelan.gurps.npc.skill.service.repository;

import dk.whelan.gurps.npc.skill.service.model.skill.Skill;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by lnorregaard on 31/12/15.
 */
public interface SkillRepository extends MongoRepository<Skill, String> {

    @Cacheable(value = "skillCache")
    List<Skill> findAll();
    List<Skill> findByDifficulty(String difficulty);
    List<Skill> findByBook(String book);

}
