import java.util.Scanner;

import com.parkingslot.models.CarModel;
import com.parkingslot.services.ParkingSlotService;

public class ParkingSlotApplication {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		ParkingSlotService.length = scnr.nextInt();
		
		ParkingSlotService.initializeSlot();
		
		CarModel car1 = new CarModel();
		car1.setCarSerialNumber("TS07FQ2056");
		car1.setColor("Black");
		
		System.out.println(new ParkingSlotService().allotSlot(car1));
		CarModel car = new ParkingSlotService().seekDetails(scnr.nextInt());
		if(null != car) {
			System.out.println("Car details::"+car.getCarSerialNumber()+"::"+car.getColor());
		}
		
		else {
			System.out.println("No Car in the specified slot");
		}
		
		
		

	}

}
