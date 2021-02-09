package com.ceiba.infraestructura.aspect;
import com.ceiba.infraestructura.error.ManejadorError;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogDominioAspect {

    private static final Logger LOGGER_DOMINIO = LoggerFactory.getLogger(LogDominioAspect.class);

    @After(value = "execution(* com.ceiba.*.servicio.*.ejecutar(..)))")
    public void despuesDeEjecutarMetodo(JoinPoint joinPoint) {
        LOGGER_DOMINIO.info("Se ehecuto metodo: " + joinPoint.getSignature());

        Object[] arguments = joinPoint.getArgs();

        for (Object arg: arguments) {
            LOGGER_DOMINIO.info("Parametro: " + arg.toString());
        }
    }
}
