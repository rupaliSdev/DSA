package DSA.interviewProblems.IDFC;

public class CarTollCalculatorOpt {

    static class Car {
        int x, y;
        int dirIndex;
        boolean dirChanged;
        int totalCost;
        int[][] dirs = {
                {1, 0}, {0, 1}, {-1, 0}, {1, -1}};
        String[] dirName = {
                "+x", "+y", "-x", "-y"};

        public Car() {
            this.x = 0;
            this.y = 0;
            this.dirIndex = 0;
            this.dirChanged = false;
            this.totalCost = 0;

        }

        public String getDirection() {
            return dirName[dirIndex];
        }
    }

    public static void main(String[] args) {
        String[] input = {"F1", "TL", "F2", "TL", "F4"};

        Car car = new Car();

        for (String command : input) {
            processCommand(command, car);
            System.out.println("Cost: " + car.totalCost +
                    " Position: (" + car.x + "," + car.y + ")" +
                    " Direction: " + car.getDirection());
        }
    }


    public static void processCommand(String command, Car car) {
        switch (command) {
            case "TL":
                turnLeft(car);
                return;
            case "TR":
                turnRight(car);
                return;
            default:
                moveForward(car, command);

        }
    }

    private static void moveForward(Car car, String command) {
        int movement = Integer.parseInt(command.substring(1));
        car.x += car.dirs[car.dirIndex][0] * movement;
        car.y += car.dirs[car.dirIndex][1] * movement;

        if (car.dirChanged) {
            int quadrant = getQuadrant(car.x, car.y);
            car.totalCost += getQuadrantCost(quadrant);
            car.dirChanged = false;
        }

    }

    private static int getQuadrant(int x, int y) {
        if (x > 0 && y > 0) return 1;
        else if (x < 0 && y > 0) return 2;
        else if (x < 0 && y < 0) return 3;
        else return 4;
    }

    private static int getQuadrantCost(int quadrant) {
        switch (quadrant) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 0;
        }
    }

    private static void turnRight(Car car) {
        car.dirIndex = (car.dirIndex + 3) % 4;
        car.dirChanged = true;
    }

    public static void turnLeft(Car car) {
        car.dirIndex = (car.dirIndex + 1) % 4;
        car.dirChanged = true;
    }
}
