package models;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation extends BaseModel<Reservation> {
    @Basic
    @Column(name = "tables", nullable = false)
    private Integer tables;
    @Basic
    @Column(name = "reservation_date", nullable = false)
    private DateTime reservationDate;
    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable=false)
    private Restaurant restaurant;

    public Integer getTables() {
        return tables;
    }

    public void setTables(Integer tables) {
        this.tables = tables;
    }

    public DateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(DateTime date) {
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
