package com.github.arsengir;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {
    private final Boolean verified;
    private final int sentCount;

    public Status(
            @JsonProperty("verified") Boolean verified,
            @JsonProperty("sentCount") int sentCount) {
        this.verified = verified;
        this.sentCount = sentCount;
    }

    public Boolean getVerified() {
        return verified;
    }

    public int getSentCount() {
        return sentCount;
    }

    @Override
    public String toString() {
        return "{" +
                "verified=" + verified +
                ", sentCount=" + sentCount +
                '}';
    }
}
