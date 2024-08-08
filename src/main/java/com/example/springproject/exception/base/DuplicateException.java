package com.example.springproject.exception.base;

import static com.example.springproject.constant.ExceptionCode.DUPLICATE_CODE;

public class DuplicateException extends BaseException{
    public DuplicateException() {
        setCode(DUPLICATE_CODE);
        setStatus(StatusConstants.BAD_REQUEST);
    }
}
