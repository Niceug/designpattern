package com.leetp.designpattern.builder;

import java.io.Serializable;

/**
 * @Description 建造者模式
 * @Author litianpeng
 * @Date 2020/6/19
 */
public class Staff implements Serializable {
    private final int userId;
    private final String userName;
    private final int cityId;

    private Staff(int userId, String userName, int cityId) {
        this.userId = userId;
        this.userName = userName;
        this.cityId = cityId;
    }

    // getter省略

    public static StaffBuilder builder() {
        return new StaffBuilder();
    }

    public static class StaffBuilder {
        private int userId;
        private String userName;
        private int cityId;

        public StaffBuilder userId(int userId) {
            this.userId = userId;
            return this;
        }

        public StaffBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public StaffBuilder cityId(int cityId) {
            this.cityId = cityId;
            return this;
        }

        public Staff build() {
            Assert.isTrue(userId != 0, "userId不能为0");
            Assert.isTrue(!StringUtils.isEmpty(userName), "userName不能为空");
            Assert.isTrue(cityId != 0, "cityId不能为0");
            return new Staff(userId, userName, cityId);
        }
    }
}
