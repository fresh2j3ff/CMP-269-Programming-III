import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<SmartDevice> homeHub = new ArrayList<>();

        SmartLight livingRoomLight = new SmartLight("Living Room");
        SmartLight kitchenLight = new SmartLight("Kitchen");
        SmartThermostat hallwayThermostat = new SmartThermostat("Hallway");

        homeHub.add(livingRoomLight);
        homeHub.add(kitchenLight);
        homeHub.add(hallwayThermostat);

        livingRoomLight.turnOn();
        hallwayThermostat.turnOn();

        kitchenLight.setLevel(75);

        System.out.println("Total Active Devices: " + SmartDevice.activeDevicesCount);

        System.out.println("\n--- Running Diagnostics ---");
        for (SmartDevice device : homeHub) {
            device.performSelfDiagnostic();
        }
    }
}
