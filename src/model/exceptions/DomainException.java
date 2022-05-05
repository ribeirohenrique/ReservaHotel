package model.exceptions;

import java.io.Serial;

public class DomainException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    //Passo a mensagem para ser exibida quando chamar este método
    public DomainException(String msg) {
        super(msg);
    }
}
