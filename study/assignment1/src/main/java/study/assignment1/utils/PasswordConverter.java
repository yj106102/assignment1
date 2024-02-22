package study.assignment1.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Converter
public class PasswordConverter implements AttributeConverter<String,String> {
    private final PasswordEncoder passwordEncoder;

    public PasswordConverter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String convertToDatabaseColumn(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public String convertToEntityAttribute(String password) {
        return password;
    }
}
