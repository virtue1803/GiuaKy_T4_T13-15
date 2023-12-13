package org.spring.testspring.enums;

public enum Roles {
    ADMINISTRATOR(1), STAFF(2), MANAGER(3), EXECUTIVE(4);

    private final int code;

    Roles(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
