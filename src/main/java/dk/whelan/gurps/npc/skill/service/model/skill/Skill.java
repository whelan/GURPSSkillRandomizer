package dk.whelan.gurps.npc.skill.service.model.skill;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by lnorregaard on 31/12/15.
 */
public class Skill {
    @Id
    private String id;
    private String name;
    private String specialization;
    private String difficulty;
    private String reference;
    private int points;
    private String book;
    @Field("default")
    private String defaults;
    @Field("prereq_list")
    private Prereq prereqs;
    private Category categories;

    public Skill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDefaults() {
        return defaults;
    }

    public void setDefaults(String defaults) {
        this.defaults = defaults;
    }

    public Prereq getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(Prereq prereqs) {
        this.prereqs = prereqs;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public List<String> getCategoryList() {
        if (categories != null) {
            return categories.getCategories();
        }
        return null;
    }
    @Override
    public String toString() {
        return "skill{" +
                " name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", defaults='" + defaults + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", reference='" + reference + '\'' +
                ", points=" + points +
                ", book='" + book + '\'' +
                ", prereqs=" + prereqs +
                ", categories=" + getCategoryList() +
                '}';
    }
}
