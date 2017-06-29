package leetcode.com.qa;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProxyServerUtilities {

	public static void main(String[] args) {
		
		BrowserMobProxy proxy = new BrowserMobProxyServer();
	    proxy.start(0);
	    int port = proxy.getPort(); 
	    // get the Selenium proxy object
	    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
	    
	    // configure it as a desired capability
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

	    // start the browser up
	    WebDriver driver = new FirefoxDriver(capabilities);

	    // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
	    proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

	    // create a new HAR with the label "yahoo.com"
	    proxy.newHar("yahoo.com");

	    // open yahoo.com
	    driver.get("http://yahoo.com");

	    // get the HAR data
	    Har har = proxy.getHar();

	}

}
