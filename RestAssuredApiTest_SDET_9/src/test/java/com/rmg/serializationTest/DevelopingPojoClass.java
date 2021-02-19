package com.rmg.serializationTest;
/*
 * {name:'akilesh',
	pnno:[
			1234,
			56789
		],
	address:[
			{
				address1:add1
			},
			{
				address2:add2
			}
			]
	}

 */
public class DevelopingPojoClass {

	String name;
	
	int[] phNo;
	
	Address[] address;

	public DevelopingPojoClass(String name, int[] phNo, Address[] address) {
		
		this.name = name;
		this.phNo = phNo;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getPhNo() {
		return phNo;
	}

	public void setPhNo(int[] phNo) {
		this.phNo = phNo;
	}

	public Address[] getAddress() {
		return address;
	}

	public void setAddress(Address[] address) {
		this.address = address;
	}
	
	
	
}
