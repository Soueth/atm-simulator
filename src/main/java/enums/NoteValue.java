package enums;

public enum NoteValue {
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200);

    private final int value;

    NoteValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
