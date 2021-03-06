package com.hong.exception.file;


import com.hong.exception.BaseException;

/**
 * 文件信息异常类
 *
 * @author hong
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}
