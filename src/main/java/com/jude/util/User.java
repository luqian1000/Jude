package com.jude.util;

public class User {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof User) {
            User otherUser = (User) obj;
            if (otherUser.sex.equals(this.sex) && otherUser.name.equals(this.name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 1;
        int code = 31;
        result = code * result + (name == null ? 0 : name.hashCode());
        result = code * result + (sex == null ? 0 : sex.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "User:name" + name + ",sex" + sex;
    }
}
