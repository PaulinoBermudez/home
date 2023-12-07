//*********************************************************************************************************************************
//PAQUETE
//*********************************************************************************************************************************	
//package Gestion_Taller;
//*********************************************************************************************************************************
//LIBRER�AS IMPORTADAS
//*********************************************************************************************************************************	
import javax.swing.*;
//*********************************************************************************************************************************
//CLASEPRINCIPAL
//*********************************************************************************************************************************	
public class Taller{
	//*********************************************************************************************************************************
	//Constructor Principal. Inicio de Ejecuci�n
	//*********************************************************************************************************************************	
	public static void main(String[] args){
		
		String StringOpcion;
		
		int opcion = 0;
		
		JOptionPane.showMessageDialog(null,"Hola, el siguiente programa le solicitar� a continuaci�n que seleccione una serie de opciones.\n"
				+ "Por favor, responda con franqueza.");
		//*********************************************************************************************************************************
		//INICIO DOwhile 1: Secci�n Principal
		//*********************************************************************************************************************************	
		do{  // PRIMER DO
		
		
		
			//Mensaje de bienvenida.
			StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de usuario al que pertenece:\n1. Mec�nico\n2. Comercial\n3. Jefatura\n4. Salir");
			//Sistema de control para evitar que el usuario introduzca valores no num�ricos.
			try{
				opcion=Integer.parseInt(StringOpcion);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,  "Error, solo se permiten n�meros.");
				opcion=0;
			}
			//*********************************************************************************************************************************
			//INICIO SWITCH 1: Men� principal de selecci�n de Usuarios
			//*********************************************************************************************************************************	
			switch(opcion){
				case 0:
					JOptionPane.showMessageDialog(null,"Opci�n no v�lida. Por favor, introduzca un valor del men�.");
					break;
				case 1:
					JOptionPane.showMessageDialog(null,"Has accedido a: Mec�nico");
					//*********************************************************************************************************************************
					//INICIO DOwhile 2:Secci�n Mec�nicos
					//*********************************************************************************************************************************	
					
					int mecanicos = 0; // NUEVA VARIABLE. COTROLA EL MENU  MECANICO
					
					do{
						//Mensaje de bienvenida.
						StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de acci�n a realizar:\n1. Asignaci�n de Fichas de Reparaci�n.\n2. Editar Fichas.\n3. Crear Listados.\n4. Salir");
						//Sistema de control para evitar que el usuario introduzca valores no num�ricos.
						try{
							mecanicos=Integer.parseInt(StringOpcion);
						}catch(NumberFormatException ex){
							JOptionPane.showMessageDialog(null,  "Error, solo se permiten n�meros.");
							mecanicos=0;
						}
						//*********************************************************************************************************************************
						//INICIO SWITCH 2: Men� de gesti�n de tar�as para Mec�nicos
						//*********************************************************************************************************************************
						switch(mecanicos){
							case 0:
								JOptionPane.showMessageDialog(null,"Opci�n no v�lida. Por favor, introduzca un valor del men�.");
								break;
							case 1:
								JOptionPane.showMessageDialog(null,"Has accedido a: Asignaci�n de Fichas de Reparaci�n.");
								
								break;
							case 2:
								JOptionPane.showMessageDialog(null,"Has accedido a: Editar Fichas.");
								break;
							case 3:
								JOptionPane.showMessageDialog(null,"Has accedido a: Crear Listados.");
								//*********************************************************************************************************************************
								//INICIO DOwhile 3: 
								//*********************************************************************************************************************************
								
								
								int mecanicos2 = 0; // NUEVA VARIABLE. COTROLA EL SUBMENU  MECANICO
								do{
									//Mensaje de bienvenida.
									StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de acci�n a realizar:\n1. Listar veh�culos reparados durante un periodo.\n2. Listar fichas totales procesadas por cada mec�nico.\n3. Listar fichas en proceso.\n4. Salir");
									//Sistema de control para evitar que el usuario introduzca valores no num�ricos.
									try{
										mecanicos2=Integer.parseInt(StringOpcion);
									}catch(NumberFormatException ex){
										JOptionPane.showMessageDialog(null,  "Error, solo se permiten n�meros.");
										mecanicos2 =0;
									}
									//*********************************************************************************************************************************
									//INICIO SWITCH 3: Men� de Listados de Fichas para Mec�nicos.
									//*********************************************************************************************************************************
									switch(mecanicos2){
										case 0:
											JOptionPane.showMessageDialog(null,"Opci�n no v�lida. Por favor, introduzca un valor del men�.");
											break;
										case 1:
											JOptionPane.showMessageDialog(null,"Has accedido a: Listar veh�culos reparados durante un periodo.");
											break;
										case 2:
											JOptionPane.showMessageDialog(null,"Has accedido a: Listar fichas totales procesadas por cada mec�nico.");
											break;
										case 3:
											JOptionPane.showMessageDialog(null,"Has accedido a: Listar fichas en proceso.");
											break;
										case 4:
											JOptionPane.showMessageDialog(null,"Adi�s. Espero verle pronto.");
											break;
										default:
											JOptionPane.showMessageDialog(null,"Opci�n no v�lida.");
											break;
									}
									//*********************************************************************************************************************************
									//FIN SWITCH 3: Men� de Listados de Fichas para Mec�nicos.
									//*********************************************************************************************************************************
								}while(mecanicos2!=4);
								//*********************************************************************************************************************************
								//FIN DOwhile 3: 
								//*********************************************************************************************************************************
								break;
							case 4:
						//		JOptionPane.showMessageDialog(null,"Adi�s. Espero verle pronto.");
								JOptionPane.showMessageDialog(null,"A continuaci�n se le devolver� al men� principal.");
								
								break;
							default:
								JOptionPane.showMessageDialog(null,"Opci�n no v�lida.");
								break;
						}
						//*********************************************************************************************************************************
						//FIN SWITCH 2: Men� de gesti�n de tar�as para Mec�nicos
						//*********************************************************************************************************************************
					}while(mecanicos!=4); // CORREGIDO CIERRA EL MENU MECANICO
					
					break;
					
					
					
					//*********************************************************************************************************************************
					//INICIO DOwhile 2:Secci�n Comercial
					//*********************************************************************************************************************************
					
				case 2:
					
					JOptionPane.showMessageDialog(null,"Has accedido a: Comercial");
					do{
						//Mensaje de bienvenida.
						StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de acci�n a realizar:\n1. Ofertas y Promociones.\n2. Relaci�n Cliente/Oferta.\n3. Correo Electr�nico.\n4. Gesti�n de Servivio Integral de Revisi�n T�cnica ITV.\n5. Salir");
						//Sistema de control para evitar que el usuario introduzca valores no num�ricos.
						try{
							opcion=Integer.parseInt(StringOpcion);
						}catch(NumberFormatException ex){
							JOptionPane.showMessageDialog(null,  "Error, solo se permiten n�meros.");
							opcion=0;
						}
						//Men� principal de gesti�n de actividades para comerciales..
						switch(opcion){
							case 0:
								JOptionPane.showMessageDialog(null,"Opci�n no v�lida. Por favor, introduzca un valor del men�.");
								break;
							case 1:
								JOptionPane.showMessageDialog(null,"Has accedido a: Ofertas y Promociones.");
								break;
							case 2:
								JOptionPane.showMessageDialog(null,"Has accedido a: Relaci�n Cliente/Oferta.");
								break;
							case 3:
								JOptionPane.showMessageDialog(null,"Has accedido a: Correo Electr�nico.");
								break;
							case 4:
								JOptionPane.showMessageDialog(null,"Has accedido a: Gesti�n de Servivio Integral de Rev. T�c. ITV.");
								break;
							case 5:
								JOptionPane.showMessageDialog(null,"A continuaci�n se le devolver� al men� principal.");
								break;
							default:
								JOptionPane.showMessageDialog(null,"Opci�n no v�lida.");
						}
					
					}while(opcion!=5);
					break;
				case 3:
					JOptionPane.showMessageDialog(null,"Has accedido a: Jefatura.");
					do{
						//Mensaje de bienvenida.
						StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de acci�n a realizar:\n1. Gesti�n de Operaciones de Mec�nicos.\n2. Gesti�n de Operaciones de Comerciales.\n3. Gesti�n de Trabajadores.\n4. Listados.\n5. Salir");
						//Sistema de control para evitar que el usuario introduzca valores no num�ricos.
						try{
							opcion=Integer.parseInt(StringOpcion);
						}catch(NumberFormatException ex){
							JOptionPane.showMessageDialog(null,  "Error, solo se permiten n�meros.");
							opcion=0;
						}
						//Men� principal de gesti�n de actividades para comerciales..
						switch(opcion){
							case 0:
								JOptionPane.showMessageDialog(null,"Opci�n no v�lida. Por favor, introduzca un valor del men�.");
								break;
							case 1:
								JOptionPane.showMessageDialog(null,"Has accedido a: Gesti�n de Operaciones de Mec�nicos.");
								break;
							case 2:
								JOptionPane.showMessageDialog(null,"Has accedido a: Gesti�n de Operaciones de Comerciales.");
								break;
							case 3:
								JOptionPane.showMessageDialog(null,"Has accedido a: Gesti�n de Trabajadores.");
								break;
							case 4:
								JOptionPane.showMessageDialog(null,"Has accedido a: Listados.");
								break;
							case 5:
								JOptionPane.showMessageDialog(null,"A continuaci�n se le devolver� al men� principal.");
								break;
							default:
								JOptionPane.showMessageDialog(null,"Opci�n no v�lida.");
						}
					
					}while(opcion!=5);
					break;
				case 4:
					JOptionPane.showMessageDialog(null,"Adi�s. Espero verle pronto.");
					break;
				default:
					JOptionPane.showMessageDialog(null,"Opci�n no v�lida.");
			}
			//*********************************************************************************************************************************
			//FIN SWITCH 1: Men� principal de selecci�n de Usuarios
			//*********************************************************************************************************************************	
		
		
		}while(opcion!=4); // CIERRO PRIMER DO
		
	
		//*********************************************************************************************************************************
		//FIN DOwhile 1: Secci�n Principal
		//*********************************************************************************************************************************
	}
	
}
