package com.mindtree.bbapis.entity;

public class CustomerInformation {
		private String name;
		private String emailId;
		private Long customer_id;
		private String password;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public Long getMobile() {
			return customer_id;
		}
		public void setcustomer_id(Long customer_id) {
			this.customer_id = customer_id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		@Override
	    public String toString()
	    {
	        return "ClassPojo [customer_Id = "+customer_id+", customer_Name = "+name+", customer_email = "+emailId+", customer_mobileNumber = "+customer_id+"]";
	    }
}
