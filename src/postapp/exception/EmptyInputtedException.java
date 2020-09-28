package postapp.exception;

public class EmptyInputtedException extends EmptyException {
    public EmptyInputtedException() {
        super("データを入力されていません。");
    }
}
