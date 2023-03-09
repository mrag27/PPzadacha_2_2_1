package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
