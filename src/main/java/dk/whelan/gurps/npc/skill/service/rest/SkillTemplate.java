package dk.whelan.gurps.npc.skill.service.rest;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lnorregaard on 04/02/16.
 */
public class SkillTemplate implements Serializable {

    private List<String> skills;

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
