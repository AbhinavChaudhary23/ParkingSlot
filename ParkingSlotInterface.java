package com.parkingslot.interfaces;

import com.parkingslot.models.CarModel;

public interface ParkingSlotInterface {

	public abstract String allotSlot(CarModel car);
	public abstract String deAllotSlot(Integer slotNumber);
	public abstract CarModel seekDetails(Integer slotNumber);
}
