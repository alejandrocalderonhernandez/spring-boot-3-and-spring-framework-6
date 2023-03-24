package com.debuggeando_ideas.best_travel.aspects;

import com.debuggeando_ideas.best_travel.util.BestTravelUtil;
import com.debuggeando_ideas.best_travel.util.annotations.Notify;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@Aspect
public class NotifyAspect {

    @After(value = "@annotation(com.debuggeando_ideas.best_travel.util.annotations.Notify)")
    public void notifyInFile(JoinPoint joinPoint) throws IOException {
        var args = joinPoint.getArgs();
        var size = args[1];
        var order = args[2] == null ? "NONE" : args[2];


        var signature = (MethodSignature) joinPoint.getSignature();
        var method = signature.getMethod();
        var annotation = method.getAnnotation(Notify.class);
        var text =
                String.format(LINE_FORMAT, LocalDateTime.now(), annotation.value(), size.toString(), order.toString());
        BestTravelUtil.writeNotification(text, PATH);

    }

    private static final String LINE_FORMAT =  "At %s new request %s, with size page %s and order %s";
    private static final String PATH =  "files/notify.txt";

}
