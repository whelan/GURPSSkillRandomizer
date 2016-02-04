package dk.whelan.gurps.npc.skill.service.rest;

import dk.whelan.gurps.npc.skill.service.model.skill.Skill;
import dk.whelan.gurps.npc.skill.service.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by lnorregaard on 24/01/16.
 */
@RestController
public class SkillsController {
    @Autowired
    private SkillRepository repository;

    Random random = new Random();


    @RequestMapping(value = "/skills/", method = RequestMethod.GET)
    @ResponseBody
    List<Skill> getSkillsForTL(@RequestParam(value="tl", defaultValue="0") int techLevel ) {
        return repository.findAll()
                .stream()
                .filter(skill -> skill.getTechLevel() <= techLevel)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/skills/random",method = RequestMethod.GET)
    @ResponseBody
    Skill getRandomSkillForTL(@RequestParam(value="tl", defaultValue="0") int techLevel ) {
        List<Skill> skills =  repository.findAll()
                .stream()
                .filter(skill -> skill.getTechLevel() <= techLevel)
                .collect(Collectors.toList());
        return skills.get(random.nextInt(skills.size()-1));
    }

    @RequestMapping(value = "/skills/template/random",method = RequestMethod.POST)
    @ResponseBody
    Skill getRandomSkillForTemplateTL(@RequestBody SkillTemplate template, @RequestParam(value="tl", defaultValue="0") int techLevel ) {
        List<Skill> skills =  repository.findAll()
                .stream()
                .filter(skill -> skill.getTechLevel() <= techLevel)
                .filter(skill -> template.getSkills().contains(skill.getName()))
                .collect(Collectors.toList());
        return skills.get(random.nextInt(skills.size()-1));
    }

}
