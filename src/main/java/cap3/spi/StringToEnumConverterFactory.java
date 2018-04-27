package cap3.spi;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

final class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {

    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnumConverter(targetType);
    }

    private final class StringToEnumConverter<T extends Enum> implements Converter<String, T> {
        private Class<T> enumType;
        public StringToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }
        public T convert(String source) {
            return (T) Enum.valueOf(this.enumType, source.trim());
        }
    }

    private final class StringToEnumConverter2<T extends Enum> implements Converter<String, T> {
        private Class<T> enumType;
        public StringToEnumConverter2(Class<T> enumType) {
            this.enumType = enumType;
        }
        public T convert(String source) {
            return (T) Enum.valueOf(this.enumType, source.trim());
        }
    }
}
