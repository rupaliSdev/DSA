package DSA.interviewProblems.IDFC;

public class test {
    public static void main(String[] args) {
        String[] input = new String[]{"F1", "TL","F2","TL","F4"};
        Car car = new Car();
        for(String i :input){
            System.out.println(calculateCost(car,i) + " currDir " + car.curr[0]+","+ car.curr[1]);
        }
    }

    static class Car{
        int[] curr;
        String currDir;
        String nextDir;
        int cost;

        public Car() {
            this.curr = new int[]{0,0};
            this.currDir = "+x";
            this.nextDir ="+x";
            this.cost = 0;
        }
    }

    public static int calculateCost(Car car,String command){
        int movement = 0;
        int cost =0;
        String dir = findDir(command,car.currDir);

        if(dir.isBlank()) {
            movement= findMovement(command);
            if (movement > 0) {
                if (!car.currDir.equals(car.nextDir)) {
                    cost = findCost(car);
                    car.cost+=cost;

                }
                if (car.nextDir.equals("+x")) {
                    car.curr[0] = car.curr[0] + movement;
                }
                else if (car.nextDir.equals("-x")) {
                    car.curr[0] = car.curr[0] -movement;
                }
                else if (car.nextDir.equals("+y")) {
                    car.curr[1] = car.curr[1] + movement;
                }
                else if (car.nextDir.equals("-y")) {
                    car.curr[1] = car.curr[1] - movement;
                }
                car.currDir= car.nextDir;
            }
        }
        else {
            car.nextDir = dir;
        }
        return car.cost;
    }

    private static int findMovement(String substring) {

        return Integer.parseInt(substring);
    }

    private static int findCost(Car car){
        int cost =0;
        if(car.currDir.equals("+x") && car.nextDir.equals("+y")){
            cost+=1;
        }
        if(car.currDir.equals("-x") && car.nextDir.equals("+y")){
            cost+=2;
        }
        if(car.currDir.equals("-x") && car.nextDir.equals("-y")){
            cost+=3;
        }
        if(car.currDir.equals("+x") && car.nextDir.equals("-y")){
            cost+=4;
        }
        return cost;
    }

    private static String findDir(String command, String currDir) {
        String nextDir="";
        if(currDir.equals("+x" )&& (command.equals("TL")|| command.equals("TR") )){
            nextDir=command.equals("TL")?"+y":"-y";
        }
        else if(currDir.equals("+y") && (command.equals("TL")|| command.equals("TR")) ){
            nextDir= command.equals("TL")?"-x":"+x";
        }
        else if(currDir.equals("-x") && (command.equals("TL")|| command.equals("TR") ) ){
            nextDir=command.equals("TL")?"-y":"+y";
        }
        else if(currDir.equals("-y") && (command.equals("TL")|| command.equals("TR") )){
            nextDir= command.equals("TL")?"+x":"-x";
        }
        return nextDir;

    }
}
