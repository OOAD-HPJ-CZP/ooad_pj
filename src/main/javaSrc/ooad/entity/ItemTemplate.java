package ooad.entity;

import javax.persistence.*;

/**
 * Created by admin on 2017/6/19.
 */
@Entity
@Table(name = "item_template", schema = "ooad_pj", catalog = "")
@IdClass(ItemTemplatePK.class)
public class ItemTemplate {
    private int itemId;
    private int templateId;

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Id
    @Column(name = "template_id")
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

        ItemTemplate that = (ItemTemplate) o;

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
