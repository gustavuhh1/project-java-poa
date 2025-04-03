package com.gustavuhh1.POA.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Pointcut("within(com.gustavuhh1.POA.controller..*)")
    public void controllerMethod(){

    }

    @Pointcut("within(com.gustavuhh1.POA.service..*)")
    public void serviceMethod(){

    }

    // Pointcut para todos os metodos
    @Before("controllerMethod() || serviceMethod()")
    public void logBefore(JoinPoint joinPoint){
        log.info("Iniciando execução de metódo: {} - arg: {}",
                joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    // Adevice que executa depois do metodo (sucesso)
    @AfterReturning(pointcut = "controllerMethod() || serviceMethod()", returning = "resultado")
    public void logAfterReturning(JoinPoint joinPoint, Object resultado){
        log.info("Metodo: {} executado com sucesso - Retorno: {}",
                joinPoint.getSignature().getName(), resultado);
    }

    // Adevice que executa quando ocorre um exceção.
    @AfterThrowing(pointcut = "controllerMethod() || serviceMethod()", throwing = "throwable")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable throwable){
        log.info("Exceção no metodo {} - Mensagem: {}",
                joinPoint.getSignature().getName(), throwable.getMessage());
    }
}

