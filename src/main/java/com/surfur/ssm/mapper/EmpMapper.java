package com.surfur.ssm.mapper;

import com.surfur.ssm.domain.EmpEntity;
import com.surfur.ssm.vo.req.EmpInsertReq;
import com.surfur.ssm.vo.req.EmpQueryReq;
import com.surfur.ssm.vo.req.EmpUpdateReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author key point
* description 针对表【emp(员工表)】的数据库操作Mapper
* createDate 2024-12-26 23:06:55
* Entity com.surfur.ssm.domain.EmpEntity
*/
@Repository
@Mapper
public interface EmpMapper {

    EmpEntity findEmpById(Integer id);

    List<EmpEntity> findEmpList(EmpQueryReq empQueryReq);

    void insertEmp(EmpInsertReq empInsertReq);

    void updateEmp(EmpUpdateReq empUpdateReq);

    void deleteEmp(Integer empId);

}
