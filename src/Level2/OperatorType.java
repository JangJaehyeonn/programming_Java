package Level2;

public enum OperatorType {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    MODULO('%');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    /**
     * char operator 값을 받아 해당하는 OperatorType 을 반환하는 정적 메서드 추가
     */
    public static OperatorType fromOperator(char operator) {
        for (OperatorType type : OperatorType.values()) {
            if(type.symbol == operator) {
                return type;
            }
        }
        throw new IllegalArgumentException("해당하는 연산자가 없습니다. " + operator);
    }
}
