package DriverUtils;

import com.experitest.client.Client;
import com.experitest.client.GridClient;


/**
 * Created by Vinay.Misra on 25/08/2017.
 */
public class DriverUtil {

	public static Client client = null;
	private static String accessKey = "eyJ4cC51Ijo1NywieHAucCI6MTgsInhwLm0iOiJNVFV5TVRZM016STNNVFU0T0EiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4MzcwMzMyNzIsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.0V13HSyn8kxKOV3n3kxikoXOt93MjJ1tewmtStD1v4w";
	public static GridClient gridClient = new GridClient(accessKey,"https://demo.experitest.com:443/wd/hub");
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
		System.out.println("==================== startDriver===============");
		client = gridClient.lockDeviceForExecution(testName, deviceQuery, true,10, 600*1000);
		webDriverLocalThread.set(client);
	}

	public static Client getClient(){
		System.out.println("==================== getClient=================");
		return webDriverLocalThread.get();
		//return client;
	}

}
