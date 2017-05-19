package com.sap.vean.cf.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sap.vean.api.odataapi.VehicleAPI;
import com.sap.vean.cf.samples.model.ResultData;
import com.sap.vean.foundation.connectivity.ConnectionFactory;
import com.sap.vean.foundation.connectivity.ConnectionFactoryException;
import com.sap.vean.foundation.odata.entityaccess.ODataEntityAccessException;

@Controller
@RequestMapping("/vehicle")
public class ServiceController {

	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public @ResponseBody ResultData listVehicles() {

		ResultData rs = new ResultData();

		try {
			ConnectionFactory cf = ConnectionFactory.createFactory("VehicleInsights");
			VehicleAPI vapi = new VehicleAPI(cf);
			rs.setResultobject(vapi.getAllVehicles());

			rs.setMessage("Cloud Foundry Service on Java using Spring");
			rs.setSuccess(true);

		} catch (ConnectionFactoryException e) {
			rs.setSuccess(false);
			rs.setMessage("Error: " + e.toString());
			log.error(e.toString());
		} catch (ODataEntityAccessException e) {
			rs.setSuccess(false);
			rs.setMessage("Error: " + e.toString());
			log.error(e.toString());
		}

		return rs;

	}
}
