package app.adapters.inputs.utils;

public class OrderValidator extends SimpleValidator {

    public String nameValidator(String value) throws Exception{
        return stringValidator(value, "nombre del medicamento");
    }
    public double dategenerationValidator(String value) throws Exception{
        return DateValidator(value, "fecha de generacion");
    }

    public long orderIdValidator(String value)throws Exception{
        return longValidator(value, "id orden");
    }
}


