
public abstract class Shopper implements ShoppingTimeRemaining
{
	
	String shopperType;
	
	public Shopper()
	{
		setShopperType("");
	}
	
	public Shopper(String shopperType)
	{
		setShopperType(shopperType);
	}
	
	public String getShopperType() 
	{
		return shopperType;
	}

	public void setShopperType(String shopperType) 
	{
		this.shopperType = shopperType;
	}

	public abstract void setTimeIntoCheckoutLine(int value);

	public abstract int getTotalTimeCheckingOut();

}
