package org.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.repository.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author spiral
 * @date 2020/4/21
 * @copyright spiral
 * @since 1.0 Version
 */
@Repository
@Mapper
public interface EmployeeMapper {

    @Select("select id, last_name lastName, gender, email from employee")
    List<Employee> getEmployee();

}