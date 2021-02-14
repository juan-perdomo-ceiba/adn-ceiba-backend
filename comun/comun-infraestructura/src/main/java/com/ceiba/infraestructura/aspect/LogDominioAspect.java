package com.ceiba.infraestructura.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogDominioAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogDominioAspect.class);

    @After(value = "execution(* com.ceiba.*.servicio.*.ejecutar(..)))")
    public void despuesDeEjecutarMetodo(JoinPoint joinPoint) {
        LOGGER.info("Se ejecuto metodo: " + joinPoint.getSignature());

        Object[] arguments = joinPoint.getArgs();

        for (Object arg: arguments) {
            LOGGER.info("Parametro: " + arg.toString());
        }
    }
}
