package JavaDsign;

public abstract class Vehicles implements UseVehicles
{
	private int statu = 1;//默认为1即该交通工具已被占用
	private int speed = 0;//交通工具速度值，默认为0
	private int cardID = 0;//默认为0，用于关联到司机
	private String vType = new String();//交通工具名字
	
	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}

	public Vehicles() {}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
