import java.util.*;


/**
 * The SymTable class represents a symbol table.
 */
public class SymTable {
    //The list stores the SymTable
    private List<HashMap<String, Sym>> symList = new LinkedList<>();

    /**
     * The constructor; it initializes the SymTable's List field
     * to contain a single, empty HashMap.
     */
    public SymTable() {
        symList.add(new HashMap<>());
    }

    /**
     * Add the given name and sym to the first HashMap in the list if there's no
     * exceptions need to be thrown.
     * 
     * @param name						the name of the Sym
     * @param sym						the symbol
     * @throws EmptySymTableException	If this SymTable's list is empty
     * @throws NullPointerException		If either name or sym (or both) is null
     * @throws DuplicateSymException	If the first HashMap in the list already
     * contains the given id name as a key
     */
    public void addDecl(String name, Sym sym)
            throws DuplicateSymException, EmptySymTableException, NullPointerException {
        if (symList.isEmpty()) {
            throw new EmptySymTableException();
        }
        if (name == null && sym == null) {
            throw new NullPointerException();
        }
        if (name == null) {
            throw new NullPointerException();
        }
        if (sym == null) {
            throw new NullPointerException();
        }
        if (symList.get(0).containsKey(name)) {
            throw new DuplicateSymException();
        }
        symList.get(0).put(name, sym);
    }


    /**
     * Add a new, empty HashMap to the front of the list.
     */
    public void addScope() {
        symList.add(0, new HashMap<>());
    }

    /**
     * @param name						the name of the Sym
     * @return							the associated Sym if the first 
     * HashMap in the list contains name as a key; otherwise, return null.
     * @throws EmptySymTableException	If this SymTable's list is empty
     */
    public Sym lookupLocal(String name) throws EmptySymTableException {
        if (symList.isEmpty()) {
            throw new EmptySymTableException();
        }
        if (symList.get(0).containsKey(name)) {
            return symList.get(0).get(name);
        }
        return null;
    }

    /**
     * @param name						the name of the Sym
     * @return							the associated Sym if any 
     * HashMap in the list contains name as a key; otherwise, return null.
     * @throws EmptySymTableException	If this SymTable's list is empty
     */
    public Sym lookupGlobal(String name) throws EmptySymTableException {
        if (symList.isEmpty()) {
            throw new EmptySymTableException();
        }
        for (HashMap<String, Sym> M : symList) {
            if (M.containsKey(name)) {
                return M.get(name);
            }
        }
        return null;
    }

    /**
     * remove the HashMap from the front of the list.
     *
     * @throws EmptySymTableException	If this SymTable's list is empty
     */
    public void removeScope() throws EmptySymTableException {
        if (symList.isEmpty()) {
            throw new EmptySymTableException();
        }
        symList.remove(0);
    }


    /**
     * This method is for debugging.
     */
    public void print() {
        System.out.print("\nSym Table\n");
        for (HashMap<String, Sym> M : symList) {
            System.out.println(M.toString());
        }
        System.out.println();
    }
}