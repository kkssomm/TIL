package day9.case4;

public class TV {
	
	private String model;
	private int size;
	private int channel;
	
	TV(){
	}
	
	TV(String model, int size, int channel){
		this.model = model;
		this.size = size;
		this.channel = channel;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	void channelUp() {
		channel++;
		if (channel > 10)
			channel = 1;
	}

	void chnnelDown() {
		channel--;
		if (channel<1)
			channel = 10;
	}
	
	

}
