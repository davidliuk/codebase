package design.ood;

import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLotSystem {
    public AtomicInteger big = new AtomicInteger();
    public AtomicInteger medium = new AtomicInteger();
    public AtomicInteger small = new AtomicInteger();

    public ParkingLotSystem(int big, int medium, int small) {
        this.big.set(big);
        this.medium.set(medium);
        this.small.set(small);
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                return big.decrementAndGet() >= 0;
            case 2:
            case 3:
            default:
                return false;
        }
    }
}
