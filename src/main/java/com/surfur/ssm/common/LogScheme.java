package com.surfur.ssm.common;

import java.util.stream.Stream;

public class LogScheme {

    /**
     * 业务模块
     */
    public enum App {
        NODE(0, "基础服务");

        App(Integer value, String message) {
        }

        public static App getApp(String appName) {
            return Stream.of(values()).filter(app -> app.name().equals(appName)).findFirst().orElse(null);
        }
    }

    /**
     * 操作类型
     */
    public enum OperationType {
        NONE(0, "静态资源访问"),

        USER_CREATE(1001, "新增用户"),
        USER_LIST(1002, "查询用户");

        private final Integer value;

        private final String message;

        OperationType(Integer value, String message) {
            this.value = value;
            this.message = message;
        }

        public Integer getValue() {
            return value;
        }

        public String getMessage() {
            return message;
        }

        public static OperationType getOperationType(String operationType) {
            return Stream.of(values()).filter(type -> type.name().equals(operationType)).findFirst().orElse(null);
        }
    }
}
