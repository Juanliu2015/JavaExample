import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class GreetingServer {
	private ServerSocket serverSocket;

	public GreetingServer(int port) throws IOException {
		// TODO Auto-generated constructor stub
		serverSocket =new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	
	void run(){
		while(true){
			try{
				System.out.println("Waitting for client on port"+serverSocket.getLocalPort()+"......");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to "+server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				System.out.println("Client says"+in.readUTF());
				out.writeUTF("Thank you for connecting to "+server.getLocalSocketAddress()+"GOOD BYE" );
				server.close();
				
				
			}catch(SocketTimeoutException s){
				System.out.println("Time out");
				break;
			}catch(IOException e){
				e.printStackTrace();
				break;
			}
		}
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException {
		// TODO Auto-generated method stub
		
		int port = Integer.parseInt(args[0]);
	      try
	      {
	         GreetingServer t = new GreetingServer(port);
	         t.run();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }

	}

}
