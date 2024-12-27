package com.surfur.ssm.controller;

import com.surfur.ssm.common.PageBean;
import com.surfur.ssm.common.ResultUtil;
import com.surfur.ssm.domain.EmpEntity;
import com.surfur.ssm.service.EmpService;
import com.surfur.ssm.vo.req.EmpInsertReq;
import com.surfur.ssm.vo.req.EmpQueryReq;
import com.surfur.ssm.vo.req.EmpUpdateReq;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public ResultUtil<EmpEntity> findEmpById(@PathVariable("id") Integer id) {
        return ResultUtil.ok(empService.findEmpById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public ResultUtil<PageBean<EmpEntity>> findListPage(@PathVariable("currentPage") Integer currentPage,
                                             @PathVariable("pageSize") Integer pageSize,
                                             EmpQueryReq empQueryReq) {
            return ResultUtil.ok(empService.findListPage(currentPage, pageSize, empQueryReq));
    }

    @PostMapping
    public ResultUtil<?> insertEmp(@RequestBody EmpInsertReq empInsertReq) {
        empService.insertEmp(empInsertReq);
        return ResultUtil.ok();
    }

    @PutMapping
    public ResultUtil<?> updateEmp(@RequestBody EmpUpdateReq empUpdateReq) {
        empService.updateEmp(empUpdateReq);
        return ResultUtil.ok();
    }

    @DeleteMapping("{empId}")
    public ResultUtil<?> deleteEmp(@PathVariable("empId") Integer empId) {
        empService.deleteEmp(empId);
        return ResultUtil.ok();
    }
}
