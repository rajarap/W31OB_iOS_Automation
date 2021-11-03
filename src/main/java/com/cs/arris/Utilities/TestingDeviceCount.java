package com.cs.arris.Utilities;

import com.cs.arris.Base.ParentClass;

public class TestingDeviceCount 
{
	public static void main(String args[])
	{
		ParentClass pc = new ParentClass();
		Integer count = pc.getCountOfDevicesWithSpace("Devices (2)");
		System.out.println(count.toString());
	
	}

}
