package com.github.yazhuo.reponse;

public class ResponseUserProfile {

    private String username;
    private String email;
    private String role;
    private String groupExpire;
    private Integer emailVerified;
    private String diskUsage;
    private String diskLimit;
    private Long diskUsageRaw;
    private Long diskLimitRaw;

    @Override
    public String toString() {
        return "ResponseUserProfile{" +
                "username='" + this.username + '\'' +
                ", email='" + this.email + '\'' +
                ", role='" + this.role + '\'' +
                ", groupExpire='" + this.groupExpire + '\'' +
                ", emailVerified=" + this.emailVerified +
                ", diskUsage='" + this.diskUsage + '\'' +
                ", diskLimit='" + this.diskLimit + '\'' +
                ", diskUsageRaw=" + this.diskUsageRaw +
                ", diskLimitRaw=" + this.diskLimitRaw +
                '}';
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(final String role) {
        this.role = role;
    }

    public String getGroupExpire() {
        return this.groupExpire;
    }

    public void setGroupExpire(final String groupExpire) {
        this.groupExpire = groupExpire;
    }

    public Integer getEmailVerified() {
        return this.emailVerified;
    }

    public void setEmailVerified(final Integer emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getDiskUsage() {
        return this.diskUsage;
    }

    public void setDiskUsage(final String diskUsage) {
        this.diskUsage = diskUsage;
    }

    public String getDiskLimit() {
        return this.diskLimit;
    }

    public void setDiskLimit(final String diskLimit) {
        this.diskLimit = diskLimit;
    }

    public Long getDiskUsageRaw() {
        return this.diskUsageRaw;
    }

    public void setDiskUsageRaw(final Long diskUsageRaw) {
        this.diskUsageRaw = diskUsageRaw;
    }

    public Long getDiskLimitRaw() {
        return this.diskLimitRaw;
    }

    public void setDiskLimitRaw(final Long diskLimitRaw) {
        this.diskLimitRaw = diskLimitRaw;
    }
}
