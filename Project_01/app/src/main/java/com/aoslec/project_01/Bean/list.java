package com.aoslec.project_01.Bean;

import java.security.PrivateKey;

public class list {
    private String now;
    private String score;
    private String level;
    private String today;

    public list(String today, String now, String score, String level) {
        this.now = now;
        this.score = score;
        this.level = level;
    }

    public list(String now, String score, String today) {
        this.today = today;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }
    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
