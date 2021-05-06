package com.ithongchai.department.controller;


import com.ithongchai.department.entity.Department;
import com.ithongchai.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department create(@RequestBody Department department){
        log.info("Inside createDepartment method of Department controller");
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public  Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside findDepartmentById of Department controller");
        return  departmentService.findDepartmentById(departmentId);
    }

}
