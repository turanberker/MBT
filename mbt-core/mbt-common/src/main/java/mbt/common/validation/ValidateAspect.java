package mbt.common.validation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidateAspect {
//Çalışıyor
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void restControllerPointcut() {
    }

    @Pointcut("@annotation(mbt.common.validation.MbtValidate)")
    public void validatebleMethods() {}

    @Before("restControllerPointcut() && validatebleMethods()")
    public void validate(JoinPoint joinPoint) throws Exception {

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof MbtValidator) {
                ((MbtValidator) arg).validate();
            }
        }
    }
}
