
public class SmartLight extends SmartDevice implements Adjustable {
    private int brightness = 0;

    public SmartLight(String deviceName) {
        super(deviceName);
    }

    @Override
    public void setLevel(int level) {
        if (!isOn) {
            System.out.println("Cannot adjust: Device is OFF.");
        } else {
            this.brightness = level;
            System.out.println(deviceName + " brightness set to " + level + "%.");
        }
    }

    @Override
    public void performSelfDiagnostic() {
        System.out.println(deviceName + ": Checking LED health...");
    }
}