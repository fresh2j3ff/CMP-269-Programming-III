
public abstract class SmartDevice implements Powerable {

	protected String deviceName;
	protected boolean isOn;
	static int activeDevicesCount = 0;
	
	public SmartDevice(String deviceName) {
		this.deviceName = deviceName;
		this.isOn = false;
	}
	
	abstract void performSelfDiagnostic();
	
	public void turnOn() {
        if (!isOn) {
            isOn = true;
            activeDevicesCount++;
        }
    }
	
	public void turnOff() {
        if (isOn) {
            isOn = false;
            activeDevicesCount--;
        }
    }
	
	
	
	
	
	
	
	
}
