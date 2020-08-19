package by.itacademy.mhl.bean;

public enum Role {
	USER, ADMIN;
	
	public static boolean contains(String s)
	  {
	      for(Role role:values())
	           if (role.name().equals(s)) 
	              return true;
	      return false;
	  } 
}
