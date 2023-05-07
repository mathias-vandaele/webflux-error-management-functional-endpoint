package dev.mathiasvandaele.errormanagement.dto;

import dev.mathiasvandaele.errormanagement.errorsmanagement.BusinessException;
import dev.mathiasvandaele.errormanagement.errorsmanagement.TechnicalException;

import java.util.Objects;
import java.util.Random;

public class DummyReturn {
    public final Integer id;
    public final String name;

    private static final Random random = new Random();

    public DummyReturn(String name) {
        this.name = name;
        this.id = random.nextInt(20);
        if (Objects.equals(name, "error")) {
            throw new BusinessException(100, "Error in DummyReturn constructor", "Enter a correct name");
        }
        if (this.id > 10) {
            throw new TechnicalException("An error happened while attributing the ID");
        }
    }

}
