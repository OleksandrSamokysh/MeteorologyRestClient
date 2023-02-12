package aleks.spring.MeteorologyRestClient.DTO;

import java.util.List;

public class DataResponse {
    private List<DataDTO> response;

    public List<DataDTO> getResponse() {
        return response;
    }

    public void setResponse(List<DataDTO> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ListData{" +
                "data=" + response +
                '}';
    }
}
