package com.qacorn.rongcloud.result;


import com.qacorn.rongcloud.constant.ErrorCode;
import com.qacorn.rongcloud.constant.ErrorMessage;
import com.qacorn.rongcloud.constant.GlobalConstant;
import com.qacorn.rongcloud.utility.LogUtility;
import org.apache.ibatis.javassist.tools.web.BadHttpRequest;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class SpongeExceptionHandler {

    @ExceptionHandler(value = SpongeException.class)
    public SpongeResult<String> handleSpongeException(SpongeException exception){
        if (exception.getPrintErrorStack()){
            exception.printStackTrace();
        }
        LogUtility.error(this.getClass(),"sponge exception : {}",exception.getDebugMessage());
        return SpongeResultGenerator.getFromSpongeException(exception);
    }



    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public SpongeResult<String> handlerMethodNotSupported(HttpRequestMethodNotSupportedException e){
        LogUtility.error(this.getClass(), ErrorMessage.request_method_not_supported,e.getMessage());
        return new SpongeResult<>(ErrorCode.REQUEST_METHOD_NOT_SUPPORTED, ErrorMessage.request_method_not_supported, GlobalConstant.ERROR);
    }

    @ExceptionHandler(value = TypeMismatchException.class)
    public SpongeResult<String> handleTypeMismatch(TypeMismatchException e){
        LogUtility.error(this.getClass(), ErrorMessage.type_mismatch,e.getMessage());
        return new SpongeResult<>(ErrorCode.TYPE_MISMATCH, ErrorMessage.type_mismatch, GlobalConstant.ERROR);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public SpongeResult<String> handleMissingParameter(MissingServletRequestParameterException e){
        LogUtility.error(this.getClass(), ErrorMessage.missing_parameter,e.getMessage());
        return new SpongeResult<>(ErrorCode.MISSING_PARAMETER, ErrorMessage.missing_parameter, GlobalConstant.ERROR);
    }


    @ExceptionHandler(value = NoHandlerFoundException.class)
    public SpongeResult<String> handlerException(NoHandlerFoundException e){
        LogUtility.error(this.getClass(), ErrorMessage.resource_not_found,e.getMessage());
        return new SpongeResult<>(ErrorCode.RESOURCE_NOT_FOUND, ErrorMessage.resource_not_found, GlobalConstant.ERROR);
    }

    @ExceptionHandler(value = BadHttpRequest.class)
    public SpongeResult<String> handlerBadHttpRequest(BadHttpRequest e){
        LogUtility.error(this.getClass(), ErrorMessage.http_exception,e.getMessage());
        return new SpongeResult<>(ErrorCode.HTTP_EXCEPTION, ErrorMessage.http_exception, GlobalConstant.ERROR);
    }

//    @ExceptionHandler(value = Exception.class)
//    public SpongeResult<String> handleHttpException(Exception exception){
//        return new SpongeResult<>(ErrorCode.HTTP_EXCEPTION, ErrorMessage.http_exception, GlobalConstant.ERROR);
//    }
}
