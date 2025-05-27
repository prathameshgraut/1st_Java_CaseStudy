import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private Map<String, Device> devices;

    public Room(String name) {
        this.name = name;
        this.devices = new HashMap<>();
    }

    public void addDevice(String deviceName) {
        if (!devices.containsKey(deviceName)) {
            devices.put(deviceName, new Device(deviceName));
            System.out.println("Device " + deviceName + " added to " + name);
        } else {
            System.out.println("Device already exists in " + name);
        }
    }

    public void controlDevice(String deviceName, boolean turnOn) {
        Device device = devices.get(deviceName);
        if (device != null) {
            if (turnOn) {
                device.turnOn();
            } else {
                device.turnOff();
            }
        } else {
            System.out.println("Device not found in " + name);
        }
    }

    public void showDevicesStatus() {
        if (devices.isEmpty()) {
            System.out.println("No devices in " + name);
        } else {
            for (Device device : devices.values()) {
                System.out.println(device.getStatus());
            }
        }
    }

    public void showDeviceUsage() {
        if (devices.isEmpty()) {
            System.out.println("No devices in " + name);
        } else {
            for (Map.Entry<String, Device> entry : devices.entrySet()) {
                System.out.println(entry.getKey() + " usage time: " + entry.getValue().getUsageTime() + " seconds");
            }
        }
    }
}

