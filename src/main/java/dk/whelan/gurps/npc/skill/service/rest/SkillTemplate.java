package dk.whelan.gurps.npc.skill.service.rest;

import dk.whelan.gurps.npc.skill.service.model.skill.Category;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lnorregaard on 04/02/16.
 */
public class SkillTemplate implements Serializable {

    private int maxPointSkill = 1;
    private List<String> includedSkills;
    private Category excludeCategory;


    public List<String> getIncludedSkills() {
        return includedSkills;
    }

    public void setIncludedSkills(List<String> includedSkills) {
        this.includedSkills = includedSkills;
    }

    public Category getExcludeCategory() {
        return excludeCategory;
    }

    public void setExcludeCategory(Category excludeCategory) {
        this.excludeCategory = excludeCategory;
    }

    public int getMaxPointSkill() {
        return maxPointSkill;
    }
}
