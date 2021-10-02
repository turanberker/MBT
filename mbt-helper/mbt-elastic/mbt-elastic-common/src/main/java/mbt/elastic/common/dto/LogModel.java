package mbt.elastic.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LogModel extends LogPersistModel {

    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyyy HH:mm:ss")
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
