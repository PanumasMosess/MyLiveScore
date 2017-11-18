package com.juck.jxk.mylivescore.Model;

/**
 * Created by JXK on 18/11/2560.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class FixtureManager {
    @SerializedName("fixtures")
    @Expose
    private List<Fixture> fixtures = null;

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }
}
