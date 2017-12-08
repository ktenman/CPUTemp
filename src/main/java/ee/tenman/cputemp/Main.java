package ee.tenman.cputemp;

import oshi.SystemInfo;
import oshi.hardware.Sensors;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SystemInfo si = new SystemInfo();
        Sensors s = si.getHardware().getSensors();
        long times = 43200;
        Double temp = 0D;
        for (int i = 1; i <= times; i++) {
            double cpuTemperature = s.getCpuTemperature();
            temp += cpuTemperature;
            TimeUnit.SECONDS.sleep(1);
            System.out.println(String.format("%s. %s; Average: %s", i, cpuTemperature, temp / i));
        }
        System.out.println("Average: " + temp / times);
    }
}
