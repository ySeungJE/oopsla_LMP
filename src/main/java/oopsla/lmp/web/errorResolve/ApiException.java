package oopsla.lmp.web.errorResolve;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ApiException {
    private String code;
    private String message;
}
