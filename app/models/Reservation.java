package models;

import org.joda.time.DateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation extends BaseModel<Reservation> {
    @Basic
    @Column(name = "tables", nullable = false)
    private Integer tables;
    @Basic
    @Column(name = "date", nullable = false)
    private DateTime date;
    //USER
    //RESTAURANT

    public Integer getTables() {
        return tables;
    }

    public void setTables(Integer tables) {
        this.tables = tables;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    @Override
    public void update(Reservation data) {
        if (data.getTables() != null) {
            setTables(data.getTables());
        }
        if (data.getDate() != null) {
            setDate(data.getDate());
        }

    }

}
