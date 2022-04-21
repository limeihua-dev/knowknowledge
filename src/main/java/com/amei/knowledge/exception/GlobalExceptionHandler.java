package com.amei.knowledge.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//
//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-data-mongodb</artifactId>
//</dependency>
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 捕获MissingServletRequestParameterException异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public ResponseEntity<Object> errorHandler(MissingServletRequestParameterException ex) {
        log.error("- 接口请求query参数非法异常处理 -");
        return ResponseUtils.error(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /**
     * 捕获HttpMessageNotReadableException异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<Object> errorHandler(HttpMessageNotReadableException ex) {
        log.error("- 接口请求body参数非法异常处理 -");
        return ResponseUtils.error(HttpStatus.BAD_REQUEST, "Required request body is missing");
    }

    /**
     * JSON格式非法异常处理 JsonProcessingException
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = JsonProcessingException.class)
    @ResponseBody
    public ResponseEntity<Object> errorHandler(JsonProcessingException ex) {
        log.error("- JSON格式非法异常处理 -");
        return ResponseUtils.error(HttpStatus.BAD_REQUEST, "请求数据类型不是合法的JSON结构");
    }

    /**
     * 捕获MethodArgumentTypeMismatchException异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<Object> errorHandler(MethodArgumentTypeMismatchException ex) {
        log.error("- 接口参数类型非法异常处理 -");
        return ResponseUtils.error(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /**
     * 捕获UncategorizedMongoDbException异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = UncategorizedMongoDbException.class)
    @ResponseBody
    public ResponseEntity<Object> errorHandler(UncategorizedMongoDbException ex) {
        log.error("- MongoDb数据库连接异常处理 -");
        return ResponseUtils.error(HttpStatus.BAD_REQUEST, "数据库连接失败："+ex.getMessage());
    }

    /**
     * 数据验证格式异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object> errorHandler(MethodArgumentNotValidException ex) {
        log.error("- Pojo实体类属性校验异常 -");
        BindingResult result = ex.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        for (ObjectError error : result.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(",");
            break;
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        return ResponseUtils.error(HttpStatus.BAD_REQUEST, errorMsg.toString());
    }

    /**
     * 捕获PropertyReferenceException异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = PropertyReferenceException.class)
    @ResponseBody
    public ResponseEntity<Object> errorHandler(PropertyReferenceException ex) {
        log.error("- 接口请求参数PropertyReference异常处理 -");
        return ResponseUtils.error(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    /**
     * 系统自定义异常处理
     *
     * @param globalException
     * @return
     */
    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public ResponseEntity<Object> globalExceptionHandler(GlobalException globalException) {
        log.error("- 自定义异常 -");
        return ResponseUtils.error(globalException.getHttpStatus(), globalException.getErrorMsg());
    }
}
