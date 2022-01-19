public class Main {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Four");
        list.add(2, "Three");
        printMyLinkedList(list, " init array ");

        list.remove(0);
        list.remove("Four");
        printMyLinkedList(list, " delete some elements ");
        System.out.println(list.size());

        list.add("Six");
        list.add("Seven");
        System.out.println(list.size());
        list.set(1, "Five");
        printMyLinkedList(list, " add, set some elements ");

    }

    public static void printMyLinkedList(MyLinkedList list, String msg) {
        System.out.printf("---%s---\n", msg);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("---------------------");
    }
}
