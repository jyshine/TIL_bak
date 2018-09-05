package objectUtils.VO;

import java.util.ArrayList;

public class UserVO extends PersonVO{
	private String id;
	private String name;
	private String address;
	private String tel;
	private String phone;
	private String nick;
	private String info;
	
	private ArrayList<UserVO> arraylist;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public ArrayList<UserVO> getArraylist() {
		return arraylist;
	}
	public void setArraylist(ArrayList<UserVO> arraylist) {
		this.arraylist = arraylist;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", address=" + address + ", tel=" + tel + ", phone=" + phone
				+ ", nick=" + nick + ", info=" + info + ", getAge()=" + getAge() + ", getHomeTown()=" + getHomeTown()
				+ ", getDream()=" + getDream() + "]";
	}
	

	
}
