package com.hpss.api.resources.get;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpss.api.beans.resp.ServerDataResp;

@Path("/apidata")
public class GetDataHPSS {

	@GET
	@Path("server/get/api_key/{api_key}/device_id/{device_id}")
	@Produces("application/json")
	public Response getdataHPSS(@PathParam("api_key") String api_key, @PathParam("device_id") String device_id,
			String jsonReqString) {
		
		ServerDataResp iServerDataResp = new ServerDataResp();
		ObjectMapper mapper = new ObjectMapper();
        int response_code = 200;
		
        try {

			if (api_key.equalsIgnoreCase("reda")) {
				
				iServerDataResp.setDatetime("28-04-2022 13:15:00");
				iServerDataResp.setDeviceInfo("Hello Mister Reda");
				iServerDataResp.setDeviceName("Yoiur device is 007 - " + device_id);
				iServerDataResp.setDeviceStatus("UP");
                 
				response_code = 200; 
				
			} else if (api_key.equalsIgnoreCase("oubada")) {
				
				iServerDataResp.setDatetime("28-04-2022 13:15:00");
				iServerDataResp.setDeviceInfo("Hello Mister Oubada");
				iServerDataResp.setDeviceName("Yoiur device is 009" + device_id);
				iServerDataResp.setDeviceStatus("UP");
				
				response_code = 200;
				
			} else {
				
				iServerDataResp.setDatetime("28-04-2022 13:15:00");
				iServerDataResp.setDeviceInfo("Device note defined");
				iServerDataResp.setDeviceName("Please check with your admin");
				iServerDataResp.setDeviceStatus("DOWN");

				response_code = 201;
			}
			
			String jsonRespString;

			jsonRespString = mapper.writeValueAsString(iServerDataResp);

			return Response.status(response_code).entity(jsonRespString).build();


		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return Response.status(201).entity("{JsonProcessingException}").build();
		}

	}

}
