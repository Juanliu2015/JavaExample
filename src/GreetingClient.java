import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class GreetingClient {
	
	

	public GreetingClient() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]){
			String serverName = args[0];
			int serverPort = Integer.parseInt(args[1]);
			try{
				System.out.println("Connecting to " + serverName + " on port " + serverPort);
				Socket client = new Socket(serverName, serverPort);
				System.out.println("Just connected to " + client.getRemoteSocketAddress());
				OutputStream outToServer = client.getOutputStream();
				DataOutputStream out = new DataOutputStream(outToServer);
				out.writeUTF("Hello from"+client.getLocalAddress());
				InputStream inFromServer = client.getInputStream();
				DataInputStream in = new DataInputStream(inFromServer);
				System.out.println("Server says"+in.readUTF());
				client.close();
								
			}catch(IOException i){
				i.printStackTrace();
			}
	}

}
