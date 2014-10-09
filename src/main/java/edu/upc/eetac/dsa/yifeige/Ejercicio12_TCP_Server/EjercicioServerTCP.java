package edu.upc.eetac.dsa.yifeige.Ejercicio12_TCP_Server;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.Date;

public class EjercicioServerTCP 
{
    public static void main( String[] args )
    {
        int PortNumber=7001;
        try
        {   
        	ServerSocket SocketServidor=new ServerSocket(PortNumber);
        	System.out.print("Socket construido esperando una conexion");
        	Socket SocketCliente=SocketServidor.accept();
        	
        	Date fecha=new Date();
        	SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        	
        	PrintWriter escritor=new PrintWriter(SocketCliente.getOutputStream());
        	BufferedReader lector=new BufferedReader(new InputStreamReader(SocketCliente.getInputStream()));
        	
        	int opcionRecibido;
        	opcionRecibido=Integer.parseInt(lector.readLine());
        	if(opcionRecibido==0)
        	{
        		escritor.println("Hola" + formato.format(fecha));
        	}
        	else
        		System.exit(1);
         }
        catch(IOException e)
        {
        	System.out.println("Exception caught when trying to listen on port "+ PortNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
        
    }
}
