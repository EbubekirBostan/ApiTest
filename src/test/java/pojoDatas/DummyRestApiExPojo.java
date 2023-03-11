package pojoDatas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import pojoDatas.DummyRestApiPojo;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyRestApiExPojo {

    private String status;
    private DummyRestApiPojo data;
    private String message;

    public DummyRestApiExPojo() {
    }

    public DummyRestApiExPojo(String status, DummyRestApiPojo dummyRestApiPojo, String message) {
        this.status = status;
        this.data = dummyRestApiPojo;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiPojo getData() {
        return data;
    }

    public void setDummyRestApiPojo(DummyRestApiPojo dummyRestApiPojo) {
        this.data = dummyRestApiPojo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
