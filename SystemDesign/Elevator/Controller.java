public class Controller {
    Elevator[] arr;

    public Controller(int numElevators) {
        arr = new Elevator[numElevators];
    }

    public void populateElevators() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Elevator();
	}
    }

    public void setElevator(Elevator e, int col) {
	arr[col] = e;
    }

    public Elevator call(int floor) {
        int minDiff = Integer.MAX_VALUE;
        Elevator ret = null;
        for (Elevator e: arr) {
            int direction = e.getDirection();
            int eFloor = e.getFloor();
            if (sameDirection(eFloor, floor, direction)) {
                if (Math.abs(eFloor - floor) < minDiff) {
                    ret = e;
                }
            }
        }
	ret.addFloor(floor);
        return ret;
    }

    public void finishFloorQue(Elevator e) {
	while (e.hasNextFloor()) {
	    e.visitNextFloor();
	}
    }

    public void printElevators() {
	for (Elevator e: arr) {
	    System.out.print(e.getFloor()+" ");
	}
	System.out.println();
    }

    private boolean sameDirection(int floor1, int floor2, int direction) {
        if (floor1 <= floor2 && direction == 1) return true;
        if (floor1 >= floor2 && direction == 0) return true;
        return false;
    }

    public static void main(String[] args) {
	Controller cont = new Controller(4);
	cont.populateElevators();
	Elevator curr = cont.call(4);
	cont.finishFloorQue(curr);
	cont.printElevators();
    }

}