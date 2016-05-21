package storage;

class DBHasDataException extends Exception {

    public DBHasDataException() {}

    public DBHasDataException(String message) {
        super(message);
    }

    public DBHasDataException(Throwable cause) {
        super(cause);
    }

    public DBHasDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBHasDataException(String message, Throwable cause, boolean enableSuppresion, boolean writeStackTrace) {
        super(message, cause, enableSuppresion, writeStackTrace);
    }

}
