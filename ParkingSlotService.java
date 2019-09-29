package com.parkingslot.services;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import com.parkingslot.interfaces.ParkingSlotInterface;
import com.parkingslot.models.CarModel;

/*
 * Class to service the different functionalities
 * of parking slot
 */
public class ParkingSlotService implements ParkingSlotInterface {
	
	// Data structures used to hold in memory data
	// Queue will hold availabale slots in sequence during allot and deallot process
	
	public static Queue<Integer> slotQueue = new LinkedList<>();
	
	// hashmap to store slot - Car mapping 
	public static Map<Integer,CarModel> slotMap = new LinkedHashMap<>();
	
	public static Integer length = 0;

	public static void initializeSlot() {
		for(int i =1;i<=length;i++) {
			slotQueue.add(i);
		}	
	}
	
	/*
	 *allotting lot to park car
	 */
	@Override
	public String allotSlot(CarModel car) {	
		Integer slotNumberAvail = slotQueue.remove();
		
		if(null!= slotNumberAvail) {
			
			slotMap.put(slotNumberAvail, car);
			return slotNumberAvail.toString();
		}
		return "No Slots Available";
	}

	/*
	 * deallot slots when car is parked out
	 */
	@Override
	public String deAllotSlot(Integer slotNumber) {
		
		if((slotQueue.contains(slotNumber)) && (!(null !=slotMap.get(slotNumber))))
			return "Slot is currently empty";
		
		CarModel carDetails = slotMap.get(slotNumber);
		slotQueue.add(slotNumber);
		slotMap.put(slotNumber, null);
		
		return "Car Details ::"+carDetails.getCarSerialNumber()+"::"+carDetails.getColor();
		
	}

	/*
	 * Get the details of the car parked in the given slot
	 */
	@Override
	public CarModel seekDetails(Integer slotNumber) {
			if((slotQueue.contains(slotNumber)) && (!(null != slotMap.get(slotNumber))))
				return null;
			
			CarModel carDetails = slotMap.get(slotNumber);	
			return carDetails;
		
	}
	
	

}
