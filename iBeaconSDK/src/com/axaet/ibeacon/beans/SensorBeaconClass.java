package com.axaet.ibeacon.beans;

import android.bluetooth.BluetoothDevice;

public class SensorBeaconClass {

	static public class SensorBeacon implements Comparable<SensorBeacon> {
		public String name;
		public String bluetoothAddress;
		public int temperature;
		public int humidity;
		public int rssi;
		public int battery ;

		@Override
		public int compareTo(SensorBeacon another) {
			if (this.rssi < another.rssi)
				return 1;
			if (this.rssi > another.rssi)
				return -1;
			return 0;
		}
	}

	public static SensorBeacon fromScanData(BluetoothDevice device, int rssi, byte[] scanRecord) {
		SensorBeacon sensorBeacon = new SensorBeacon();
		sensorBeacon.battery  = scanRecord[11];
		sensorBeacon.temperature = scanRecord[12];
		sensorBeacon.humidity = scanRecord[13];
		sensorBeacon.name = device.getName();
		sensorBeacon.bluetoothAddress = device.getAddress();
		return sensorBeacon;
	}
}
