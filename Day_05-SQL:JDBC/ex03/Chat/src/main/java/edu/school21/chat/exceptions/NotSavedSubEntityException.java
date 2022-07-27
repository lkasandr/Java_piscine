package edu.school21.chat.exceptions;

public class NotSavedSubEntityException extends RuntimeException
{
    @Override
    public String getMessage()
    {
        return ("Идентификатор отсутствует.");
    }
}
