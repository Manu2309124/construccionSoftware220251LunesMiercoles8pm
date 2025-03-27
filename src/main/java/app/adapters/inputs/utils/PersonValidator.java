package app.adapters.inputs.utils;

public class PersonValidator extends SimpleValidator {
	
	public String nameValidator(String value) throws Exception {
		return stringValidator(value, "nombre de la persona ");
	}
	
	public long documentValidator(String value)throws Exception {
		return longValidator(value, " numero de documento ");
	}
	
	 public Long ageValidator(String value) throws Exception{
	     return longValidator(value, "edad de la persona");
	    }

}
