package models;

import org.joda.time.DateTime;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable=false)
    private Restaurant restaurant;


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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
        if (data.getAccount() != null) {
            setAccount(data.getAccount());
        }
        if (data.getRestaurant() != null) {
            setRestaurant(data.getRestaurant());
        }

    }
}
