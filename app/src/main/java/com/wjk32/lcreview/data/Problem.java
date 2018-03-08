package com.wjk32.lcreview.data;

/**
 * Created by wjk32 on 2/15/2018.
 */

public class Problem {
    int id;
    public String title;
    String slug;
    int difficulty;
    int paid_only;
    String status;
    int total_acs;
    int total_submitted;
    int favorite;


    public Problem(int id, String title, String slug, int difficulty, int paid_only, String status,
                   int total_acs, int total_submitted, int favorite) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.difficulty = difficulty;
        this.paid_only = paid_only;
        this.status = status;
        this.total_acs = total_acs;
        this.total_submitted = total_submitted;
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getPaid_only() {
        return paid_only;
    }

    public String getStatus() {
        return status;
    }

    public int getTotal_acs() {
        return total_acs;
    }

    public int getTotal_submitted() {
        return total_submitted;
    }

    public int getFavorite() {
        return favorite;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", difficulty=" + difficulty +
                ", paid_only=" + paid_only +
                ", status='" + status + '\'' +
                ", total_acs=" + total_acs +
                ", total_submitted=" + total_submitted +
                ", favorite=" + favorite +
                '}';
    }
}
