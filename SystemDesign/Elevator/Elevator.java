import java.util.*;

public class Elevator {
    int floor;
    int direction;
    Queue<Integer> floorQue;

    public Elevator(int floor, int direction) {
	this.floor = floor;
	this.direction = direction;
	this.floorQue = new LinkedList<Integer>();
    }

    public Elevator() {
	this.floor = 0;
	this.direction = 1;
	this.floorQue = new LinkedList<Integer>();
    }

    public int getFloor() {
	return floor;
    }

    public void setFloor(int floor) {
	this.floor = floor;
    }

    public int getDirection() {
	return direction;
    }

    public void setDirection(int direction) {
	this.direction = direction;
    }

    public void addFloor(int floor) {
	System.out.println(floorQue == null);
	this.floorQue.add(floor);
    }
    
    public boolean hasNextFloor() {
	return this.floorQue.size() > 0;
    }

    public void visitNextFloor() {
	int curr = this.floorQue.poll();
	this.floor = curr;
    }

}