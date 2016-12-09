package entity;

//商品类
public class Items {

	private int id; // 商品编号
	private String name; // 商品名称
	private String city; // 产地
	private int price; // 价格
	private String picture; // 商品图片

	public Items(int id, String name, String city, int price, 
			String picture) {
		// TODO Auto-generated constructor stub
		this.id =id;
		this.name =name;
		this.city =city;
		this.price = price;
		this.picture = picture;
	}
	public Items(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id+this.getName().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj){
			return true;
		}
		if(obj instanceof Items){
			Items i = (Items) obj;
			if(this.getId()==i.getId()&&this.getName().equals(i.getName())){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	public String toStirng(){
		return "商品编号："+this.getId()+", 商品名称："+this.name+",每双价格"+this.price+",";
	}

}
