package JavaDsign;

public class Car extends Vehicles
{
	public Car( )
	{
		super.setvType( "��" );
		super.setStatu( 0 );
		super.setSpeed( 2 );
	}
	
	public String useVehicle()
	{
		return "���ڿ���";
	}
}
