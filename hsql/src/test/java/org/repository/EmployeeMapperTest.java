package org.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.repository.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * ${DESCRIPTION}
 *
 * @author spiral
 * @date 2020/4/21
 * @copyright spiral
 * @since 1.0 Version
 */


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeMapperTest {


    @Autowired
    private EmployeeMapper employeeMapper;


    @Test
    void getEmployee() {
        List<Employee> employeeList = employeeMapper.getEmployee();
        assertEquals("查询结果集大小", 3, employeeList.size());
        for (Employee employee : employeeList) {
            if (employee.getId().equals(1)) {
                assertEquals("姓名是小白", "小白", employee.getLastName());
            } else if (employee.getId().equals(2)) {
                assertEquals("姓名是小明", "小明", employee.getLastName());
            } else if (employee.getId().equals(3)) {
                assertEquals("姓名是小红", "小红", employee.getLastName());
            }
        }
    }
}