package models;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment extends BaseModel<Comment> {
    @Column
    private String content;
    @Column
    private Float mark;
    @Column(name = "insert_date")
    private Date insertTime;
    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
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
