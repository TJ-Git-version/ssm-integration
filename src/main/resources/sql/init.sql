CREATE DATABASE `ssm-integration` character set utf8;

USE `ssm-integration`;

CREATE TABLE `emp`
(
    empId     INT AUTO_INCREMENT,
    empName   CHAR(100),
    empSalary DOUBLE(10, 5),
    PRIMARY KEY (empId)
) comment '员工表';

INSERT INTO `emp`(empName, empSalary)
VALUES ('tom', 200.33);
INSERT INTO `emp`(empName, empSalary)
VALUES ('jerry', 666.66);
INSERT INTO `emp`(empName, empSalary)
VALUES ('andy', 777.77);
