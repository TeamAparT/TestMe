package JavaDsign;

public class ShipDriver extends Drivers
{
	public ShipDriver() {}
	public ShipDriver( int cardID, String name ) 
	{ 
		super.setCardID( cardID ); 
		super.setCardStatu( 0 );
		super.setName( name );
		super.setSpeed( 1 );
	}
}
