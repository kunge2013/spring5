package cap3.bean;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public class MyModel {
    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }

    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private BigDecimal decimal;

    public static void main(String[] args) {
        MyModel m = new MyModel();
        System.out.println(m.getDecimal());
    }
}
