package com.utils;

import java.util.HashMap;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerCapabalities {

	private static AppiumDriverLocalService service;

	public static String startServer() {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		HashMap<String, String> environment = new HashMap<>();
		builder.withIPAddress("127.0.0.1");
		builder.usingAnyFreePort();
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
		environment.put("PATH", System.getenv("PATH"));
		builder.withEnvironment(environment);
		builder.withArgument(() -> "--allow-insecure", "chromedriver_autodownload");
		service = AppiumDriverLocalService.buildService(builder);
		service.start();

		String serverUrl = service.getUrl().toString();
		System.out.println("Appium local service is started :: " + service.isRunning());
		System.out.println("Appium local service URL :: " + serverUrl);

		return serverUrl;
	}

	public static void stopServer() {
		if (service != null)
			service.stop();
	}

}
