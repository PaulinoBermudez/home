//*********************************************************************************************************************************
//PAQUETE
//*********************************************************************************************************************************	
//package Gestion_Taller;
//*********************************************************************************************************************************
//LIBRERÍAS IMPORTADAS
//*********************************************************************************************************************************	
import javax.swing.*;
//*********************************************************************************************************************************
//CLASEPRINCIPAL
//*********************************************************************************************************************************	
public class Taller{
	//*********************************************************************************************************************************
	//Constructor Principal. Inicio de Ejecución
	//*********************************************************************************************************************************	
	public static void main(String[] args){
		
		String StringOpcion;
		
		int opcion = 0;
		
		JOptionPane.showMessageDialog(null,"Hola, el siguiente programa le solicitará a continuación que seleccione una serie de opciones.\n"
				+ "Por favor, responda con franqueza.");
		//*********************************************************************************************************************************
		//INICIO DOwhile 1: Sección Principal
		//*********************************************************************************************************************************	
		do{  // PRIMER DO
		
		
		
			//Mensaje de bienvenida.
			StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de usuario al que pertenece:\n1. Mecánico\n2. Comercial\n3. Jefatura\n4. Salir");
			//Sistema de control para evitar que el usuario introduzca valores no numéricos.
			try{
				opcion=Integer.parseInt(StringOpcion);
			}catch(NumberFormatException ex){
				JOptionPane.showMessageDialog(null,  "Error, solo se permiten números.");
				opcion=0;
			}
			//*********************************************************************************************************************************
			//INICIO SWITCH 1: Menú principal de selección de Usuarios
			//*********************************************************************************************************************************	
			switch(opcion){
				case 0:
					JOptionPane.showMessageDialog(null,"Opción no válida. Por favor, introduzca un valor del menú.");
					break;
				case 1:
					JOptionPane.showMessageDialog(null,"Has accedido a: Mecánico");
					//*********************************************************************************************************************************
					//INICIO DOwhile 2:Sección Mecánicos
					//*********************************************************************************************************************************	
					
					int mecanicos = 0; // NUEVA VARIABLE. COTROLA EL MENU  MECANICO
					
					do{
						//Mensaje de bienvenida.
						StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de acción a realizar:\n1. Asignación de Fichas de Reparación.\n2. Editar Fichas.\n3. Crear Listados.\n4. Salir");
						//Sistema de control para evitar que el usuario introduzca valores no numéricos.
						try{
							mecanicos=Integer.parseInt(StringOpcion);
						}catch(NumberFormatException ex){
							JOptionPane.showMessageDialog(null,  "Error, solo se permiten números.");
							mecanicos=0;
						}
						//*********************************************************************************************************************************
						//INICIO SWITCH 2: Menú de gestión de taréas para Mecánicos
						//*********************************************************************************************************************************
						switch(mecanicos){
							case 0:
								JOptionPane.showMessageDialog(null,"Opción no válida. Por favor, introduzca un valor del menú.");
								break;
							case 1:
								JOptionPane.showMessageDialog(null,"Has accedido a: Asignación de Fichas de Reparación.");
								
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
									StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de acción a realizar:\n1. Listar vehículos reparados durante un periodo.\n2. Listar fichas totales procesadas por cada mecánico.\n3. Listar fichas en proceso.\n4. Salir");
									//Sistema de control para evitar que el usuario introduzca valores no numéricos.
									try{
										mecanicos2=Integer.parseInt(StringOpcion);
									}catch(NumberFormatException ex){
										JOptionPane.showMessageDialog(null,  "Error, solo se permiten números.");
										mecanicos2 =0;
									}
									//*********************************************************************************************************************************
									//INICIO SWITCH 3: Menú de Listados de Fichas para Mecánicos.
									//*********************************************************************************************************************************
									switch(mecanicos2){
										case 0:
											JOptionPane.showMessageDialog(null,"Opción no válida. Por favor, introduzca un valor del menú.");
											break;
										case 1:
											JOptionPane.showMessageDialog(null,"Has accedido a: Listar vehículos reparados durante un periodo.");
											break;
										case 2:
											JOptionPane.showMessageDialog(null,"Has accedido a: Listar fichas totales procesadas por cada mecánico.");
											break;
										case 3:
											JOptionPane.showMessageDialog(null,"Has accedido a: Listar fichas en proceso.");
											break;
										case 4:
											JOptionPane.showMessageDialog(null,"Adiós. Espero verle pronto.");
											break;
										default:
											JOptionPane.showMessageDialog(null,"Opción no válida.");
											break;
									}
									//*********************************************************************************************************************************
									//FIN SWITCH 3: Menú de Listados de Fichas para Mecánicos.
									//*********************************************************************************************************************************
								}while(mecanicos2!=4);
								//*********************************************************************************************************************************
								//FIN DOwhile 3: 
								//*********************************************************************************************************************************
								break;
							case 4:
						//		JOptionPane.showMessageDialog(null,"Adiós. Espero verle pronto.");
								JOptionPane.showMessageDialog(null,"A continuación se le devolverá al menú principal.");
								
								break;
							default:
								JOptionPane.showMessageDialog(null,"Opción no válida.");
								break;
						}
						//*********************************************************************************************************************************
						//FIN SWITCH 2: Menú de gestión de taréas para Mecánicos
						//*********************************************************************************************************************************
					}while(mecanicos!=4); // CORREGIDO CIERRA EL MENU MECANICO
					
					break;
					
					
					
					//*********************************************************************************************************************************
					//INICIO DOwhile 2:Sección Comercial
					//*********************************************************************************************************************************
					
				case 2:
					
					JOptionPane.showMessageDialog(null,"Has accedido a: Comercial");
					do{
						//Mensaje de bienvenida.
						StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de acción a realizar:\n1. Ofertas y Promociones.\n2. Relación Cliente/Oferta.\n3. Correo Electrónico.\n4. Gestión de Servivio Integral de Revisión Técnica ITV.\n5. Salir");
						//Sistema de control para evitar que el usuario introduzca valores no numéricos.
						try{
							opcion=Integer.parseInt(StringOpcion);
						}catch(NumberFormatException ex){
							JOptionPane.showMessageDialog(null,  "Error, solo se permiten números.");
							opcion=0;
						}
						//Menú principal de gestión de actividades para comerciales..
						switch(opcion){
							case 0:
								JOptionPane.showMessageDialog(null,"Opción no válida. Por favor, introduzca un valor del menú.");
								break;
							case 1:
								JOptionPane.showMessageDialog(null,"Has accedido a: Ofertas y Promociones.");
								break;
							case 2:
								JOptionPane.showMessageDialog(null,"Has accedido a: Relación Cliente/Oferta.");
								break;
							case 3:
								JOptionPane.showMessageDialog(null,"Has accedido a: Correo Electrónico.");
								break;
							case 4:
								JOptionPane.showMessageDialog(null,"Has accedido a: Gestión de Servivio Integral de Rev. Téc. ITV.");
								break;
							case 5:
								JOptionPane.showMessageDialog(null,"A continuación se le devolverá al menú principal.");
								break;
							default:
								JOptionPane.showMessageDialog(null,"Opción no válida.");
						}
					
					}while(opcion!=5);
					break;
				case 3:
					JOptionPane.showMessageDialog(null,"Has accedido a: Jefatura.");
					do{
						//Mensaje de bienvenida.
						StringOpcion=JOptionPane.showInputDialog("Seleccione el tipo de acción a realizar:\n1. Gestión de Operaciones de Mecánicos.\n2. Gestión de Operaciones de Comerciales.\n3. Gestión de Trabajadores.\n4. Listados.\n5. Salir");
						//Sistema de control para evitar que el usuario introduzca valores no numéricos.
						try{
							opcion=Integer.parseInt(StringOpcion);
						}catch(NumberFormatException ex){
							JOptionPane.showMessageDialog(null,  "Error, solo se permiten números.");
							opcion=0;
						}
						//Menú principal de gestión de actividades para comerciales..
						switch(opcion){
							case 0:
								JOptionPane.showMessageDialog(null,"Opción no válida. Por favor, introduzca un valor del menú.");
								break;
							case 1:
								JOptionPane.showMessageDialog(null,"Has accedido a: Gestión de Operaciones de Mecánicos.");
								break;
							case 2:
								JOptionPane.showMessageDialog(null,"Has accedido a: Gestión de Operaciones de Comerciales.");
								break;
							case 3:
								JOptionPane.showMessageDialog(null,"Has accedido a: Gestión de Trabajadores.");
								break;
							case 4:
								JOptionPane.showMessageDialog(null,"Has accedido a: Listados.");
								break;
							case 5:
								JOptionPane.showMessageDialog(null,"A continuación se le devolverá al menú principal.");
								break;
							default:
								JOptionPane.showMessageDialog(null,"Opción no válida.");
						}
					
					}while(opcion!=5);
					break;
				case 4:
					JOptionPane.showMessageDialog(null,"Adiós. Espero verle pronto.");
					break;
				default:
					JOptionPane.showMessageDialog(null,"Opción no válida.");
			}
			//*********************************************************************************************************************************
			//FIN SWITCH 1: Menú principal de selección de Usuarios
			//*********************************************************************************************************************************	
		
		
		}while(opcion!=4); // CIERRO PRIMER DO
		
	
		//*********************************************************************************************************************************
		//FIN DOwhile 1: Sección Principal
		//*********************************************************************************************************************************
	}
	
}
