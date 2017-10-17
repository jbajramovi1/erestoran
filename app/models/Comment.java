package models;

import org.joda.time.DateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment extends BaseModel<Comment> {
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "mark", nullable = false)
    private Integer mark;
    @Basic
    @Column(name = "insert_date")
    private DateTime insertTime;
    //USER
    //RESTAURANT

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public DateTime getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(DateTime insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public void update(Comment data) {
        if (data.getContent() != null) {
            setContent(data.getContent());
        }
        if (data.getMark() != null) {
            setMark(data.getMark());
        }
        if (data.getInsertTime() != null) {
            setInsertTime(data.getInsertTime());
        }

    }
}
