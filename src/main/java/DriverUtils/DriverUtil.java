package DriverUtils;

import com.experitest.client.Client;
import com.experitest.client.GridClient;

public class DriverUtil {

	public static Client client;
	private static String accessKey = "eyJ4cC51Ijo1NywieHAucCI6MTgsInhwLm0iOiJNVFV5TVRZM016STNNVFU0T0EiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4MzcwMzMyNzIsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.0V13HSyn8kxKOV3n3kxikoXOt93MjJ1tewmtStD1v4w";
	public static GridClient gridClient;
	private static final ThreadLocal<Client> webDriverLocalThread = new ThreadLocal<Client>();

	private static final Thread CLOSE_THREAD = new Thread() {

		@Override
		public void run() {
			client.releaseClient();
		}
	};
	static  {
		webDriverLocalThread.remove();
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}

	public static void startDriver(String testName, String deviceQuery) {
		gridClient = new GridClient(accessKey,"demo.experitest.com",443,true);
		client = gridClient.lockDeviceForExecution(testName, deviceQuery, true,10, 600*1000);
		webDriverLocalThread.set(client);
	}

	public static Client getClient(){
		return webDriverLocalThread.get();
	}

}
