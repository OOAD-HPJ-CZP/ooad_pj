package ooad.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2017/6/19.
 */
@Entity
public class Checklist {
    private int id;
    private int enterpriseId;
    private Date startTime;
    private Date endTime;
    private Date finishedTime;
    private String state;
    private Integer templateId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "enterprise_id")
    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Basic
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "finished_time")
    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "template_id")
    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Checklist checklist = (Checklist) o;

        if (id != checklist.id) return false;
        if (enterpriseId != checklist.enterpriseId) return false;
        if (startTime != null ? !startTime.equals(checklist.startTime) : checklist.startTime != null) return false;
        if (endTime != null ? !endTime.equals(checklist.endTime) : checklist.endTime != null) return false;
        if (finishedTime != null ? !finishedTime.equals(checklist.finishedTime) : checklist.finishedTime != null)
            return false;
        if (state != null ? !state.equals(checklist.state) : checklist.state != null) return false;
        if (templateId != null ? !templateId.equals(checklist.templateId) : checklist.templateId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + enterpriseId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (finishedTime != null ? finishedTime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (templateId != null ? templateId.hashCode() : 0);
        return result;
    }
}
