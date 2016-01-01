package dk.whelan.gurps.npc.skill.service.model.skill;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by lnorregaard on 01/01/16.
 */
public class Prereq {
    private String all;
    @Field("skill_prereq")
    private String skillPrereq;
    @Field("attribute_prereq")
    private String attributePrereq;
    @Field("advantage_prereq")
    private String advantagePrereq;

    public Prereq() {
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getSkillPrereq() {
        return skillPrereq;
    }

    public void setSkillPrereq(String skillPrereq) {
        this.skillPrereq = skillPrereq;
    }

    public String getAttributePrereq() {
        return attributePrereq;
    }

    public void setAttributePrereq(String attributePrereq) {
        this.attributePrereq = attributePrereq;
    }

    public String getAdvantagePrereq() {
        return advantagePrereq;
    }

    public void setAdvantagePrereq(String advantagePrereq) {
        this.advantagePrereq = advantagePrereq;
    }

    @Override
    public String toString() {
        return "Prereq(" +
                "all='" + all + '\'' +
                ", skillPrereq='" + skillPrereq + '\'' +
                ", attributePrereq='" + attributePrereq + '\'' +
                ", advantagePrereq='" + advantagePrereq + '\'' +
                ')';
    }
}
