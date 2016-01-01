package dk.whelan.gurps.npc.skill.service.model.skill;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by lnorregaard on 01/01/16.
 */
public class Category {
    @Field("category")
    private List<String> categories;

    public Category() {
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categories=" + categories +
                '}';
    }
}
