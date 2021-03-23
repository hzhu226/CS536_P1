/**
 * The Sym class represents the symbol in the symbol table.
 */
public class Sym {
    // Type of the symbol
    private String type;

    /**
     * The constructor; it initializes the symbol to have the given type.
     *
     * @param type	symbol type
     */
    public Sym(String type) {
        this.type = type;
    }

    /**
     * @return	this Sym's type.
     */
    public String getType() {
        return type;
    }

    /**
     * @return	this Sym's type.
     */
    @Override
    public String toString() {
        return type;
    }
}