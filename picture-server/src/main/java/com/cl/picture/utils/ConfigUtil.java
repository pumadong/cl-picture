package com.cl.picture.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigUtil {
	
	private @Value("${cas.server.url}")String casServerUrl;
	private @Value("${cas.service.url}")String casServiceUrl;
	private @Value("${web.basepath}")String basePath;
	private @Value("${inc.basepath}")String incBasePath;
	private @Value("${picture.location}")String pictureLocation;
	
	public String getCasServerUrl() {
		return casServerUrl;
	}
	
	public String getCasServiceUrl() {
		return casServiceUrl;
	}

	public String getBasePath() {
		return basePath;
	}
	
	public String getIncBasePath() {
		return incBasePath;
	}
	
	public String getPictureLocation() {
		return pictureLocation + File.separator + "pics" + File.separator + "c" + File.separator;
	}
}
