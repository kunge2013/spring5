package cap3.edit.type;

import java.util.Date;

public class CustomerDate {
    public Long getOpTimeout() {
        return opTimeout;
    }

    public void setOpTimeout(Long opTimeout) {
        this.opTimeout = opTimeout;
    }

    Long opTimeout ;
    Date date;
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Customer [date=" + date + ":opTimeout:"+opTimeout+"]";
    }
}
