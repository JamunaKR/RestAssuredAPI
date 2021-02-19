package com.rmg.serializationTest;

public class Demo {
	
	public static void main(String[] args) {
		int[] phNo= {1234,56789};
		Address[] address=new Address[] {new Address("add1"),new Address("add2")};
		DevelopingPojoClass obj = new DevelopingPojoClass("Akilesh", phNo, address);
		System.out.println(obj.address[0].address);
		System.out.println(obj.phNo[0]);
	}

}
