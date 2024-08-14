package com.sametakgul.custom_anotation.anotation;

import com.sametakgul.custom_anotation.exception.CustomException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoleAspect {

    @Before("@annotation(hasRole)")
    public void checkUserRole(JoinPoint joinPoint, HasRole hasRole) {
        String requiredRole = hasRole.role();
        boolean isRoleRequired = hasRole.required();

        String currentUserRole = getCurrentUserRole();

        if (isRoleRequired && !currentUserRole.equals(requiredRole)) {
            throw new CustomException("Erişim reddedildi: Rol yeterli değil.");
        }
    }

    /**
     * As example
     * @return
     */
    private String getCurrentUserRole() {
        return "USER";
    }
}
