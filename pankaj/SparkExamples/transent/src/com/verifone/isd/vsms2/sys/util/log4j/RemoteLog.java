package com.verifone.isd.vsms2.sys.util.log4j;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoteLog {
	
	private String file  = "RemoteLog";	
	private String serverIp;
	private int serverPort;
	private int handShakeTimeoutDuration;
	private int openRetryCount;
	private static RemoteLog remoteLog;
	private Logger logger = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.log4j.RemoteLog.class);

	private RemoteLog() {

		setConfiguration();
	}

	static {
		remoteLog = new RemoteLog();
	}

	public static RemoteLog getInstance(){
		return remoteLog;
	}

	private void setConfiguration(){

		serverIp = SysPropertyFactory.getProperty("log.server.hostname");
		if(serverIp == null) {
            serverIp = "192.168.31.1";
        }

		String hostPort = SysPropertyFactory.getProperty("log.server.port"); //change the server port
		try{
			serverPort = Integer.parseInt(hostPort);
		}catch(Exception e){
			serverPort = 514;
		}	

		String retry = SysPropertyFactory.getProperty("log.server.openRetry");
		try{
			openRetryCount = Integer.parseInt(retry);
		}catch(Exception e){
			openRetryCount = 3;
		}

		String timeout = SysPropertyFactory.getProperty("log.server.handShake.time");
		try{
			handShakeTimeoutDuration = Integer.parseInt(timeout) * 1000;
		}catch(Exception e){
			handShakeTimeoutDuration = 5000;
		}

	}
		
	private boolean isExternalUDPServerRunning(){
		DatagramPacket response = null;
		DatagramSocket socket = null;
		InetAddress address = null;
		boolean udpServerRunning = false;

		try {
			address = InetAddress.getByName(serverIp);
			socket =  new DatagramSocket();
			//String isAliveCheckMsg = "isAliveTestMessage";
			String msg =  "isAliveTestMessage";

			for(int retry = 0; retry < openRetryCount; retry++){
				DatagramPacket packet = new DatagramPacket(msg.getBytes(),msg.getBytes().length,address,serverPort);
				socket.send(packet);
				byte[] buf = new byte[1024];
				response = new java.net.DatagramPacket(buf, buf.length,address,serverPort);
				//new DatagramPacket(buf.getBytes(),msg.getBytes().length,address,514);
				socket.setSoTimeout(handShakeTimeoutDuration);
				socket.receive(response);				
				String respMsg  = new String(response.getData()).trim();
				System.out.println("Reponse is :" + respMsg);

				if(respMsg != null && respMsg.equals("isAlive")){
					udpServerRunning = true;
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (socket != null){
				try {
					socket.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return udpServerRunning;
	}
	
	public synchronized boolean isRemoteServerReachable(){
		boolean isLogServerAlive = false;
		boolean isSCinV950Mode = false;
		
		try {
			String fileName =  SysPropertyFactory.getProperty("v950.status.check.file.path","/var/run/v950sc.mnt");
			if (new File (fileName).exists()){
				isSCinV950Mode = true;
			}	
			if (isSCinV950Mode){
				isLogServerAlive = true;
			}else{
				isLogServerAlive = isExternalUDPServerRunning();
			}			
			
		} catch (Exception ex) {
			ex.printStackTrace();			
		}
		logger.info("isRemoteServerReachable ?" + isLogServerAlive);
		return isLogServerAlive;
		
	}
	
}