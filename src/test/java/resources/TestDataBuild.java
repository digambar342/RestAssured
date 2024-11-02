package resources;

import pojo.CreateUserReq;

public class TestDataBuild {

	public CreateUserReq createUserPayLoad(String name, String job) {
		 CreateUserReq createUserReqObj= new CreateUserReq();
		   createUserReqObj.setName(name);
		   createUserReqObj.setJob(job);
		   return createUserReqObj;
	}
}
