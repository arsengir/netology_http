package com.github.arsengir;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CatFact {
    private final Status status;
    private final String type;
    private final Boolean deleted;
    private final String _id;
    private final String user;
    private final String text;
    private final int __v;
    private final String source;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private final LocalDateTime updatedAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private final LocalDateTime createdAt;
    private final Boolean used;

    public CatFact(
            @JsonProperty("status") Status status,
            @JsonProperty("type") String type,
            @JsonProperty("deleted") Boolean deleted,
            @JsonProperty("_id") String _id,
            @JsonProperty("user") String user,
            @JsonProperty("text") String text,
            @JsonProperty("__v") int __v,
            @JsonProperty("source") String source,
            @JsonProperty("updatedAt") LocalDateTime updatedAt,
            @JsonProperty("createdAt") LocalDateTime createdAt,
            @JsonProperty("used") Boolean used) {
        this.status = status;
        this.type = type;
        this.deleted = deleted;
        this._id = _id;
        this.user = user;
        this.text = text;
        this.__v = __v;
        this.source = source;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.used = used;
    }

    public Status getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public String get_id() {
        return _id;
    }

    public String getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public int get__v() {
        return __v;
    }

    public String getSource() {
        return source;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Boolean getUsed() {
        return used;
    }

    @Override
    public String toString() {
        return "CatFact{" +
                "status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", deleted=" + deleted +
                ", _id='" + _id + '\'' +
                ", user='" + user + '\'' +
                ", text='" + text + '\'' +
                ", __v=" + __v +
                ", source='" + source + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", used=" + used +
                '}';
    }
}
