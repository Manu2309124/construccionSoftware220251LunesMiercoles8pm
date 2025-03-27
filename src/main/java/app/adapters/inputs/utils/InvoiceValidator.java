package app.adapters.inputs.utils;

public class InvoiceValidator extends SimpleValidator {
    public double amountValidator(String value)throws Exception{
        return longValidator(value, "cantidad de productos");
    }
    public long invoicedIdValidator(String value)throws Exception{
        return longValidator(value, "id de la factura");
    }
    public double worthValidator(String value)throws Exception{
        return longValidator(value, "Valor de la factura");
    }
    public long dateValidator(String value)throws Exception{
        return longValidator(value, "fecha de la factura");
    }
}
