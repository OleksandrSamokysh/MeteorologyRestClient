package aleks.spring.MeteorologyRestClient.DTO;


public class DataDTO {

    private Double value;

    private Boolean raining;

    private SensorDTO sensor;

//    public DataDTO(Double value, Boolean raining, SensorDTO sensor) {
//        this.value = value;
//        this.raining = raining;
//        this.sensor = sensor;
//    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean isRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "value=" + value +
                ", raining=" + raining +
                ", sensor=" + sensor +
                '}';
    }
}
