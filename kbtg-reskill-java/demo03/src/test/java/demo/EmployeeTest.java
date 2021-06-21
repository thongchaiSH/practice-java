package demo;

import org.joda.time.DateTimeUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


class EmployeeTest {

    @InjectMocks
    private Employee employee;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void should_return_ages_26() throws ParseException {
        String birthDate="09/11/1994";
        employee.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(birthDate));
        Integer age=employee.calculateAge();

        assertThat(age).isEqualTo(26);
        DateTimeUtils.setCurrentMillisSystem();
    }

    @Test
    void calculateAge() {
        Employee thongchai=new Employee();
        assertThat(thongchai.calculateAge()).isEqualTo(0);
    }
}