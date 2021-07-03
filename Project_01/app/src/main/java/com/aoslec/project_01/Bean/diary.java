package com.aoslec.project_01.Bean;

public class diary {
    private String today;
    private String now;
    private String score;
    private String level;
    private String memo;

    public diary(String today, String now, String score, String level, String memo) {
        this.today = today;
        this.now = now;
        this.score = score;
        this.level = level;
        this.memo = memo;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
