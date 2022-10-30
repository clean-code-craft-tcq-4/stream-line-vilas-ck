import constants.BmsConstants;
import models.Battery;
import sensors.StateOfChargeSensor;
import sensors.TemperatureSensor;

import java.util.ArrayList;
import java.util.List;

public class Sender {
	static StateOfChargeSensor socSensor ;
	static  TemperatureSensor tempSensor;
    
	public static Battery getBatteryStatus(StateOfChargeSensor socSensor, TemperatureSensor tempSensor) {
		Battery battery = new Battery();
        battery.setSoc(socSensor.getStateOfCharge());
        battery.setTemp(tempSensor.getTemperature());
        return battery;
	}


	public static void printBatteryStatus(List<Battery> batteries) {
		for (Battery battery:
			 batteries) {
			System.out.println(battery);
		}

	}		
	
	public static void main(String[] args) {
    	
    	socSensor = new StateOfChargeSensor(BmsConstants.MIN_SOC,BmsConstants.MAX_SOC);
        tempSensor = new TemperatureSensor(BmsConstants.MIN_TEMP, BmsConstants.MAX_TEMP);
        printBatteryStatus(getSensorData(50, socSensor, tempSensor));
    }
    private static List<Battery> getSensorData(int count,StateOfChargeSensor socSensor, TemperatureSensor tempSensor){
		List<Battery> batteries = new ArrayList<>();

		for (int i=0;i<count;i++) {
			batteries.add(getBatteryStatus(socSensor, tempSensor));
		}
		return batteries;
	}

}

