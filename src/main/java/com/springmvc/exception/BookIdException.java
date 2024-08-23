package com.springmvc.exception;

/**
 * BookIdException 클래스는 특정 도서 ID를 찾을 수 없을 때 발생하는 사용자 정의 예외입니다.
 *
 * <p>이 예외는 런타임 시 발생하며, 도서 ID를 인수로 받아 저장합니다.</p>
 *
 * @author 사용자
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BookIdException extends RuntimeException {

    /**
     * 찾을 수 없는 도서의 ID를 저장하는 필드입니다.
     */
    private String bookId;

    /**
     * 주어진 도서 ID로 BookIdException을 생성합니다.
     *
     * @param bookId 찾을 수 없는 도서의 ID
     */
    public BookIdException(String bookId) {
        this.bookId = bookId;
    }

    /**
     * 저장된 도서 ID를 반환합니다.
     *
     * @return 도서 ID
     */
    public String getBookId() {
        return bookId;
    }
}