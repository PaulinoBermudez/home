/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2017/9/27
 */


public class Text1 {

    
	 public static String getEdad(Date fechaNacimiento) {
	 if (fechaNacimiento != null) {
	 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 StringBuilder result = new StringBuilder();
	 if (fechaNacimiento != null) {
	 result.append(sdf.format(fechaNacimiento));
	 result.append(" (");
	 Calendar c = new GregorianCalendar();
	 c.setTime(fechaNacimiento);
	 result.append(calcularEdad(c));
	 result.append(" años)");
	 }
	 return result.toString();
	 }
	 return "";
	 }

	 private static int calcularEdad(Calendar fechaNac) {
	 Calendar today = Calendar.getInstance();
	 int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
	 int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
	 int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
	 // Si está en ese año pero todavía no los ha cumplido
	 if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
	 diffYear = diffYear - 1; // no aparecían los dos guiones del postincremento
	 }
	 return diffYear;
	 }
     
    
    
}