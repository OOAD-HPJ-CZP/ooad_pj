package ooad.entity;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by admin on 2017/6/19.
 */
@Entity
public class Template {
    private int id;
    private String templateName;
    private String description;
    @Transient
    private ArrayList<Integer> checkitemsIdList = new ArrayList<Integer>();

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "template_name")
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Template template = (Template) o;

        if (id != template.id) return false;
        if (templateName != null ? !templateName.equals(template.templateName) : template.templateName != null)
            return false;
        if (description != null ? !description.equals(template.description) : template.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (templateName != null ? templateName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Transient
    public void addCheckItemsById(int checkitemsId) {
        this.checkitemsIdList.add(checkitemsId);
    }

    @Transient
    public ArrayList<Integer> getCheckItemsList(){
        return this.checkitemsIdList;
    }


}
