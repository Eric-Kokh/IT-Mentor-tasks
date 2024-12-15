public class Car {
    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    private String model;
    private String colour;
    private Double engineCapacity;

    public Car(String model, String colour, Double engineCapacity) {
        this.model = model;
        this.colour = colour;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
