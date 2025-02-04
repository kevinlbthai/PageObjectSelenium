package codebase;

class CDslTodoListName {
    private final String name;

    public CDslTodoListName() {
        this(new CDslRandomString("-").generate());
    }

    public CDslTodoListName(final String todoListName) {
        this.name = todoListName;
        System.out.println("Generate TODO LIST: " + name);
    }

    public String getName() {
        return name;
    }

}
