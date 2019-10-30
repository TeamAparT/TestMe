package JavaDsign;

public class Car extends Vehicles
{
	public Car( )
	{
		super.setvType( "车" );
		super.setStatu( 0 );
		super.setSpeed( 2 );
	}
	
	public String useVehicle()
	{
		return "正在开车";
	}
}
