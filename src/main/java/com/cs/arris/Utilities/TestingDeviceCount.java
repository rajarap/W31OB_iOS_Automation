package com.cs.arris.Utilities;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.DeviceSignalStrengthLeaderBoardPage;

public class TestingDeviceCount 
{
	public static void main(String args[])
	{
//		ParentClass pc = new ParentClass();
//		Integer count = pc.getCountOfDevicesWithSpace("Devices (2)");
//		System.out.println(count.toString());
		
		ParentClass pc = new ParentClass();
		int i = pc.getDeviceSignalStrengthCount("02 Devices");
		System.out.println(i);
	
	}
	
	

}
