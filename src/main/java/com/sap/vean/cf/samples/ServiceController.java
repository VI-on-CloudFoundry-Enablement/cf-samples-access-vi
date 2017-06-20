package com.sap.vean.cf.samples;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sap.vean.api.gen.entity.sap.vean.LastTimeSeriesItem;
import com.sap.vean.api.gen.entity.sap.vean.TimeSeries;
import com.sap.vean.api.gen.entity.sap.vean.Vehicle;
import com.sap.vean.api.odataapi.TimeSeriesAPI;
import com.sap.vean.api.odataapi.VehicleAPI;
import com.sap.vean.cf.samples.model.ResultData;
import com.sap.vean.cf.samples.model.VehiclePosition;
import com.sap.vean.foundation.connectivity.ConnectionFactory;
import com.sap.vean.foundation.connectivity.ConnectionFactoryException;
import com.sap.vean.foundation.odata.ODataTools;
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
	
	@RequestMapping(path = "/latestpositions", method = RequestMethod.GET)
	public @ResponseBody ResultData listVehiclePositions() {

		ResultData rs = new ResultData();

		String property = "sap.vean::AnyVehicle__positionGeoPosition";
		
		try {
			ConnectionFactory cf = ConnectionFactory.createFactory("VehicleInsights");
			VehicleAPI vapi = new VehicleAPI(cf);
			List<Vehicle> vehicles = vapi.getAllVehicles();
			
			ArrayList<VehiclePosition> vecPosList = new ArrayList<VehiclePosition>();
			
			TimeSeriesAPI tsapi = new TimeSeriesAPI(cf);
			
			List<TimeSeries> tss = tsapi.getTimeSeriesForProperty(property);
			for (TimeSeries ts : tss) {
				String vecUID = ts.getVehicleUID();
				Vehicle vehicle = new ODataTools<Vehicle>().getEntityByUID(vehicles, vecUID);
				LastTimeSeriesItem ltsi = tsapi.getLatestTimeSeriesItem(ts.getUID());
				
				VehiclePosition vecPos = new VehiclePosition();
				vecPos.setVehicleUID(ts.getVehicleUID());
				vecPos.setVehicleID(vehicle.getID());
				vecPos.setVehicleName(vehicle.getName());
				vecPos.setPointInTime(ltsi.getPointInTime());
				vecPos.setPosition(ltsi.getGeoPosition());
				vecPosList.add(vecPos);				
			}
				
			rs.setResultobject(vecPosList);
			rs.setMessage("Retrieving all last time series items");
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
