package com.surfur.ssm.controller;

import com.surfur.ssm.domain.EmpEntity;
import com.surfur.ssm.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dev Surfer
 * @version 1.0.0
 * date 2024/12/26 23:15
 * description emp控制层处理器
 */
@RestController
@RequestMapping("/emp")
@AllArgsConstructor
public class EmpController {

    private final EmpService empService;

    @GetMapping("{id}")
    public ResponseEntity<EmpEntity> findEmpById(@PathVariable("id") Integer id) {
        return new ResponseEntity<EmpEntity>(empService.findEmpById(id), HttpStatus.OK);
    }

}
