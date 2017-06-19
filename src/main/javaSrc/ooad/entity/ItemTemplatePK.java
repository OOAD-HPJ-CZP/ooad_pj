package ooad.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by admin on 2017/6/19.
 */
public class ItemTemplatePK implements Serializable {
    private int itemId;
    private int templateId;

    @Column(name = "item_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Column(name = "template_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemTemplatePK that = (ItemTemplatePK) o;

        if (itemId != that.itemId) return false;
        if (templateId != that.templateId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + templateId;
        return result;
    }
}
