package mbt.elastic.common.dto;

import javax.validation.constraints.NotBlank;
import java.util.Map;

public class LogPersistModel {

    @NotBlank
    private String logType;

    @NotBlank
    private String message;

    private Map<String, Object> attributes;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
