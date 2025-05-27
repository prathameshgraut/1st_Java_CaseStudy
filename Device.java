public class Device {
    private String name;
    private boolean isOn;
    private long usageTime;
    private long lastTurnedOn;

    public Device(String name) {
        this.name = name;
        this.isOn = false;
        this.usageTime = 0;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            lastTurnedOn = System.currentTimeMillis();
            System.out.println(name + " is now ON.");
        } else {
            System.out.println(name + " is already ON.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            usageTime += (System.currentTimeMillis() - lastTurnedOn) / 1000;
            System.out.println(name + " is now OFF.");
        } else {
            System.out.println(name + " is already OFF.");
        }
    }

    public String getStatus() {
        return name + " is " + (isOn ? "ON" : "OFF");
    }

    public long getUsageTime() {
        return usageTime;
    }
}