package cap3.spi;


import org.springframework.core.convert.converter.Converter;

/**
 * 类型转换器
 */
public class StringToInteger implements Converter<String,Integer> {

    @Override
    public Integer convert(String s) {
        return Integer.valueOf(s);
    }
}
