package com.sap.vean.transodata;

import java.util.Map;

import org.odata4j.core.OEntity;
import org.odata4j.core.OEntityId;
import org.odata4j.core.OEntityKey;
import org.odata4j.core.OExtension;
import org.odata4j.core.OFunctionParameter;
import org.odata4j.edm.EdmDataServices;
import org.odata4j.edm.EdmFunctionImport;
import org.odata4j.producer.BaseResponse;
import org.odata4j.producer.CountResponse;
import org.odata4j.producer.EntitiesResponse;
import org.odata4j.producer.EntityIdResponse;
import org.odata4j.producer.EntityQueryInfo;
import org.odata4j.producer.EntityResponse;
import org.odata4j.producer.ODataProducer;
import org.odata4j.producer.QueryInfo;
import org.odata4j.producer.edm.MetadataProducer;

public class VIonAEODataService implements ODataProducer{

	public <TExtension extends OExtension<ODataProducer>> TExtension findExtension(Class<TExtension> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResponse callFunction(EdmFunctionImport arg0, Map<String, OFunctionParameter> arg1, QueryInfo arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public EntityResponse createEntity(String arg0, OEntity arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityResponse createEntity(String arg0, OEntityKey arg1, String arg2, OEntity arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createLink(OEntityId arg0, String arg1, OEntityId arg2) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEntity(String arg0, OEntityKey arg1) {
		// TODO Auto-generated method stub
		
	}

	public void deleteLink(OEntityId arg0, String arg1, OEntityKey arg2) {
		// TODO Auto-generated method stub
		
	}

	public EntitiesResponse getEntities(String arg0, QueryInfo arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public CountResponse getEntitiesCount(String arg0, QueryInfo arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityResponse getEntity(String arg0, OEntityKey arg1, EntityQueryInfo arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityIdResponse getLinks(OEntityId arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public EdmDataServices getMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	public MetadataProducer getMetadataProducer() {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseResponse getNavProperty(String arg0, OEntityKey arg1, String arg2, QueryInfo arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public CountResponse getNavPropertyCount(String arg0, OEntityKey arg1, String arg2, QueryInfo arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public void mergeEntity(String arg0, OEntity arg1) {
		// TODO Auto-generated method stub
		
	}

	public void updateEntity(String arg0, OEntity arg1) {
		// TODO Auto-generated method stub
		
	}

	public void updateLink(OEntityId arg0, String arg1, OEntityKey arg2, OEntityId arg3) {
		// TODO Auto-generated method stub
		
	}

	
}
