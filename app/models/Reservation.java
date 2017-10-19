package models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation extends BaseModel<Reservation> {
    @Column
    private Integer tables;
    @Column(name = "reservation_date")
    private Date reservationDate;
    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Integer getTables() {
        return tables;
    }

    public void setTables(Integer tables) {
        this.tables = tables;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date date) {
        this.reservationDate = date;
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
    public void update(Reservation data) {
        if (data.getTables() != null) {
            setTables(data.getTables());
        }
        if (data.getReservationDate() != null) {
            setReservationDate(data.getReservationDate());
        }
        if (data.getAccount() != null) {
            setAccount(data.getAccount());
        }
        if (data.getAccount() != null) {
            setAccount(data.getAccount());
        }

    }

}
