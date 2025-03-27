package app.adapters.inputs.utils;

public class ClinicalRecordValidator {
	public String ClinicalrecordValidator(String value)throws Exception{
        return stringValidator(value, "datos de hitoria clinica");
    }
    public long clinicalrecordIdValidator(String value)throws Exception{
        return longValidator(value, "id clinica");
    }
}


